package org.codewithsitangshu.custom.ui.test.api.reqres;

import io.restassured.response.Response;
import org.codewithsitangshu.custom.api.assertion.RestApiResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.codewithsitangshu.custom.api.assertion.RestApiResponseAssert.assertThat;

public class ListUser extends ReqresConfig {

    @Test
    public void getListUser() {
        String endpoint = "/api/users?page=2";
        int expectedStatusCode = 200;
        // Perform POST request
        Response response = given().log().all()
                .when()
                .get(BASE_URL + endpoint);

        RestApiResponse restApiResponse = convertResponseToRestApiResponse(response);
        assertThat(restApiResponse)
                .hasStatusCode(expectedStatusCode)
                .hasJsonPathValue("data.findAll{i -> i.id == 11}.email[0]","george.edwards@reqres.in");
    }

}
