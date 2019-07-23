package tripsandinvoices;

import basetest.TestBase;
import org.testng.annotations.Test;
import pageobjects.DashboardPage;
import pageobjects.Homepage;
import pageobjects.LoginPage;
import pageobjects.TripsAndInvoicesPage;

public class TripsAndInvoices extends TestBase {


    @Test
    public void tripsAndInvoicesTest() {
        Homepage page = new Homepage(driver);
        page.openHomePage().clickOnLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(System.getProperty("username"))
                 .enterPassword(System.getProperty("password"))
                 .clickLoginButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.pageElementsAreDisplayed();
        dashboardPage.getMainbarNavigation().openTripsAndInvoices();
        TripsAndInvoicesPage tripsAndInvoices = new TripsAndInvoicesPage(driver);

        Integer selectSize = tripsAndInvoices.getNumberOfMonthSelectOptions();

        for (int i = 0; i < selectSize; i++) {

            tripsAndInvoices.selectMonth(i);
            softAssert.assertTrue(tripsAndInvoices.getSelectedMonth().equals(tripsAndInvoices.getSelectOptionText(i)) && tripsAndInvoices.getEmptyMonthMessage().equals("Looks like you've not been on the road yet this month. Try a different month."), "Selected Month or message not as expected");
        }
        softAssert.assertAll();



    }



}
