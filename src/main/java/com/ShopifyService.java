package com;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;


/**
 * Created by Naya on 28.06.2016.
 */
public class ShopifyService {
    private CloseableHttpClient  httpClient;
    private String shop;
    private Token token;

    public ShopifyService( String shop, Token token) {
        this.httpClient = HttpClientBuilder.create().build();
        this.shop = shop;
        this.token = token;
    }

    public Object execute(ShopifyResponseHandler handler, String mapping) throws IOException {

        HttpUriRequest request = new ShopifyGetRequestProvider(mapping, shop, token).getRequest();
        CloseableHttpResponse response =  httpClient.execute(request);
        return handler.handle(response);

    }
}
