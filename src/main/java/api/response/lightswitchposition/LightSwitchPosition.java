package api.response.lightswitchposition;

public class LightSwitchPosition {
    private final String value;
    private final Long timestamp;

    public LightSwitchPosition(String value, Long timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getValue() {
        return value;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
