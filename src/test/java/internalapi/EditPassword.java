package internalapi;

import api.internal.api.InternalApi;
import basetest.TestBase;
import org.testng.annotations.Test;
import pageobjects.Homepage;

public class EditPassword extends TestBase {




    @Test
    public void editPasswordApiCall(){
        InternalApi internalApi=new InternalApi();

        internalApi.editPassword(System.getProperty("password")+"7",System.getProperty("password")).then().assertThat().statusCode(204);;

        Homepage homepage=new Homepage(driver);
        homepage.openHomePage().clickOnLoginLink().login(System.getProperty("username"),System.getProperty("password")+"7").pageElementsAreDisplayed();
        softAssert.assertTrue(driver.getCurrentUrl().contains("/myaccount/#/dashboard.html"));

        internalApi.editPassword(System.getProperty("password"),System.getProperty("password")+"7");

        softAssert.assertAll();

    }


}
