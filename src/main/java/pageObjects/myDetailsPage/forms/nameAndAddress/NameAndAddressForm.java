package pageobjects.mydetailspage.forms.nameandaddress;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NameAndAddressForm {
    private final By nameAndAddressForm = By.id("name-address");
    private final By salutationSelect = By.name("salutation");
    private final By birthPlaceInput = By.id("birthPlace");
    private final By streetAndHouseNumberInput = By.id("addressStreet");
    private final By addressLineTwoInput = By.id("addressAdditionalStreet");
    private final By postalCodeInput = By.id("addressZipCode");
    private final By cityInput = By.id("addressCity");
    private final By countrySelect = By.id("addressCountryIsoCode");
    private final By languageSelect = By.id("language");
    private final By emailInput = By.id("email");
    private final By cancelButton = By.className("button--secondary");
    private final By saveDataButton = By.className("button--primary");
    private final By mainLoader=By.className("main-loader");
    private final By firstNameInput=By.id("firstName");
    private final By lastNameInput=By.id("lastName");

    private final RemoteWebDriver driver;
    private final WebDriverWait wait;

    public NameAndAddressForm(RemoteWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.className("main-loader"))));


    }

    public NameAndAddressForm clearBirthPlaceInput() {
        wait.until(ExpectedConditions.presenceOfElementLocated(birthPlaceInput));
        driver.findElement(birthPlaceInput).clear();
        return this;
    }

    public NameAndAddressForm clearStreetAndNumberInput() {
        wait.until(ExpectedConditions.presenceOfElementLocated(streetAndHouseNumberInput));
        driver.findElement(streetAndHouseNumberInput).clear();
        return this;
    }

    public NameAndAddressForm clearAdressLineTwoInput() {
        wait.until(ExpectedConditions.presenceOfElementLocated(addressLineTwoInput));
        driver.findElement(addressLineTwoInput).clear();
        return this;
    }

    public NameAndAddressForm clearPostalCodeInput() {
        wait.until(ExpectedConditions.presenceOfElementLocated(postalCodeInput));
        driver.findElement(postalCodeInput).clear();
        return this;
    }

    public NameAndAddressForm clearCityInput() {
        wait.until(ExpectedConditions.presenceOfElementLocated(cityInput));
        driver.findElement(cityInput).clear();
        return this;
    }

    public NameAndAddressForm clearEmailInput() {
        wait.until(ExpectedConditions.presenceOfElementLocated(emailInput));
        driver.findElement(emailInput).clear();
        return this;
    }

    public NameAndAddressForm selectSalutation(Integer index) {

        selectOption(index, salutationSelect);
        return this;
    }

    public NameAndAddressForm makeFirstNameInputEnabled() {
        wait.until(ExpectedConditions.presenceOfElementLocated(firstNameInput));

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("document.getElementById('firstName').removeAttribute('disabled')" );

        return this;
    }

    public NameAndAddressForm makeLastNameInputEnabled() {
        wait.until(ExpectedConditions.presenceOfElementLocated(lastNameInput));

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("document.getElementById('lastName').removeAttribute('disabled')" );

        return this;
    }

    public NameAndAddressForm clearFirstNameInput() {
        wait.until(ExpectedConditions.presenceOfElementLocated(firstNameInput));
        driver.findElement(firstNameInput).clear();
        return this;
    }

    public NameAndAddressForm clearLastNameInput() {
        wait.until(ExpectedConditions.presenceOfElementLocated(lastNameInput));
        driver.findElement(lastNameInput).clear();
        return this;
    }

    public NameAndAddressForm enterFirstName(String firstName){
        enterStringIntoInput(firstName,firstNameInput);
        return this;

    }

    public NameAndAddressForm enterLastName(String lastName){
        enterStringIntoInput(lastName,lastNameInput);
        return this;
    }

    public NameAndAddressForm enterBirthPlace(String birthPlace) {

        enterStringIntoInput(birthPlace, birthPlaceInput);

        return this;
    }


    public NameAndAddressForm enterStreetAndNumber(String address) {

        enterStringIntoInput(address, streetAndHouseNumberInput);

        return this;
    }

    public NameAndAddressForm enterAddressLineTwo(String addressLineTwo) {

        enterStringIntoInput(addressLineTwo, addressLineTwoInput);

        return this;
    }

    public NameAndAddressForm enterPostalCode(String postalCode) {

        enterStringIntoInput(postalCode, postalCodeInput);

        return this;
    }

    public NameAndAddressForm enterCity(String city) {

        enterStringIntoInput(city, cityInput);

        return this;
    }

    public NameAndAddressForm selectCountry(Integer index) {
        selectOption(index, countrySelect);
        return this;
    }

    public NameAndAddressForm selectLanguage(Integer index) {
        selectOption(index, languageSelect);
        return this;
    }

    public NameAndAddressForm enterEmail(String email) {

        enterStringIntoInput(email, emailInput);

        return this;
    }


    public void clickCancel() {
        wait.until(ExpectedConditions.presenceOfElementLocated(nameAndAddressForm));
        driver.findElement(nameAndAddressForm).findElement(cancelButton).click();
    }

    public void clickSaveData() {
        wait.until(ExpectedConditions.presenceOfElementLocated(nameAndAddressForm));
        driver.findElement(nameAndAddressForm).findElement(saveDataButton).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(mainLoader)));

    }


    private void enterStringIntoInput(String stringToEnter, By locater) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locater));
        driver.findElement(locater).sendKeys(stringToEnter);
        wait.until(ExpectedConditions.attributeContains(locater, "value", stringToEnter));
    }

    private void selectOption(Integer index, By locator) {
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(locator), ExpectedConditions.elementToBeClickable(locator)));
        driver.findElement(locator).click();
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
        wait.until(ExpectedConditions.elementToBeSelected(select.getOptions().get(index)));

    }



}
