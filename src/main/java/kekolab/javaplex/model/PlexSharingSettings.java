package kekolab.javaplex.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import kekolab.javaplex.BooleanSerializer;
import kekolab.javaplex.FilterMapSerializer;

public interface PlexSharingSettings {
    /**
     * A default implementation of PlexSharedSettings with all the filters empty and
     * all the allows set to false.
     */
    static PlexSharingSettings DEFAULT = new PlexSharingSettings() {
        @Override
        public Map<String, List<String>> getFilterMovies() {
            return new HashMap<>(0);
        }

        @Override
        public Map<String, List<String>> getFilterTelevision() {
            return new HashMap<>(0);
        }

        @Override
        public Map<String, List<String>> getFilterMusic() {
            return new HashMap<>(0);
        }

        @Override
        public Boolean getAllowSync() {
            return Boolean.FALSE;
        }

        @Override
        public Boolean getAllowCameraUpload() {
            return Boolean.FALSE;
        }

        @Override
        public Boolean getAllowChannels() {
            return Boolean.FALSE;
        }
    };

    @JsonSerialize(using = FilterMapSerializer.class)
    Map<String, List<String>> getFilterMovies();

    @JsonSerialize(using = FilterMapSerializer.class)
    Map<String, List<String>> getFilterTelevision();

    @JsonSerialize(using = FilterMapSerializer.class)
    Map<String, List<String>> getFilterMusic();

    @JsonSerialize(using = BooleanSerializer.class)
    Boolean getAllowSync();

    @JsonSerialize(using = BooleanSerializer.class)
    Boolean getAllowCameraUpload();

    @JsonSerialize(using = BooleanSerializer.class)
    Boolean getAllowChannels();
}
