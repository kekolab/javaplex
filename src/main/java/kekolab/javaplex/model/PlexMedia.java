package kekolab.javaplex.model;

import java.util.List;

public interface PlexMedia {

    String getProtocol();

    Boolean getSelected();

    Integer getId();

    Integer getBitrate();

    Integer getWidth();

    Integer getHeight();

    Integer getAudioChannels();

    String getAudioCodec();

    String getVideoCodec();

    String getContainer();

    String getVideoFrameRate();

    String getVideoProfile();

    Long getDuration();

    Double getAspectRatio();

    String getVideoResolution();

    List<PlexPart> getParts();

    Boolean getOptimizedForStreaming();

    String getAudioProfile();

    Boolean getHas64bitOffsets();

    Integer getOrientation();

    String getKey();

    String getFile();

    Long getSize();

    Integer getIso();

    String getAperture();

    String getExposure();

    String getMake();

    String getModel();

    String getLens();

}