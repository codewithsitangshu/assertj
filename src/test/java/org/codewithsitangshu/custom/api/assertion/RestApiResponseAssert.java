package org.codewithsitangshu.custom.api.assertion;

import io.restassured.path.json.JsonPath;
import org.assertj.core.api.AbstractAssert;

import java.util.List;

public class RestApiResponseAssert extends AbstractAssert<RestApiResponseAssert , RestApiResponse> {

    public RestApiResponseAssert(RestApiResponse actual) {
        super(actual, RestApiResponseAssert.class);
    }

    public static RestApiResponseAssert assertThat(RestApiResponse actual){
        return new RestApiResponseAssert(actual);
    }

    public RestApiResponseAssert hasStatusCode(int expectedStatusCode) {
        isNotNull();
        int actualStatusCode = actual.getStatusCode();
        if (actualStatusCode != expectedStatusCode) {
            failWithMessage("Expected status code to be <%d> but was <%d>", expectedStatusCode, actualStatusCode);
        }
        return this;
    }

    public RestApiResponseAssert hasResponseBody(String expectedBody) {
        isNotNull();
        String actualBody = actual.getBody();
        if (!actualBody.equals(expectedBody)) {
            failWithMessage("Expected response body to be <%s> but was <%s>", expectedBody, actualBody);
        }
        return this;
    }

    public RestApiResponseAssert hasResponseHeader(String headerName, String expectedValue) {
        isNotNull();
        String actualValue = actual.getHeader(headerName);
        if (!actualValue.equals(expectedValue)) {
            failWithMessage("Expected header <%s> to have value <%s> but was <%s>", headerName, expectedValue, actualValue);
        }
        return this;
    }

    public RestApiResponseAssert hasResponseHeaderContaining(String headerName, String expectedSubstring) {
        isNotNull();
        String actualValue = actual.getHeader(headerName);
        if (!actualValue.contains(expectedSubstring)) {
            failWithMessage("Expected header <%s> to contain <%s> but was <%s>", headerName, expectedSubstring, actualValue);
        }
        return this;
    }

    public RestApiResponseAssert hasResponseHeaderMatching(String headerName, String regex) {
        isNotNull();
        String actualValue = actual.getHeader(headerName);
        if (!actualValue.matches(regex)) {
            failWithMessage("Expected header <%s> to match regex <%s> but was <%s>", headerName, regex, actualValue);
        }
        return this;
    }

    public RestApiResponseAssert hasJsonPathValue(String jsonPath, Object expectedValue) {
        isNotNull();
        JsonPath jsonPathEvaluator = JsonPath.from(actual.getBody());
        Object actualValue = jsonPathEvaluator.get(jsonPath);
        if (!actualValue.equals(expectedValue)) {
            failWithMessage("Expected JSON path <%s> to have value <%s> but was <%s>", jsonPath, expectedValue, actualValue);
        }
        return this;
    }

    public RestApiResponseAssert hasJsonPathStringValue(String jsonPath, String expectedValue) {
        isNotNull();
        JsonPath jsonPathEvaluator = JsonPath.from(actual.getBody());
        String actualValue = jsonPathEvaluator.getString(jsonPath);
        if (!actualValue.equals(expectedValue)) {
            failWithMessage("Expected JSON path <%s> to have string value <%s> but was <%s>", jsonPath, expectedValue, actualValue);
        }
        return this;
    }

    public RestApiResponseAssert hasJsonPathBooleanValue(String jsonPath, boolean expectedValue) {
        isNotNull();
        JsonPath jsonPathEvaluator = JsonPath.from(actual.getBody());
        boolean actualValue = jsonPathEvaluator.getBoolean(jsonPath);
        if (actualValue != expectedValue) {
            failWithMessage("Expected JSON path <%s> to have boolean value <%s> but was <%s>", jsonPath, expectedValue, actualValue);
        }
        return this;
    }

    public RestApiResponseAssert hasJsonPathIntegerValue(String jsonPath, int expectedValue) {
        isNotNull();
        JsonPath jsonPathEvaluator = JsonPath.from(actual.getBody());
        int actualValue = jsonPathEvaluator.getInt(jsonPath);
        if (actualValue != expectedValue) {
            failWithMessage("Expected JSON path <%s> to have integer value <%s> but was <%s>", jsonPath, expectedValue, actualValue);
        }
        return this;
    }

    public RestApiResponseAssert hasJsonPathListSize(String jsonPath, int expectedSize) {
        isNotNull();
        JsonPath jsonPathEvaluator = JsonPath.from(actual.getBody());
        List<Object> list = jsonPathEvaluator.getList(jsonPath);
        if (list.size() != expectedSize) {
            failWithMessage("Expected JSON path <%s> to have list size <%s> but was <%s>", jsonPath, expectedSize, list.size());
        }
        return this;
    }

    // Add more JSON-specific assertion methods as needed...

}
