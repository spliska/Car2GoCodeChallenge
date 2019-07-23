package basetest;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class TestBase {
    protected RemoteWebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    @Parameters({ "browser" })
    @BeforeTest
    public void setup(String browser) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(browser);

        try {
            driver = new RemoteWebDriver(new URL(System.getProperty("huburl")), desiredCapabilities);
        } catch (MalformedURLException e) {
            System.out.print("Exception");
            e.printStackTrace();
        }

        driver.manage().window().setSize(new Dimension(1025,1080));

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
