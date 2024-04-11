# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [5.0.1] 2024-04-11

### Fixed

- Fixed bug in PlexMetadata.update

## [5.0.0] 2024-04-11

### Added

- Filterable queries. Now all the filterable section queries (such as `PlexMusicSection.albums` or `PlexMovieSection.all`) can be filter-queried by means of a PlexSectionQueryBuilder
- Filters can be built by means of class `PlexFilterBuilder` and of `PlexFilterableField` defined in each `PlexMediatag`
- Support for Smart playlists (old playlists have been renamed `PlexClassicPlaylist`)
- Services introduces:
  - `PlexPlaylists`: a service to create or delete or altering playlists
  - `PlexCollections`: a service to create or delete or altering collections
  - `PlexServerShares`: a service to work on `PlexServerShare`s
  - ...

### Changed

- General refactoring, class renaming and simplification.
- `PlexPlaylist` has become a parameterized class: no more three specific class (`PlexAudioPlaylist`, `PlexVideoPlaylist`, `PlexPhotoPlaylist`), which would've become six with the smart playlists
- `PlexCollection` has become a parameterized class: no more six specific classes


## [4.1.1] 2024-03-28

### Fixed

- Fixed wrong type_id in PlexAlbum

## [4.1.0] 2024-03-26

### Added

- Added methods to retrieve all tracks from a MusicSection and all episodes from a ShowSection

## [4.0.0] 2024-03-26

### Changed

- Created (public) interfaces with the methods to be used by the library consumers
- Created implementation classes. These are not public, but have the default modifier. This way the library users cannot use the (public) setters (casting to the implementation classes is forbidden), which can, anyway, still be used by Jackson during serialization/deserialization
- The items with editable properties (`PlexArtist`, `PlexMovie`, and so on... ) do not have anymore the `edit*` methods to alter the metadata, but an editor can be retrieved calling the `editor()` method which exposes all the methods to alter the metadata

## [3.3.0] 2024-03-01

- Created a new entry point (class PlexApi)
- Marked Deprecated the things accessible with the new entry point
- Added (partial) support to /servers public remote services
  - Listing the servers (/servers)
  - Listing the servers and the sections (/servers/{machineId})
  - Listing the server shares (/servers/{machineId}/shared_servers)
  - Creating a server share (i.e. send a friend request)

## [3.2.0] 2024-03-01

### Added

- Listing the active transcoding sessions (endpoint `/transcode/sessions`)
- Killing a transcode session

## [3.1.0] 2024-03-01

### Added

- Support for listing all the active sessions (endpoint `/status/sessions`)

### Fixed 

- Bug fix on class PlexMedia