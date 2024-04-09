package kekolab.javaplex.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PlexSharingSettings {
    PlexSharingSettings DEFAULT = new PlexSharingSettings() {
        @Override
        public Map<String, List<String>> getFilterMovies() {
            return new HashMap<>();
        }

        @Override
        public Map<String, List<String>> getFilterTelevision() {
            return new HashMap<>();
        }

        @Override
        public Map<String, List<String>> getFilterMusic() {
            return new HashMap<>();
        }

        @Override
        public Boolean getAllowSync() {
            return false;
        }

        @Override
        public Boolean getAllowCameraUpload() {
            return false;
        }

        @Override
        public Boolean getAllowChannels() {
            return false;
        }
    };

    Map<String, List<String>> getFilterMovies();

    Map<String, List<String>> getFilterTelevision();

    Map<String, List<String>> getFilterMusic();

    Boolean getAllowSync();

    Boolean getAllowCameraUpload();

    Boolean getAllowChannels();

}