package api.internal.api;

import api.internal.password.PasswordPayload;
import com.google.gson.Gson;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import pageobjects.Homepage;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class InternalApi {

    private final static Header CONTENT_TYPE_HEADER = new Header("Content-Type", ContentType.JSON.toString());
    private final static Header ORIGIN = new Header("Origin", "https://www.car2go.com");

    AuthenticationContainer authenticationContainer;


    public AuthenticationContainer authenticate() {
        return this.authenticate(System.getProperty("username"), System.getProperty("password"));
    }

    public AuthenticationContainer authenticate(String username, String password) {

        if (authenticationContainer != null) {
            return authenticationContainer;
        }

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        URL url = null;
        try {
            url = new URL(System.getProperty("huburl"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        RemoteWebDriver driver=new RemoteWebDriver(url,desiredCapabilities);

        driver.manage().window().maximize();

        Homepage page = new Homepage(driver);

        page.openHomePage().clickOnLoginLink().login(username, password).pageElementsAreDisplayed();

        Set<Cookie> seleniumCookies = driver.manage().getCookies();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String token = (String) js.executeScript("return window.C2gCropp._api._keycloak.token");
        String csrfToken = (String) js.executeScript("return window.C2gCropp._api._getToken()");

        List restAssuredCookies = new ArrayList();

        for (org.openqa.selenium.Cookie cookie : seleniumCookies) {
            restAssuredCookies.add(new io.restassured.http.Cookie.Builder(cookie.getName(), cookie.getValue()).build());
        }

        driver.quit();

        this.authenticationContainer = new AuthenticationContainer(token, restAssuredCookies);
        this.authenticationContainer.setCsrfToken(csrfToken);

        return this.authenticationContainer;
    }

    public Response getPersonalData() {

        AuthenticationContainer authenticationContainer = authenticate();


        return given()
                .baseUri(System.getProperty("baseurl"))
                .cookies(new Cookies(authenticationContainer.getCookies()))
                .header("Authorization", "Bearer " + authenticationContainer.getBearerToken())
                .get("/cuba/customer/personaldata/own/");


    }

    private Headers getCommonHeaders(AuthenticationContainer authenticationContainer) {
        return new Headers(new Header("Authorization", "Bearer " + authenticationContainer.getBearerToken()),
                new Header("Referer", System.getProperty("baseurl")+"/US/en/myaccount/"),
                new Header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36"),
                new Header("Accept", ContentType.ANY.getAcceptHeader()),
                new Header("X-CSRFTOKEN", authenticationContainer.getCsrfToken() != null ? authenticationContainer.getCsrfToken() : ""));
    }

    public Response editPassword(String newPassword, String oldPassword) {
        AuthenticationContainer authenticationContainer = authenticate();
        Gson gson = new Gson();
        String requestBody = gson.toJson(new PasswordPayload(newPassword, oldPassword));


        receiveCsrfToken();

        return given()
                .baseUri(System.getProperty("baseurl"))
                .cookies(new Cookies(authenticationContainer.getCookies()))
                .headers(getCommonHeaders(authenticationContainer))
                .header(CONTENT_TYPE_HEADER)
                .header(ORIGIN)
                .body(requestBody)
                .put("/cuba/customer/password/own/");

    }


    private void receiveCsrfToken(){
        Response paymentProfiles = given()
                .baseUri(System.getProperty("baseurl"))
                .cookies(new Cookies(authenticationContainer.getCookies()))
                .headers(getCommonHeaders(authenticationContainer))
                .get("/caba/customer/v2/rentals/own/paymentprofiles");


        authenticationContainer.setCsrfToken(paymentProfiles.getHeader("X-CSRFTOKEN"));

    }

    public Response getNotifications() {
        AuthenticationContainer authenticationContainer = authenticate();

        Response response= given()
                .baseUri(System.getProperty("baseurl"))
                .cookies(new Cookies(authenticationContainer.getCookies()))
                .headers(getCommonHeaders(authenticationContainer))
                .get("/notification/customer/v1/customer/");

        authenticationContainer.setCsrfToken(response.getHeader("X-CSRFTOKEN"));

        return response;

    }



}
