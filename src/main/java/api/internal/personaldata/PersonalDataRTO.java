package api.internal.personaldata;

public class PersonalDataRTO {
    private String salutation;
    private String firstName;
    private String lastName;
    private String addressStreet;
    private String addressAdditionalStreet;
    private String addressZipCode;
    private String addressCity;
    private String addressCountryIsoCode;
    private String language;
    private String birthDate;
    private String birthPlace;
    private String mobilePhone;
    private String email;
    private String emailInValidation;
    private Boolean student;
    private Boolean fullTimeStudent;

    public PersonalDataRTO(String salutation, String firstName, String lastName, String addressStreet, String addressAdditionalStreet, String addressZipCode, String addressCity, String addressCountryIsoCode, String language, String birthDate, String birthPlace, String mobilePhone, String email, String emailInValidation, Boolean student, Boolean fullTimeStudent) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressStreet = addressStreet;
        this.addressAdditionalStreet = addressAdditionalStreet;
        this.addressZipCode = addressZipCode;
        this.addressCity = addressCity;
        this.addressCountryIsoCode = addressCountryIsoCode;
        this.language = language;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.emailInValidation = emailInValidation;
        this.student = student;
        this.fullTimeStudent = fullTimeStudent;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public void setAddressAdditionalStreet(String addressAdditionalStreet) {
        this.addressAdditionalStreet = addressAdditionalStreet;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public void setAddressCountryIsoCode(String addressCountryIsoCode) {
        this.addressCountryIsoCode = addressCountryIsoCode;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmailInValidation(String emailInValidation) {
        this.emailInValidation = emailInValidation;
    }

    public void setStudent(Boolean student) {
        this.student = student;
    }

    public void setFullTimeStudent(Boolean fullTimeStudent) {
        this.fullTimeStudent = fullTimeStudent;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public String getAddressAdditionalStreet() {
        return addressAdditionalStreet;
    }

    public String getAddressZipCode() {
        return addressZipCode;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public String getAddressCountryIsoCode() {
        return addressCountryIsoCode;
    }

    public String getLanguage() {
        return language;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailInValidation() {
        return emailInValidation;
    }

    public Boolean getStudent() {
        return student;
    }

    public Boolean getFullTimeStudent() {
        return fullTimeStudent;
    }

    @Override
    public final boolean equals(final Object object) {
        if (object.getClass().equals(PersonalDataRTO.class)) {
            PersonalDataRTO castPersonalData = (PersonalDataRTO) object;
            return this.salutation.equals(castPersonalData.getSalutation()) &&
                    this.firstName.equals(castPersonalData.getFirstName())
                    && this.lastName.equals(castPersonalData.getLastName())
                    && this.addressStreet.equals(castPersonalData.getAddressStreet())
                    && this.addressAdditionalStreet.equals(castPersonalData.getAddressAdditionalStreet())
                    && this.addressZipCode.equals(castPersonalData.getAddressZipCode())
                    && this.addressCity.equals(castPersonalData.getAddressCity())
                    && this.addressCountryIsoCode.equals(castPersonalData.getAddressCountryIsoCode())
                    && this.language.equals(castPersonalData.getLanguage())
                    && this.birthDate.equals(castPersonalData.getBirthDate())
                    && this.birthPlace.equals(castPersonalData.getBirthPlace())
                    && this.mobilePhone.equals(castPersonalData.getMobilePhone())
                    && this.email.equals(castPersonalData.getEmail())
                    && this.emailInValidation.equals(castPersonalData.getEmailInValidation())
                    && this.student.equals(castPersonalData.getStudent())
                    && this.fullTimeStudent.equals(castPersonalData.getFullTimeStudent());

        } else {
            return false;
        }
    }
}
