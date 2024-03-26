# javaplex

A Java library to interact with Plex Media Server.

The library can _query_ the server, _edit_ and _delete_ the items on the server (Playlists, Collections, Artists, Album, Track, ...). The library _does not_ upload or delete the items of the server, although it has the capability to delete playlists and collections.

It works both with remotely-available (public) servers and local servers

## Integration

You can use jitpack.io. Click on the following badge for instructions for several building tools.

[![](https://jitpack.io/v/kekolab/javaplex.svg)](https://jitpack.io/#kekolab/javaplex)

## Usage

### Apache `HttpClient`, Apache `HttpClientBuilder`, `PlexApi.Builder` and `PlexApi`

The entry-point for the library is the class `PlexApi`, which can be built using the Builder `PlexApi.Builder`. The `PlexApi` class makes requests to the remote services using an Apache `HttpClient`. If you do not have particular needs, i.e. you just need to query local servers, you can build the `PlexApi` object as simply as this:

```java
PlexApi.Builder apiBuilder = PlexApi.Builder.withDefaultHttpClient();
PlexApi api = apiBuilder.build();
```

In this case the `PlexApi` will use the default Apache HttpClient. In case you need to customise the backing `HttpClient`, for example to tunnel the requests through a proxy, you can create the necessary `HttpClientBuilder` and then pass it to the `PlexApi.Builder`:

```java
HttpClientBuilder clientBuilder; 
/* Customise the HttpClientBuilder */
PlexApi.Builder apiBuilder = PlexApi.Builder.withCustomHttpClient(clientBuilder);
PlexApi api = apiBuilder.build();
```

So far we have explored the `HttpClient` customisation; the `PlexApi` can be customised as well by adding Plex-related headers to the requests. These headers are needed if you have to interact with remotely-available (i.e. non-local) servers or query the public Plex services.

As far as I am concerned, in case you need to access the public Plex apis, the following properties **must** be defined:

- plex product
- plex product version
- plex client identifier

```java
PlexApi.Builder apiBuilder;
apiBuilder.withPlexProduct("myPlexProduct")
    .withPlexProductVersion("myPlexProductVersion")
    .withPlexClientIdentifier("myPlexClientIdentifier");;
PlexApi api = apiBuilder.build();
```

### Authorizing the app (mandatory only to access public servers)

Using a client built with a Plex product, a Plex Product Version and a Plex Client Identifier, an authorization step is required to access a public server. The only supported authentication scheme is the PIN-based authentication scheme. Hereby the steps to authenticate an app:

#### Create a Plex Authorizer, request a PIN and extract the code

```java
PlexAuthorizer authorizer = new api.getAuthorizer();
PlexPin pin = authorizer.requestAuthenticationPin();
String code = pin.getCode();
```

#### Authorize the app

The user must then input the ``code`` on [https://www.plex.tv/link](https://www.plex.tv/link) in order to authorize the app

#### Verify the pin

After the user has correctly authorized the app, the authorizer must be used to verify the pin:

```java
PlexPin verifiedPin = authorizer.verify(pin);
```

#### Get the authorization token

If the user has authorized the app, the `verifiedPin` will contain the `authorization token`:

```java
String token = verifiedPin.getAuthToken();
```

With this token you can access the list of all the publicly-available `resources` (among which the servers) of the user. You can feed this code to the `PlexApi` through the class `PlexApi.Builder`

```java
PlexApi api;
api.withToken(token);
```

### Accessing a server

If you already know the parameters to access the server, the `PlexApi` class makes several ways to access a server by overloading the method `PlexApi.getMediaServer`, e.g.:

```java
PlexMediaServer mediaServer = api.getMediaServer("serverHostname", serverPort);
```

or

```java
PlexMediaServer mediaServer = api.getMediaServer(serverURI);
```

### Discovering servers

In case you need to discover the servers for an account, the `PlexApi.getResources` method can be used:

```java
PlexApi api;
List<PlexDevice> devices = api.getResources().list();
List<PlexDevice> serverDevices = devices.stream().filter(PlexDevice::isServer).toList();
    for (PlexDevice serverDevice : serverDevices) {
        for (PlexConnection connection : serverDevice.getConnections())
            if (connection.getLocal() == 0)
                try {
                    PlexMediaServer server = api.getMediaServer(connection);
                    break;
                } catch (PlexException e) {
                    e.printStackTrace();
                }
    }
```

In the example above the first publicly-available server is identified.

### Navigating the server

A Plex Media Server has a hierarchical organisation of the content. Starting from the Plex Media Server:

- Plex Media Server
  - Library
    - Sections
      - Music Section
        - Artist
          - Album
            - Track
      - Movie Section
        - Movie
      - TV-Show Section
        - TV Show
          - Season
            - Episode
      - Photo Section
        - Photoalbum
          - Photo
          - Clip
    - Recently Added Content
    - On-Deck Content

The recently-added content, can contain any of the _media_ defined above: Artist, Album, Track, TV Show, Season, Episode, Movie, PhotoAlbum, Photo, Clip.

The On-Deck Content, instead, contains only videos, i.e. Episodes or Movies.

You can navigate through the server using the methods provided. For example:

#### Getting all the artists of a Music Section

```java
PlexMediaServer server;
PlexMusicSection aMusicSection = server
    .library() // The PlexLibrary
    .sections() // All the sections
    .stream()
    .filter(PlexMusicSection.class::isInstance) // Only the music sections
    .map(PlexMusicSection.class::cast) // Let's cast it
    .findAny() // Let's find any
    .get(); // Let's get it (if there is, otherwise an exception is thrown)
List<PlexArtist> artists = aMusicSection.all(); // Let's get all the artists
```

#### Getting a season of a TV show

```java
PlexMediaServer server;
PlexSeason season = server.library()
 .sections()
 .stream()
 .filter(PlexShowSection.class::isInstance)
 .map(PlexShowSection.class::cast) 
 .findAny()
 .get()
 .all() // Get all the shows
 .get(0) // Get the first show
 .children() // Get all the seasons
 .get(0); // Get the first
```

#### Getting all the the episodes of a season

```java
List<PlexEpisode> episodes = season.children();
```

### Editing

Editing some of the properties of an item is supported. To edit the property of a media (any of `PlexArtist`, `PlexAlbum`, `PlexTrack`, `PlexMovie`, ...), get the editor, alter what you want, and remember, to make the edits effective, to _commit_ the edits:

```java
PlexArtist artist;  = ... // Retrieve the artist in some way
PlexArtistEditor editor = artist.editor();
editor.setTitle("newArtistName", Optional.empty());
editor.commit();
```

### Session infos

You can access information on ongoing streaming sessions:

```java
PlexMediaServer server; 
List<PlexMediatag<?>> mediatags = server
    .status()
    .sessions(); // A list of all the items being streamed

// The following lines need to have a session ongoing
PlexMediatag<?> mediatag = mediatags.get(0);
PlexSession session = mediatag.getSession(); // session will have info on the session
mediatag.getSessionKey();
mediatag.getPlayer();

// transcodeSession will have info on the transcoding session
PlexTranscodeSession transcodeSession = mediatag.getTranscodeSession();
transcodeSession.getKey();
```

All and only the transcoding sessions can also be listed in a different way

```java
PlexMediaServer server;
List<PlexTranscodeSession> transcodeSessions = server
    .transcode()
    .sessions(); // All the transcode sessions

PlexTranscodeSession transcodeSession = transcodeSessions.get(0); // The first transcode session
transcodeSession.getKey(); // Accessing a generic property of a transcoding session
```

To kill a transcoding session:

```java
PlexMediaServer server;
PlexTranscode transcode = server.transcode();
PlexTranscodeSession transcodeSession = transcode
    .sessions()
    .get(0);
transcode.killSession(transcodeSession);
```

### Server shares

The library supports listing the active shares and creating new ones. If you want to share all the server sections with the user whose email is `dummy@example.com` and with default settings:

```java
PlexServer server;
PlexServerShares serverShares = server.serverShares();
List<Section> sectionsToShare = server.getSections();
PlexServerShare share = serverShares.inviteFriend("dummy@example.com", sectionsToShare);
```

while if you want to customise the sharing settings:

```java
PlexServer server;
PlexServerShares serverShares = server.serverShares();
List<Section> sectionsToShare = server.getSections();

SharingSettings sharingSettings = new SharingSettings();
sharingSettings.setAllowCameraUpload(true);
sharingSettings.setAllowChannels(false);
sharingSettings.setAllowSync(true);
sharingSettings.setFilterMovies(new HashMap<String, List<String>>());
sharingSettings.setFilterMusic(new HashMap<String, List<String>>());
sharingSettings.setFilterTelevision(new HashMap<String, List<String>>());

PlexServerShare share = serverShares.inviteFriend("dummy@example.com", sectionsToShare, sharingSettings);
```

### More

The library also supports:

- **Playlists** (_only non-smart ones_): listing, creating, deleting, adding items to and removing items from;
- **Collections**: listing, creating, deleting, adding items to and removing items from;
- **Searching**: items on the server can be searched using the method `PlexLibrary.search`

## To-do

Some thigs which could be integrated, but I do not know when I will have the time to do:

- [ ] **Smart playlists**: creating, deleting, listing, altering the filters, ...
- [ ] Add some meaningful logging

Feel free to create a discussion, send an issue or contact me in any way you can think of to suggest, emend, correct add stuff.

## Testing

In case you need to run the tests, these relies on the presence of a file named `src/test/resources/testVariables.properties`, which is **not** synchronised with the github repo (it might contain personal data, such as proxy credentials), defining the following properties:

```properties
plexProduct={PLEX_PRODUCT}
plexProductVersion={PLEX_PRODUCT_VERSION}
plexClientIdentifier={PLEX_CLIENT_IDENTIFIER}
proxyHost={PROXY_PORT}
proxyUser={PROXY_USERNAME}
proxyPass={PROXY_PASSWORD}
```

## Disclaimer

This is a personal project and has no connection with Plex.
I carry it on mainly at night and when I have some spare time from the (paying 😅) job.

All trademarks belong to the respective owners.

## Contributors ✨

Thanks go to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tbody>
    <tr>
      <td align="left" valign="top" width="14.28%"><a href="https://github.com/JZomDev"><img src="https://avatars.githubusercontent.com/u/14265490?v=4" width="100px;" alt="JZomDev"/><br /><sub><b>JZomDev</b></sub></a><br /><a href="https://github.com/kekolab/javaplex/commits?author=JZomDev" title="Code">💻</a></td>
    </tr>
  </tbody>
</table>