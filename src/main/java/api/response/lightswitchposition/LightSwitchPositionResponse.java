package api.response.lightswitchposition;

public class LightSwitchPositionResponse {
    private final LightSwitchPosition lightswitchposition;

    public LightSwitchPositionResponse(LightSwitchPosition lightswitchposition) {
        this.lightswitchposition = lightswitchposition;
    }

    public LightSwitchPosition getLightswitchposition() {
        return lightswitchposition;
    }

    @Override
    public final boolean equals(final Object object) {
        if (object.getClass().equals(LightSwitchPositionResponse.class)) {
            LightSwitchPositionResponse castLightSwitchPositionResponse = (LightSwitchPositionResponse) object;
            return castLightSwitchPositionResponse.getLightswitchposition().getValue().equals(this.getLightswitchposition().getValue()) &&
                    castLightSwitchPositionResponse.getLightswitchposition().getTimestamp().equals(this.getLightswitchposition().getTimestamp());
        } else {
            return false;
        }
    }
}
