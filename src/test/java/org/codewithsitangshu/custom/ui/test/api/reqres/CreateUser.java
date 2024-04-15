package org.codewithsitangshu.custom.ui.test.api.reqres;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codewithsitangshu.custom.api.assertion.RestApiResponse;
import org.codewithsitangshu.custom.ui.test.api.reqres.user.UserDetails;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.codewithsitangshu.custom.api.assertion.RestApiResponseAssert.assertThat;

public class CreateUser extends ReqresConfig {

    @Test
    public void createUser() {
        String endpoint = "/api/users";

        UserDetails userDetails = new UserDetails();
        userDetails.setName("morpheus");
        userDetails.setJob("leader");

        int expectedStatusCode = 201;
        // Perform POST request
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .body(userDetails)
                .when()
                .post(BASE_URL + endpoint);

        RestApiResponse restApiResponse = convertResponseToRestApiResponse(response);
        assertThat(restApiResponse)
                .hasStatusCode(expectedStatusCode)
                .hasJsonPathValue("name","morpheus")
                .hasJsonPathValue("job","leader");


    }

}
