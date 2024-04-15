package org.codewithsitangshu.custom.ui.test.api;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.codewithsitangshu.custom.api.assertion.RestApiResponse;

public class BaseAPI {

    // Utility method to convert RestAssured's Response to custom RestApiResponse
    public RestApiResponse convertResponseToRestApiResponse(Response response) {
        int statusCode = response.getStatusCode();
        String body = response.getBody().asString();
        Headers headers = response.getHeaders();
        return new RestApiResponse(statusCode, body, headers);
    }

}
