package login;

import baseTest.TestBase;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.Homepage;
import pageObjects.LoginPage;

public class LoginWithValidCredentials extends TestBase {

    @Test
    public void openHomepageAndClickOnLoginLinkTest(){



        Homepage page=new Homepage(driver);
        page.openHomePage().clickOnLoginLink();

        softAssert.assertTrue(driver.getCurrentUrl().contains(System.getProperty("baseurl")+"/auth/"), "Login url is not as expected");
        softAssert.assertTrue(driver.getTitle().equals("car2go Login"), "Login page title is not as expected");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = { "openHomepageAndClickOnLoginLinkTest" })
    public void enterUserCredentialsAndClickLoginButtonTest(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterEmail(System.getProperty("username"))
                 .enterPassword(System.getProperty("password"));


        softAssert.assertTrue(loginPage.getTextFromEmailInput().contains(System.getProperty("username")),"Username input value is not the entered username");
        softAssert.assertTrue(loginPage.getUsernameInputType().equals("text"),"Username input type is not text");
        softAssert.assertTrue(loginPage.getTextFromPasswordInput().contains(System.getProperty("password")),"Password input value is not the entered password");
        softAssert.assertTrue(loginPage.getPasswordInputType().equals("password"),"Password input type is not password");
        softAssert.assertAll();

    }

    @Test(dependsOnMethods = {"enterUserCredentialsAndClickLoginButtonTest"})
    public void dashboardPageIsOpened(){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.clickLoginButton();
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.pageElementsAreDisplayed();

        softAssert.assertTrue(driver.getCurrentUrl().equals(System.getProperty("baseurl")+"/US/en/myaccount/#/dashboard.html"), "Dashboard page url is not as expected");
        softAssert.assertTrue(driver.getTitle().equals("car2go Carsharing "), "Dashboard page title is not as expected");
        softAssert.assertAll();

    }

}
