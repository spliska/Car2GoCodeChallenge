package pageObjects.globalElements;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Homepage;

public class MetabarNavigation {
    private final By logoutButton = By.className("login");
    private final By languages = By.className("metabar-languages");
    private final By message = By.className("hello-information");
    private final WebDriverWait wait;
    private final RemoteWebDriver driver;

    public MetabarNavigation(RemoteWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    public Homepage clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return new Homepage(driver);
    }

    public void selectLanguage(Integer index) {
        wait.until(ExpectedConditions.elementToBeClickable(languages));
        driver.findElement(languages).findElement(By.tagName("li")).click();
    }

    public String getHelloMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        return driver.findElement(message).getText();
    }


}
