package kekolab.javaplex.model;

import java.net.URI;

public interface PlexTranscodeSession {
    String getKey();

    URI key();

    Boolean getThrottled();

    Boolean getComplete();

    Double getProgress();

    Integer getSize();

    Double getSpeed();

    Boolean getError();

    Long getDuration();

    Long getRemaining();

    String getContext();

    String getSourceVideoCodec();

    String getSourceAudioCodec();

    String getVideoDecision();

    String getAudioDecision();

    String getProtocol();

    String getContainer();

    String getVideoCodec();

    String getAudioCodec();

    Integer getAudioChannels();

    Boolean getTranscodeHwRequested();

    Double getTimeStamp();

    Double getMaxOffsetAvailable();

    Double getMinOffsetAvailable();

}
