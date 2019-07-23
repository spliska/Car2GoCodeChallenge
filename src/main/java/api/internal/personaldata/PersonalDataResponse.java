package api.internal.personaldata;

import api.internal.Meta;

public class PersonalDataResponse {
    private Body body;
    private Meta meta;

    public PersonalDataResponse(Body body, Meta meta) {
        this.body = body;
        this.meta = meta;
    }

    public Body getBody() {
        return body;
    }

    public Meta getMeta() {
        return meta;
    }

    @Override
    public final boolean equals(final Object object) {
        if (object.getClass().equals(PersonalDataResponse.class)) {
            PersonalDataResponse castPersonalData = (PersonalDataResponse) object;
            return this.getBody().getPersonalDataRTO().equals(castPersonalData.getBody().getPersonalDataRTO()) ;/*&&
                    this.getMeta().getMetaDataArray().equals(castPersonalData.getMeta().getMetaDataArray());*/

        } else {
            return false;
        }
    }
}
