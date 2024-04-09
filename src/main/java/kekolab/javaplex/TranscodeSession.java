package kekolab.javaplex;

import java.net.URI;

import kekolab.javaplex.model.PlexTranscodeSession;

public class TranscodeSession extends InitialisableItem implements PlexTranscodeSession  {
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

    public TranscodeSession() {
        key = new UriProvider(this::uri);
    }

    @Override
    public String getKey() {
        return (String) key.getValue();
    }

    public void setKey(String key) {
        this.key.setValue(key);
    }

    @Override
    public URI key() {
        return key.uri();
    }

    @Override
    public Boolean getThrottled() {
        return throttled;
    }

    @Override
    public Boolean getComplete() {
        return complete;
    }

    @Override
    public Double getProgress() {
        return progress;
    }

    @Override
    public Integer getSize() {
        return size;
    }

    @Override
    public Double getSpeed() {
        return speed;
    }

    @Override
    public Boolean getError() {
        return error;
    }

    @Override
    public Long getDuration() {
        return duration;
    }

    @Override
    public Long getRemaining() {
        return remaining;
    }

    @Override
    public String getContext() {
        return context;
    }

    @Override
    public String getSourceVideoCodec() {
        return sourceVideoCodec;
    }

    @Override
    public String getSourceAudioCodec() {
        return sourceAudioCodec;
    }

    @Override
    public String getVideoDecision() {
        return videoDecision;
    }

    @Override
    public String getAudioDecision() {
        return audioDecision;
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public String getContainer() {
        return container;
    }

    @Override
    public String getVideoCodec() {
        return videoCodec;
    }

    @Override
    public String getAudioCodec() {
        return audioCodec;
    }

    @Override
    public Integer getAudioChannels() {
        return audioChannels;
    }

    @Override
    public Boolean getTranscodeHwRequested() {
        return transcodeHwRequested;
    }

    @Override
    public Double getTimeStamp() {
        return timeStamp;
    }

    @Override
    public Double getMaxOffsetAvailable() {
        return maxOffsetAvailable;
    }

    @Override
    public Double getMinOffsetAvailable() {
        return minOffsetAvailable;
    }

    public void setKey(UriProvider key) {
        this.key = key;
    }

    public void setThrottled(Boolean throttled) {
        this.throttled = throttled;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public void setRemaining(Long remaining) {
        this.remaining = remaining;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setSourceVideoCodec(String sourceVideoCodec) {
        this.sourceVideoCodec = sourceVideoCodec;
    }

    public void setSourceAudioCodec(String sourceAudioCodec) {
        this.sourceAudioCodec = sourceAudioCodec;
    }

    public void setVideoDecision(String videoDecision) {
        this.videoDecision = videoDecision;
    }

    public void setAudioDecision(String audioDecision) {
        this.audioDecision = audioDecision;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    public void setAudioChannels(Integer audioChannels) {
        this.audioChannels = audioChannels;
    }

    public void setTranscodeHwRequested(Boolean transcodeHwRequested) {
        this.transcodeHwRequested = transcodeHwRequested;
    }

    public void setTimeStamp(Double timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setMaxOffsetAvailable(Double maxOffsetAvailable) {
        this.maxOffsetAvailable = maxOffsetAvailable;
    }

    public void setMinOffsetAvailable(Double minOffsetAvailable) {
        this.minOffsetAvailable = minOffsetAvailable;
    }

}
