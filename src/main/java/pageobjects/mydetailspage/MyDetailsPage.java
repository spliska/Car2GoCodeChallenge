package pageobjects.mydetailspage;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.basepage.Page;
import pageobjects.globalelements.MainbarNavigation;
import pageobjects.globalelements.MetabarNavigation;
import pageobjects.mydetailspage.cards.NameAndAddressCard;
import pageobjects.mydetailspage.forms.YourPasswordForm;
import pageobjects.mydetailspage.forms.nameandaddress.NameAndAddressForm;

public class MyDetailsPage extends Page {


    private final MetabarNavigation metabarNavigation;
    private final MainbarNavigation mainbarNavigation;
    private final By editPersonalInformationButton = By.className("c2g-mydetails-edit-personaldata");
    private final By editPasswordButton = By.className("c2g-mydetails-edit-password");
    private final By editMobilePhoneNumberButton = By.className("c2g-mydetails-edit-mobilePhone");
    private final By editPrivacyPreferencesButton = By.linkText("Edit");



    public MyDetailsPage(RemoteWebDriver driver) {

        super(driver);
        this.metabarNavigation = new MetabarNavigation(driver);
        this.mainbarNavigation = new MainbarNavigation(driver);
    }

    public MetabarNavigation getMetabarNavigation() {
        return metabarNavigation;
    }

    public MainbarNavigation getMainbarNavigation() {
        return mainbarNavigation;
    }

    public NameAndAddressForm openNameAndAddressForm() {
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.className("main-loader"))));
        this.clickEditPersonalInformationButton();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("input"), 5));
        return new NameAndAddressForm(driver);
    }


    public YourPasswordForm openPasswordForm() {
        wait.until(ExpectedConditions.elementToBeClickable(editPasswordButton));
        this.clickEditPasswordButton();
        return new YourPasswordForm(driver);
    }


    private MyDetailsPage clickEditPersonalInformationButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(editPersonalInformationButton));
        driver.findElement(editPersonalInformationButton).click();
        return this;
    }

    private MyDetailsPage clickEditPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(editPasswordButton));
        driver.findElement(editPasswordButton).click();
        return this;

    }

    public MyDetailsPage clickEditMobilePhoneNumberButton() {
        wait.until(ExpectedConditions.elementToBeClickable(editMobilePhoneNumberButton));
        driver.findElement(editMobilePhoneNumberButton).click();
        return this;
    }

    public MyDetailsPage clickEditPrivacyPreferencesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(editPrivacyPreferencesButton));
        driver.findElement(editPrivacyPreferencesButton).click();
        return this;

    }

    public NameAndAddressCard getUserNameAndAddressData() {
        return new NameAndAddressCard(driver);
    }

}
