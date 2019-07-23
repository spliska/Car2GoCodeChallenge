package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.basepage.Page;

public class LoginPage extends Page {

    private final By emailInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.name("login");
    private final By messageContainer = By.id("c2g_messageContainer");


    public LoginPage(RemoteWebDriver driver) {
        super(driver);

    }

    public DashboardPage login(String username, String password) {
        enterEmail(username);
        enterPassword(password);
        clickLoginButton();
        return new DashboardPage(driver);
    }

    public LoginPage enterEmail(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated((emailInput)));
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordInput)));
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public String getTextFromEmailInput() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailInput)));
        return driver.findElement(emailInput).getAttribute("value");

    }

    public String getTextFromPasswordInput() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordInput)));
        return driver.findElement(passwordInput).getAttribute("value");

    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public Boolean isPasswordInputDisplayed() {
        return driver.findElement(passwordInput).isDisplayed();
    }

    public Boolean isUsernaneInputDisplayed() {
        return driver.findElement(emailInput).isDisplayed();
    }

    public Boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public String getErrorMessageText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginErrorMessage")));
        return driver.findElement(messageContainer).findElement(By.id("loginErrorMessage")).getText();

    }

    public Boolean allExpectedElementsAreDisplayed() {
        return isUsernaneInputDisplayed() && isPasswordInputDisplayed() && isLoginButtonDisplayed();

    }

    public String getUsernameInputType() {
        return driver.findElement(emailInput).getAttribute("type");
    }

    public String getPasswordInputType() {
        return driver.findElement(passwordInput).getAttribute("type");
    }


}
