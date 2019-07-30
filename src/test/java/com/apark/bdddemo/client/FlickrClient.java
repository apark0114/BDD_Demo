package com.apark.bdddemo.client;

import com.apark.bdddemo.utils.RequestResponseHandler;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class FlickrClient {

    private static final Logger log = LoggerFactory.getLogger(FlickrClient.class);

    private final static String url = "https://api.flickr.com/services/rest/";

    public static void makeRequestToFlickr() {
        RequestSpecification requestSpecs = null;
        Response response = null;

        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder.addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()));

        requestBuilder.addHeaders(RequestResponseHandler.getHandler().getRequestHeaders());
        requestBuilder.addQueryParameters(RequestResponseHandler.getHandler().getQueryParams());
        requestBuilder.setBaseUri(url);
        requestSpecs = requestBuilder.build();

        RequestSpecification rs = RestAssured.given().spec(requestSpecs);


        if (RequestResponseHandler.getHandler().getRequestMethod().equals("GET")){
            response = rs.get().andReturn();
        }
        else if (RequestResponseHandler.getHandler().getRequestMethod().equals("POST")) {
            response = rs.post().andReturn();
        }
        else if (RequestResponseHandler.getHandler().getRequestMethod().equals("PUT")) {
            response = rs.put().andReturn();
        }
        else if (RequestResponseHandler.getHandler().getRequestMethod().equals("DELETE")) {
            response = rs.delete().andReturn();
        }
        else {
            log.error("No request method was found");
        }

        RequestResponseHandler.getHandler().setResponseStatus(response.getStatusCode());
        RequestResponseHandler.getHandler().setResponse(response);
    }
}
