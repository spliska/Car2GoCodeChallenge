package pageobjects.globalelements;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.DashboardPage;
import pageobjects.TripsAndInvoicesPage;
import pageobjects.mydetailspage.MyDetailsPage;

public class MainbarNavigation {

    private final By overviewLink = By.linkText("c2g-dashboard");
    private final By tripsAndInvoicesLink = By.className("c2g-trips-invoices");
    private final By myDetailsLink = By.className("c2g-my-details");
    private final By shareNowIcon = By.className("change");
    private final RemoteWebDriver driver;
    private final WebDriverWait wait;

    public MainbarNavigation(RemoteWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
    }

    public DashboardPage openOverviewPage() {
        driver.findElement(overviewLink).click();
        return new DashboardPage(driver);
    }



    public TripsAndInvoicesPage openTripsAndInvoices() {
        wait.until(ExpectedConditions.presenceOfElementLocated(tripsAndInvoicesLink));
        driver.findElement(tripsAndInvoicesLink).click();
        return new TripsAndInvoicesPage(driver);
    }

    public MyDetailsPage openMyDetailsPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(myDetailsLink));
        wait.until(ExpectedConditions.elementToBeClickable(myDetailsLink));

        driver.findElement(myDetailsLink).click();

        return new MyDetailsPage(driver);
    }

    public void openShareNowPage() {
        driver.findElement(shareNowIcon).click();
    }


}
