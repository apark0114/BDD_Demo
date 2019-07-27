package com.apark.bdddemo.client;

import com.apark.bdddemo.utils.RequestResponseHandler;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class FlickrClient {

    private RequestSpecification requestSpecs;
    private Response response;
    private final String url = "https://api.flickr.com/services/rest/";

    public void makeRequestToFlickr() throws Exception{

        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();

        requestBuilder.addHeaders(RequestResponseHandler.getHandler().getRequestHeaders());
        requestBuilder.addQueryParameters(RequestResponseHandler.getHandler().getQueryParams());
        requestBuilder.setBaseUri(url);
        requestSpecs = requestBuilder.build().request();

        if (RequestResponseHandler.getHandler().getRequestMethod() == "GET"){
            response = requestSpecs.get();
        }
        else if (RequestResponseHandler.getHandler().getRequestMethod() == "POST") {
            response = requestSpecs.post();
        }
        else if (RequestResponseHandler.getHandler().getRequestMethod() == "PUT") {
            response = requestSpecs.put();
        }
        else if (RequestResponseHandler.getHandler().getRequestMethod() == "DELETE") {
            response = requestSpecs.delete();
        }
        else {
            throw new Exception ("No request method was defined");
        }

        RequestResponseHandler.getHandler().setResponseStatus(response.getStatusCode());
        RequestResponseHandler.getHandler().setResponse(response);
    }

}
