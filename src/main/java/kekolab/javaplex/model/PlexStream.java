package kekolab.javaplex.model;

import java.util.List;

public interface PlexStream {

    String getDecision();

    String getLocation();

    Boolean getDefault();

    String getCodec();

    Integer getId();

    Integer getStreamType();

    Integer getIndex();

    String getKey();

    Integer getBitrate();

    Boolean getForced();

    String getDisplayTitle();

    Boolean getHeaderCompression();

    String getLanguage();

    String getLanguageCode();

    String getLanguageTag();

    String getExtendedDisplayTitle();

    String getTitle();

    Integer getStreamIdentifier();

    List<Integer> getRequiredBandwidths();

}