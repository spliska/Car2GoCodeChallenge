package api.internal.personaldata;

import api.internal.personaldata.PersonalDataRTO;

public class Body {
    private PersonalDataRTO personalDataRTO;

    public Body(PersonalDataRTO personalDataRTO) {
        this.personalDataRTO = personalDataRTO;
    }

    public PersonalDataRTO getPersonalDataRTO() {
        return personalDataRTO;
    }
}
