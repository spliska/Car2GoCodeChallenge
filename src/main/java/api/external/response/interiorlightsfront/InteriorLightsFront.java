package api.external.response.interiorlightsfront;

public class InteriorLightsFront {

  private final Boolean value;
  private final Long timestamp;


    public InteriorLightsFront(Boolean value, Long timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public Boolean getValue() {
        return value;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
