package com.apark.bdddemo.utils;

import com.jayway.restassured.response.Response;
import java.util.Map;

public class RequestResponseHandler {

    private static RequestResponseHandler requestResponseHandler;

    private Map<String, String> requestHeaders;
    private String requestMethod;
    private Map<String, String> queryParams;
    private String requestBody;

    private Response response;
    private int responseStatus;

    public static RequestResponseHandler getHandler() {
        if (requestResponseHandler == null) {
            requestResponseHandler =  new RequestResponseHandler();
        }

        return requestResponseHandler;
    }

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }
}
