package com.apark.bdddemo.utils;

import com.jayway.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

public class JsonUtil {
    public static void verifyPathAndValueExist(Map<String, String> checkResponse, Response response) {

        for (String key: checkResponse.keySet()) {
            String value = response.getBody().jsonPath().get(key).toString();
            Assert.assertEquals(checkResponse.get(key), value);
        }
    }
}
