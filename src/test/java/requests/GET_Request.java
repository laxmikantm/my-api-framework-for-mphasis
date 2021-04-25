package requests;
/**************************
 *  (C) L Somni            *
 ***************************/

import Utils.Helper;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GET_Request {


    RequestSpecification httpRequest = RestAssured.given();
    Response response;

    public void chooseEndPoint() {
        httpRequest.baseUri(Helper.URL);
    }

    public void chooseEndPoint(final String sEndPoint) {
        switch (sEndPoint){
//            case "Posts" : httpRequest.baseUri(Helper.URL + Helper.ENDPOINTS.POSTS);
            case "Posts" : httpRequest.baseUri(Helper.URL + Helper.POSTS);
                break;
            case "Comments" : httpRequest.baseUri(Helper.URL + Helper.COMMENTS);
                break;
            case "Users" : httpRequest.baseUri(Helper.URL + Helper.USERS_LIST);
                break;
            default: throw new Helper.ConfigurationException("ERROR: Invalid Endpoint supplied");
        }
    }

    public Response getRequest() {
        Response request = httpRequest.request(Method.GET);
        return request;
    }

}
