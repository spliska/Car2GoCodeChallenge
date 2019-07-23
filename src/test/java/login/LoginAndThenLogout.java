package login;

import basetest.TestBase;
import org.testng.annotations.Test;
import pageobjects.DashboardPage;
import pageobjects.Homepage;
import pageobjects.LoginPage;

public class LoginAndThenLogout extends TestBase {



    @Test
    public void openHomepageAndClickOnLoginLink() {

        Homepage page = new Homepage(driver);

        page.openHomePage();


        softAssert.assertTrue(driver.getCurrentUrl().equals(System.getProperty("baseurl")+"/US/en/"), "Homepage url is not as expected");
        softAssert.assertTrue(driver.getTitle().equals("Hourly Car Rental and Car Sharing App | car2go USA"), "Homepage page title is not as expected");

        page.clickOnLoginLink();

        softAssert.assertTrue(driver.getCurrentUrl().contains(System.getProperty("baseurl")+"/auth/"), "Login url is not as expected");
        softAssert.assertTrue(driver.getTitle().equals("car2go Login"), "Login page title is not as expected");

        softAssert.assertAll();


    }

    @Test(dependsOnMethods = {"openHomepageAndClickOnLoginLink"})
    public void enterUserCredentialsAndClickLoginButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(System.getProperty("username"))
                .enterPassword(System.getProperty("password"));


        softAssert.assertTrue(driver.getCurrentUrl().contains(System.getProperty("baseurl")+"/auth/realms/"), "Login page url is not as expected");
        softAssert.assertTrue(driver.getTitle().equals("car2go Login"), "Login page title is not as expected");

        loginPage.clickLoginButton();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.pageElementsAreDisplayed();


        softAssert.assertTrue(driver.getCurrentUrl().equals(System.getProperty("baseurl")+"/US/en/myaccount/#/dashboard.html"), "Dashboard page url is not as expected");
        softAssert.assertTrue(driver.getTitle().equals("car2go Carsharing "), "Dashboard page title is not as expected");
        softAssert.assertAll();

    }

    @Test(dependsOnMethods = {"enterUserCredentialsAndClickLoginButton"})
    public void clickOnLogoutButton() {

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.getMetabarNavigation().clickLogoutButton();


        softAssert.assertTrue(driver.getCurrentUrl().equals(System.getProperty("baseurl")+"/US/en/"), "Homepage url is not as expected");
        softAssert.assertTrue(driver.getTitle().equals("Hourly Car Rental and Car Sharing App | car2go USA"), "Homepage page title is not as expected");
        softAssert.assertAll();

    }

}
