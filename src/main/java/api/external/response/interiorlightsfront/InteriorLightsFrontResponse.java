package api.external.response.interiorlightsfront;

public class InteriorLightsFrontResponse {

    private final InteriorLightsFront interiorLightsFront;

    public InteriorLightsFrontResponse(InteriorLightsFront interiorLightsFront) {
        this.interiorLightsFront = interiorLightsFront;
    }

    public InteriorLightsFront getInteriorLightsFront() {
        return interiorLightsFront;
    }

    @Override
    public final boolean equals(final Object object) {
        if (object.getClass().equals(InteriorLightsFrontResponse.class)) {
            InteriorLightsFrontResponse castInteriorLightsFrontResponse = (InteriorLightsFrontResponse) object;
            return castInteriorLightsFrontResponse.getInteriorLightsFront().getValue().equals(this.getInteriorLightsFront().getValue()) &&
                    castInteriorLightsFrontResponse.getInteriorLightsFront().getTimestamp().equals(this.getInteriorLightsFront().getTimestamp());


        } else {
            return false;
        }

    }
}
