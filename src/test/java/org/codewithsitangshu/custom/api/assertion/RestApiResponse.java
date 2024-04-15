package org.codewithsitangshu.custom.api.assertion;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Headers;

import java.util.HashMap;
import java.util.Map;

public class RestApiResponse {

    // Getters for status code, body, and headers
    private int statusCode;
    private String body;
    private Map<String, String> headers;
    private ObjectMapper objectMapper;

    // Constructor
    public RestApiResponse(int statusCode, String body, Headers headers) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = convertHeadersToMap(headers);
        this.objectMapper = new ObjectMapper();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    public String getHeader(String headerName) {
        return headers.get(headerName);
    }

    // Convert Headers to Map<String, String>
    private Map<String, String> convertHeadersToMap(Headers headers) {
        Map<String, String> headersMap = new HashMap<>();
        for (io.restassured.http.Header header : headers) {
            headersMap.put(header.getName(), header.getValue());
        }
        return headersMap;
    }

    // Parse JSON response body to Map
    public Map<String, Object> parseJsonBody() throws Exception {
        return objectMapper.readValue(body, new TypeReference<Map<String, Object>>() {});
    }

    // Can add more as per need

}
