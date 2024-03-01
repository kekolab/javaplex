# javaplex

A Java library to interact with Plex Media Server.

The library can _query_ the server, _edit_ and _delete_ the items on the server (Playlists, Collections, Artists, Album, Track, ...). The library _does not_ upload or delete the items of the server, although it has the capability to delete playlists and collections.

It works both with remotely-available (public) servers and local servers

## Integration

You can use jitpack.io. Click on the following badge for instructions for several building tools.

[![](https://jitpack.io/v/kekolab/javaplex.svg)](https://jitpack.io/#kekolab/javaplex)


## Creating a client

The first step to use this library is to create a `PlexHTTPClient`. The most basic way to do it is

```java
PlexHTTPClient client = new PlexHTTPClientBuilder().build();
```

which is OK if you need to access local servers. If you need to access publicly-available servers, anyway, you will need to give some informations about your app and to authorize the app itself. In this case, the most basic client **must** define at least:

- a plex product
- a product version
- a plex client identifier

Thus, the most basic way to build a `PlexHTTPClient` is:

```java
PlexHTTPClient client = new PlexHTTPClientBuilder()
 .withPlexProduct("myPlexProduct")
 .withPlexProductVersion("myProductVersion")
 .withPlexClientIdentifier("myClientIdentifier")
 .build();
```

In case a more customised client (for example to use a proxy) can be built (please see the tests).

## Authorizing the app (mandatory only to access public servers)

Using a client built with a Plex product, a Plex Product Version and a Plex Client Identifier, an authorization step is required to access a public server. The only supported authentication scheme is the PIN-based authentication scheme. Hereby the steps to authenticate an app:

### Create a Plex Authorizer, request a PIN and extract the code

```java
PlexAuthorizer authorizer = new PlexAuthorizer(client);
PlexPin pin = authorizer.requestAuthenticationPin();
String code = pin.getCode();
```

### Authorize the app

The user must then input the ``code`` on [https://www.plex.tv/link](https://www.plex.tv/link) in order to authorize the app

### Verify the pin

After the user has correctly authorized the app, the authorizer must be used to verify the pin:

```java
PlexPin verifiedPin = authorizer.verifyPin(pin);
```

### Get the authorization token

If the user has authorized the app, the `verifiedPin` will contain the `authorization token`:

```java
String token = pin.getAuthToken();
```

With this token you can access the list of all the publicly-available `resources` (among which the servers) of the user.

## Accessing a server

### Public server

One you have the `authorization token`, you can use it to list all the `resources` visible by the user

```java
PlexResources resources = new Resources(client, token);
List<PlexDevice> devices = resources.getDevices();
PlexDevice serverDevice = devices
 .stream()
 .filter(PlexDevice::isServer) 
 .findAny()
 .get();
PlexConnection publicConnection = serverDevice
 .getConnections()
 .stream()
 // Only devices publicly available, i.e. with at least a non-local connection
 .filter(c -> c.getLocal() == 0)
 .findAny()
 .get();
PlexMediaServer server = serverDevice.toServer(publicConnection);
```

### Local (private) server

To access a local (private) server, you can also use

```java
PlexMediaServer server = new PlexMediaServer(new URI("http://192.168.1.256:32400"), client, token);
```

In this case, the token can also be null:

```java
PlexMediaServer server = new PlexMediaServer(new URI("http://192.168.1.256:32400"), client, null);
```

## Navigating the server

A Plex Media Server has a hierarchical organisation of the content. Starting from the Plex Media Server:

- Plex Media Server
  - Library
    - Sections
    - Recently Added Content
    - On-Deck Content

The Sections can be of four types:

- Music Section
  - Artist
    - Album
      - Track
- TV-Show Section
  - TV Show
    - Season
      - Episode
- Movie Section
  - Movie
- Photo Section
  - Photoalbum
    - Photo
    - Clip

The recently-added content, can contain any of the _media_ defined above: Artist, Album, Track, TV Show, Season, Episode, Movie.

The On-Deck Content, instead, contains only videos, i.e. Episodes or Movies.

You can navigate through the server using the methods provided. For example

### Examples

#### Getting all the artists of a Music Section

```java
List<PlexArtist> artists = server.library()
 .sections() // Get all the sections
 .stream()
 .filter(PlexMusicSection.class::isInstance) // Filter out the non-music ones
 .map(PlexMusicSection.class::cast) // Cast to PlexMusicSections
 .findAny()
 .get()
 .all(); // Get all the artists
```

#### Getting a season of a TV show

```java
PlexSeason season = server.library()
 .sections()
 .stream()
 .filter(PlexShowSection.class::isInstance) // Filter out the non-show ones
 .map(PlexShowSection.class::cast) // Cast to PlexShowSection
 .findAny()
 .get()
 .all() // Get all the shows
 .get(0) // Get the first
 .children() // Get all the seasons
 .get(0); // Get the first
```

#### Getting all the the episodes of a season

```java
List<PlexEpisode> episodes = season.children();
```

## Editing

Editing some of the properties of an item is supported. To edit the property, **do not use** the setter of that property, but the method starting with _edit_. Using the setter **has no effect**.

To make the edit(s) effective, committing them is mandatory:

```java
PlexArtist artist = ... // Retrieve the artist in some way
artist.editTitle("editedTitle");
artist.editSummary("editedSummary");
artist.commitEdits();
```

## More examples

Please see the tests for more use-cases.
