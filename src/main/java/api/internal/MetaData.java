package api.internal;

public class MetaData {
    private String object;
    private String attribute;
    private String validator;
    private String parameter;
    private String messageKey;

    public MetaData(String object, String attribute, String validator, String parameter, String messageKey) {
        this.object = object;
        this.attribute = attribute;
        this.validator = validator;
        this.parameter = parameter;
        this.messageKey = messageKey;
    }

    public String getObject() {
        return object;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getValidator() {
        return validator;
    }

    public String getParameter() {
        return parameter;
    }

    public String getMessageKey() {
        return messageKey;
    }

    @Override
    public final boolean equals(final Object object) {
        if (object.getClass().equals(MetaData.class)) {
            MetaData castMetalData = (MetaData) object;
            return this.getObject().equals(castMetalData.getObject()) &&
                    this.getAttribute().equals(castMetalData.getAttribute()) &&
                    this.getValidator().equals(castMetalData.getValidator()) &&
                    this.getParameter().equals(castMetalData.getParameter()) &&
                    this.getMessageKey().equals(castMetalData.getMessageKey());


        } else {
            return false;
        }
    }
}
