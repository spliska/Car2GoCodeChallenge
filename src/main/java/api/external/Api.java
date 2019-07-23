package api.external;

import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class Api
{
     public Response getRequest(String bearer,String url){
         return given().header("authorization", "Bearer " + bearer).get(url);
     }


}
