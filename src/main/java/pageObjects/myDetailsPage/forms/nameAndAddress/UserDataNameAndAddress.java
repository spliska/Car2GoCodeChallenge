package pageObjects.myDetailsPage.forms.nameAndAddress;

public class UserDataNameAndAddress {
    private final Integer salutationIndex;
    private final String salutation;
    private final String firstName;
    private final String lastName;
    private final String birthplace;
    private final String streetAndNumber;
    private final String addressLineTwo;
    private final String postalCode;
    private final String city;
    private final Integer countryIndex;
    private final String country;
    private final Integer languageIndex;
    private final String language;
    private final String email;

    public UserDataNameAndAddress(Integer salutationIndex, String salutation, String firstName, String lastName, String birthplace, String streetAndNumber, String addressLineTwo, String postalCode, String city, Integer countryIndex, String country, Integer languageIndex, String language, String email) {
        this.salutationIndex = salutationIndex;
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthplace = birthplace;
        this.streetAndNumber = streetAndNumber;
        this.addressLineTwo = addressLineTwo;
        this.postalCode = postalCode;
        this.city = city;
        this.countryIndex = countryIndex;
        this.country = country;
        this.languageIndex = languageIndex;
        this.language = language;
        this.email = email;
    }

    public Integer getSalutationIndex() {
        return salutationIndex;
    }

    private String getSalutation() {
        return salutation;
    }

    private String getFirstName() {
        return firstName;
    }

    private String getLastName() {
        return lastName;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public Integer getCountryIndex() {
        return countryIndex;
    }

    public String getCountry() {
        return country;
    }

    public Integer getLanguageIndex() {
        return languageIndex;
    }

    private String getLanguage() {
        return language;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public final boolean equals(final Object object) {
        if (object.getClass().equals(UserDataNameAndAddress.class)) {
            UserDataNameAndAddress castUserDataNameAndAddress = ((UserDataNameAndAddress) object);

            return salutation.equals(castUserDataNameAndAddress.getSalutation()) &&
                    firstName.equals(castUserDataNameAndAddress.getFirstName()) &&
                    lastName.equals(castUserDataNameAndAddress.getLastName()) &&
                    birthplace.equals(castUserDataNameAndAddress.birthplace) &&
                    streetAndNumber.equals(castUserDataNameAndAddress.getStreetAndNumber()) &&
                    addressLineTwo.equals(castUserDataNameAndAddress.getAddressLineTwo()) &&
                    postalCode.equals(castUserDataNameAndAddress.getPostalCode()) &&
                    city.equals(castUserDataNameAndAddress.getCity()) &&
                    country.equals(castUserDataNameAndAddress.getCountry()) &&
                    language.equals(castUserDataNameAndAddress.getLanguage()) &&
                    email.equals(castUserDataNameAndAddress.getEmail());

        } else {
            return false;
        }
    }
}
