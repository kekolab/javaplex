package kekolab.javaplex.model;

import java.net.URI;
import java.util.List;

public interface PlexPart {

    Integer getHeight();

    Integer getWidth();

    String getProtocol();

    String getDecision();

    Boolean getSelected();

    Integer getOrientation();

    Integer getId();

    Long getDuration();

    String getFile();

    String getContainer();

    String getVideoProfile();

    Long getSize();

    String getAudioProfile();

    Boolean getHas64bitOffsets();

    Boolean getOptimizedForStreaming();

    Integer getHasThumbnail();

    List<PlexStream> getStreams();

    Boolean getAccessible();

    Boolean getExists();

    Integer getDeepAnalysisVersion();

    List<Integer> getRequiredBandwidths();

    String getKey();

    URI key();

}