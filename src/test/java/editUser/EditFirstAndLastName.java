package edituser;

import basetest.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.DashboardPage;
import pageobjects.Homepage;
import pageobjects.LoginPage;
import pageobjects.mydetailspage.MyDetailsPage;
import pageobjects.mydetailspage.cards.NameAndAddressCard;

public class EditFirstAndLastName extends TestBase {
    @BeforeMethod
    public void openHomepageAndLogin(){

        Homepage page = new Homepage(driver);
        page.openHomePage().clickOnLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(System.getProperty("username"),System.getProperty("password"));

    }



    @Test
    public void goToMyDetailsAndChangeTheFirstAndLastName() {
        softAssert=new SoftAssert();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.pageElementsAreDisplayed();
        dashboardPage.getMainbarNavigation().openMyDetailsPage();

        MyDetailsPage myDetailsPage=new MyDetailsPage(driver);

        myDetailsPage.openNameAndAddressForm().makeFirstNameInputEnabled().enterFirstName("Harald").makeLastNameInputEnabled().clearLastNameInput().enterLastName("Schmidt").clickSaveData();

        NameAndAddressCard nameAndAddressCard=new NameAndAddressCard(driver);

        softAssert.assertFalse(nameAndAddressCard.getFirstName().equals("Harald"),"The first name is changed but it should not be changed");
        softAssert.assertFalse(nameAndAddressCard.getLastName().equals("Schmidt"),"The last name is changed but it should not be changed");
        softAssert.assertAll();





    }
}
