package pageObjects;

import pageObjects.myDetailsPage.MyDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pageObjects.basePage.Page;

public class TripsAndInvoicesPage extends Page {


    private final By dashboardLink = By.linkText("Dashboard");
    private final By tripsAndInvoices = By.linkText("Trips & Invoices");
    private final By myDetailsLink = By.linkText("My Details");
    private final By message = By.className("message");
    private final By monthSelect = By.tagName("select");
    private final By selectOption = By.tagName("option");
    private final By selectedMonth = By.className("selected-item");



    public TripsAndInvoicesPage(RemoteWebDriver driver) {
        super(driver);

    }


    public TripsAndInvoicesPage selectMonth(Integer monthIndex) {
        wait.until(ExpectedConditions.presenceOfElementLocated(monthSelect));
        Select monthselect = new Select(driver.findElement(monthSelect));
        driver.findElement(monthSelect).click();
        monthselect.selectByIndex(monthIndex);

        return this;
    }

    public DashboardPage openDashboardPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(dashboardLink));
        driver.findElement(dashboardLink).click();
        return new DashboardPage(driver);
    }

    public TripsAndInvoicesPage openTripsAndInvoices(){
        wait.until(ExpectedConditions.presenceOfElementLocated(tripsAndInvoices));
        driver.findElement(tripsAndInvoices).click();
        return new TripsAndInvoicesPage(driver);

    }

    public MyDetailsPage openMyDetailsPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(myDetailsLink));
        driver.findElement(myDetailsLink).click();
        return new MyDetailsPage(driver);
    }



    public Integer getNumberOfMonthSelectOptions() {
        wait.until(ExpectedConditions.presenceOfElementLocated(selectOption));
        return driver.findElements(selectOption).size();
    }

    public Boolean selectedMonthHasInvoices() {
        wait.until(ExpectedConditions.presenceOfElementLocated(monthSelect));
        return driver.findElement(message).isDisplayed();
    }

    public String getEmptyMonthMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        return driver.findElement(message).getText();
    }


    public String getSelectedMonth() {
        return driver.findElement(selectedMonth).getText();
    }

    public String getSelectOptionText(Integer index) {
        return driver.findElement(monthSelect).findElements(selectOption).get(index).getText();
    }


}
