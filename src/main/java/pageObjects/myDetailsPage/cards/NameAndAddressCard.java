package pageobjects.mydetailspage.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.mydetailspage.forms.nameandaddress.UserDataNameAndAddress;

import java.util.List;

public class NameAndAddressCard {
    private final By nameAndAddressCard = By.id("name-address");
    private final By formField = By.className("form-field");
    private final By formFieldEntry = By.tagName("p");
    private final RemoteWebDriver driver;
    private final WebDriverWait wait;


    public NameAndAddressCard(RemoteWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    public String getSalutation() {
        return getFormFieldEntry(1);
    }

    public String getLastName() {
        return getFormFieldEntry(2);
    }

    public String getFirstName() {
        return getFormFieldEntry(3);
    }

    public String getBirthPlace() {
        return getFormFieldEntry(5);
    }

    public String getStreetAndNumber() {
        return getFormFieldEntry(6);
    }

    public String getAddressLineTwo() {
        return getFormFieldEntry(7);
    }

    public String getPostalCode() {
        return getFormFieldEntry(8);
    }

    public String getCity() {
        return getFormFieldEntry(9);
    }

    public String getCountry() {
        return getFormFieldEntry(10);
    }

    public String getLanguage() {
        return getFormFieldEntry(12);
    }

    public String getEmail() {
        return getFormFieldEntry(16);
    }


    private String getFormFieldEntry(Integer index) {
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.className("main-loader"))));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(nameAndAddressCard), ExpectedConditions.presenceOfElementLocated(formFieldEntry))));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(formField, 16));
        return driver.findElement(nameAndAddressCard).findElements(formField).get(index).findElement(formFieldEntry).getText();
    }


    public UserDataNameAndAddress getAllFormfields() {
        wait.until(ExpectedConditions.presenceOfElementLocated(formFieldEntry));

        List<WebElement> formfields = driver.findElement(nameAndAddressCard).findElements(formField);

        return new UserDataNameAndAddress(null,
                formfields.get(1).findElement(formFieldEntry).getText(),
                formfields.get(2).findElement(formFieldEntry).getText(),
                formfields.get(3).findElement(formFieldEntry).getText(),
                formfields.get(5).findElement(formFieldEntry).getText(),
                formfields.get(6).findElement(formFieldEntry).getText(),
                formfields.get(7).findElement(formFieldEntry).getText(),
                formfields.get(8).findElement(formFieldEntry).getText(),
                formfields.get(9).findElement(formFieldEntry).getText(),
                null,
                formfields.get(10).findElement(formFieldEntry).getText(),
                null,
                formfields.get(12).findElement(formFieldEntry).getText(),
                formfields.get(16).findElement(formFieldEntry).getText());


    }
}
