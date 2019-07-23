package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.basePage.Page;

public class Homepage extends Page {

    private final String url=System.getProperty("baseurl");
    private final By loginLink = By.className("login");

    public Homepage(RemoteWebDriver driver) {

        super(driver);

    }

    public LoginPage clickOnLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
        driver.findElement(loginLink).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
        return new LoginPage(driver);

    }

    public Homepage openHomePage() {
        driver.get(url);
        return this;
    }

}
