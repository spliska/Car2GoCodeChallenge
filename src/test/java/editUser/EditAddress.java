package edituser;

import basetest.TestBase;
import org.testng.annotations.*;
import pageobjects.DashboardPage;
import pageobjects.Homepage;
import pageobjects.mydetailspage.MyDetailsPage;
import pageobjects.mydetailspage.cards.NameAndAddressCard;

public class EditAddress extends TestBase {

    @BeforeMethod
    public void openHomepageAndLogin(){

        Homepage page = new Homepage(driver);
        page.openHomePage().clickOnLoginLink().login(System.getProperty("username"),System.getProperty("password"));

    }



    @Test(dataProvider = "userData")
    public void goToMyDetailsAndChangeResidenceRelatedData(String newStreetAndNumber, String newPostalCode, String newCity, Integer newCountryIndex, String newCountry, String oldStreetAndNumber, String oldPostalCode, String oldCity, Integer oldCountryIndex) {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.pageElementsAreDisplayed();
        dashboardPage.getMainbarNavigation().openMyDetailsPage();

        MyDetailsPage myDetailsPage=new MyDetailsPage(driver);


        myDetailsPage.openNameAndAddressForm().clearStreetAndNumberInput()
                .enterStreetAndNumber(newStreetAndNumber)
                .clearPostalCodeInput()
                .enterPostalCode(newPostalCode)
                .clearCityInput()
                .enterCity(newCity)
                .selectCountry(newCountryIndex)
                .clickSaveData();


        NameAndAddressCard nameAndAddressCard=new NameAndAddressCard(driver);

        softAssert.assertTrue(nameAndAddressCard.getStreetAndNumber().equals(newStreetAndNumber),"Streetname and number are not as expected");
        softAssert.assertTrue(nameAndAddressCard.getPostalCode().equals(newPostalCode),"The postalcode is not as expected");
        softAssert.assertTrue(nameAndAddressCard.getCity().equals(newCity),"The city is not as expectd");
        softAssert.assertTrue(nameAndAddressCard.getCountry().equals(newCountry),"The country is not as expected");

        myDetailsPage.openNameAndAddressForm()
                .clearStreetAndNumberInput()
                .enterStreetAndNumber(oldStreetAndNumber)
                .clearPostalCodeInput()
                .enterPostalCode(oldPostalCode)
                .clearCityInput()
                .enterCity(oldCity)
                .selectCountry(oldCountryIndex)
                .clickSaveData();

        softAssert.assertAll();





    }

    @DataProvider
    public Object[][] userData() {
        return new Object[][]{{"Müllerstraße 13","12163","Москва",3,"American Samoa", "Test street", "12345", "Testaccount", 79}
        };
    }
}