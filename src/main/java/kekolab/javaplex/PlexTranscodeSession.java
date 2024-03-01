package kekolab.javaplex;

import java.net.URI;

public class PlexTranscodeSession extends InitialisableItem {
    private UriProvider key;
    private Boolean throttled;
    private Boolean complete;
    private Double progress;
    private Integer size;
    private Double speed;
    private Boolean error;
    private Long duration;
    private Long remaining;
    private String context;
    private String sourceVideoCodec;
    private String sourceAudioCodec;
    private String videoDecision;
    private String audioDecision;
    private String protocol;
    private String container;
    private String videoCodec;
    private String audioCodec;
    private Integer audioChannels;
    private Boolean transcodeHwRequested;
    private Double timeStamp;
    private Double maxOffsetAvailable;
    private Double minOffsetAvailable;

    public PlexTranscodeSession() {
        key = new UriProvider(this::uri);
    }

    public String getKey() {
        return (String) key.getValue();
    }

    public void setKey(String key) {
        this.key.setValue(key);
    }

    public URI key() {
        return key.uri();
    }

    public Boolean getThrottled() {
        return throttled;
    }
    public Boolean getComplete() {
        return complete;
    }
    public Double getProgress() {
        return progress;
    }
    public Integer getSize() {
        return size;
    }
    public Double getSpeed() {
        return speed;
    }
    public Boolean getError() {
        return error;
    }
    public Long getDuration() {
        return duration;
    }
    public Long getRemaining() {
        return remaining;
    }
    public String getContext() {
        return context;
    }
    public String getSourceVideoCodec() {
        return sourceVideoCodec;
    }
    public String getSourceAudioCodec() {
        return sourceAudioCodec;
    }
    public String getVideoDecision() {
        return videoDecision;
    }
    public String getAudioDecision() {
        return audioDecision;
    }
    public String getProtocol() {
        return protocol;
    }
    public String getContainer() {
        return container;
    }
    public String getVideoCodec() {
        return videoCodec;
    }
    public String getAudioCodec() {
        return audioCodec;
    }
    public Integer getAudioChannels() {
        return audioChannels;
    }
    public Boolean getTranscodeHwRequested() {
        return transcodeHwRequested;
    }
    public Double getTimeStamp() {
        return timeStamp;
    }
    public Double getMaxOffsetAvailable() {
        return maxOffsetAvailable;
    }
    public Double getMinOffsetAvailable() {
        return minOffsetAvailable;
    }

    



}
