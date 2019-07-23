package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.basePage.Page;
import pageObjects.globalElements.MainbarNavigation;
import pageObjects.globalElements.MetabarNavigation;

public class DashboardPage extends Page {

    private final MetabarNavigation metabarNavigation;
    private final MainbarNavigation mainbarNavigation;
    private final By adressDataIcon = By.className("hub-icon-address");
    private final By paymentMethodsIcon = By.className("hub-icon-payment");
    private final By driversLicenseDataIcon = By.className("hub-icon-dl");
    private final By leftTextContainer = By.className("leftContainer");
    private final By rightTextContainer = By.className("rightContainer");


    public DashboardPage(RemoteWebDriver driver) {
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

    public Boolean pageElementsAreDisplayed() {
        return adressDataIsDisplayed();
    }

    public void clickPaymentMethodIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodsIcon));
        driver.findElement(paymentMethodsIcon);
    }

    public String getLeftTextContainerText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(leftTextContainer));
        return driver.findElement(leftTextContainer).getText();
    }

    public void clickDriverLicenseIcon() {
        wait.until(ExpectedConditions.presenceOfElementLocated(driversLicenseDataIcon));
        driver.findElement(driversLicenseDataIcon).getText();

    }

    public String getRightTextContainerText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(rightTextContainer));
        return driver.findElement(rightTextContainer).getText();
    }

    private Boolean adressDataIsDisplayed() {
        wait.until(ExpectedConditions.urlContains("dashboard.html"));
        return driver.findElement(adressDataIcon).isDisplayed();
    }


}
