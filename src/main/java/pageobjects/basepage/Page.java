package pageobjects.basepage;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    protected final RemoteWebDriver driver;
    protected final WebDriverWait wait;

    protected Page(RemoteWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);

    }



    public RemoteWebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }




}
