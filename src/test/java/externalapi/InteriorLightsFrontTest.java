package externalapi;

import api.Api;
import api.response.interiorlightsfront.InteriorLightsFront;
import api.response.interiorlightsfront.InteriorLightsFrontResponse;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InteriorLightsFrontTest {

    private final Gson gson = new Gson();
    private final String bearer = System.getProperty("bearertoken");
    private final String baseUrl = "https://api.mercedes-benz.com/vehicledata_tryout/v1/vehicles/";
    private final String url = "/resources/interiorLightsFront";

    @Test(dataProvider = "authorizedInteriorLightsFrontData")
    public void authorizedInteriorLightsFront(String vehicleId, InteriorLightsFrontResponse expectedResponseBody) {
        Api api = new Api();
        Response response = api.getRequest(bearer, baseUrl + vehicleId + url);

        Assert.assertEquals(expectedResponseBody, gson.fromJson(response.andReturn().body().asString(), InteriorLightsFrontResponse.class));

    }


    @DataProvider
    public Object[][] authorizedInteriorLightsFrontData() {
        return new Object[][]{
                {"WDB111111ZZZ22222", new InteriorLightsFrontResponse(new InteriorLightsFront(false, 1541080800000L))}
        };
    }


}


