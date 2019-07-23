package login;

import basetest.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.Homepage;
import pageobjects.LoginPage;

public class LoginWithInvalidCredentials extends TestBase {


    @Test(dataProvider = "invalidCredentials")
    public void openHomepageAndClickOnLoginLinkTest(String username,String password){

        Homepage page=new Homepage(driver);
        page.openHomePage().clickOnLoginLink();
        softAssert.assertTrue(driver.getCurrentUrl().contains(System.getProperty("baseurl")+"/auth/"), "Login url is not as expected");
        softAssert.assertTrue(driver.getTitle().equals("car2go Login"), "Login page title is not as expected");
        softAssert.assertAll();

        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterEmail(username)
                .enterPassword(password);

        softAssert.assertTrue(loginPage.getTextFromEmailInput().contains(username),"Username input value is not the entered username");
        softAssert.assertTrue(loginPage.getUsernameInputType().equals("text"),"Username input type is not text");
        softAssert.assertTrue(loginPage.getTextFromPasswordInput().contains(password),"Password input value is not the entered password");
        softAssert.assertTrue(loginPage.getPasswordInputType().equals("password"),"Password input type is not password");

        softAssert.assertAll();

        loginPage.clickLoginButton();

        softAssert.assertTrue(loginPage.getErrorMessageText().contains("Login failed. Please enter your car2go e-mail address and your car2go password to log in to your car2go account."),"Login error message is not as expected");
        softAssert.assertAll();

    }

    @DataProvider
    public Object[][] invalidCredentials(){
        return new Object[][]{
                {System.getProperty("username"),"Abc"+System.currentTimeMillis()},
                {"notexisting-"+System.currentTimeMillis()+"@gmail.com",System.getProperty("password")},

        };
    }




}
