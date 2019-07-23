package externalapi;

import api.Api;
import api.response.lightswitchposition.LightSwitchPosition;
import api.response.lightswitchposition.LightSwitchPositionResponse;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LightSwitchPositionTest {

    private final Gson gson = new Gson();
    private final String bearer = System.getProperty("bearertoken");
    private final String baseUrl = "https://api.mercedes-benz.com/vehicledata_tryout/v1/vehicles/";
    private final String url = "/resources/lightswitchposition";

    @Test(dataProvider = "authorizedLightSwitch")
    public void authorizedLightSwitchPosition(String vehicleId, LightSwitchPositionResponse expectedResponseBody) {
        Api api = new Api();
        Response response = api.getRequest(bearer, baseUrl + vehicleId + url);

        Assert.assertEquals(expectedResponseBody, gson.fromJson(response.andReturn().body().asString(), LightSwitchPositionResponse.class));

    }


    @DataProvider
    public Object[][] authorizedLightSwitch() {
        return new Object[][]{
                {"WDB111111ZZZ22222", new LightSwitchPositionResponse(new LightSwitchPosition("0",1541080800000L))}
        };
    }
}
