package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Naya on 28.06.2016.
 */
public class ShopifyResponseHandler {
    private ObjectMapper mapper;

    public ShopifyResponseHandler() {

    }

    public Object handle(CloseableHttpResponse response) throws IOException {
        // Тут можно замапить респонс в лист объектов, которые вернем в базу
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result);

        return mapper.readValue(response.getEntity().getContent(), Object.class);


}
}
