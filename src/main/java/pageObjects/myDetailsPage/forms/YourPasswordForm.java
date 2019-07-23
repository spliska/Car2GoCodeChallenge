package pageObjects.myDetailsPage.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourPasswordForm {
    private final By passwordForm = By.name("PasswordForm");
    private final By currentPasswordInput = By.id("passwordOld");
    private final By newPasswordInput = By.id("password");
    private final By cancelButton = By.className("button--secondary");
    private final By savePasswordButton = By.tagName("button");
    private final By editPasswordButton = By.className("c2g-mydetails-edit-password");

    private final RemoteWebDriver driver;

    private final WebDriverWait wait;

    public YourPasswordForm(RemoteWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public YourPasswordForm enterCurrentPassword(String oldPassword) {
        wait.until(ExpectedConditions.presenceOfElementLocated(currentPasswordInput));
        driver.findElement(passwordForm).findElement(currentPasswordInput).sendKeys(oldPassword);
        return this;
    }

    public YourPasswordForm enterNewPasswordInput(String newPassword) {
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(passwordForm), ExpectedConditions.presenceOfElementLocated(currentPasswordInput)));
        driver.findElement(passwordForm).findElement(newPasswordInput).sendKeys(newPassword);
        return this;
    }

    public String getCurrentPasswordInputValue() {
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(passwordForm), ExpectedConditions.presenceOfElementLocated(currentPasswordInput)));
        return driver.findElement(passwordForm).findElement(currentPasswordInput).getAttribute("value");
    }

    public String getNewPasswordInputValue() {
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(passwordForm), ExpectedConditions.presenceOfElementLocated(newPasswordInput)));
        return driver.findElement(passwordForm).findElement(newPasswordInput).getAttribute("value");
    }

    public void clickCancelButton() {
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.tagName("button")), ExpectedConditions.elementToBeClickable(By.tagName("button"))));
        driver.findElement(cancelButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(editPasswordButton));
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(savePasswordButton), ExpectedConditions.elementToBeClickable(savePasswordButton)));
        driver.findElement(passwordForm).findElement(savePasswordButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(editPasswordButton));
    }

}
