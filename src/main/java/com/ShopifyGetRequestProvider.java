package com;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Naya on 27.06.2016.
 */
public class ShopifyGetRequestProvider  {
    private  String url  ;

    private Token token;

    public ShopifyGetRequestProvider(String mapping, String shop, Token token) {
        this.token = token;
        this.url = "https://" + shop + "/admin/"+mapping;
    }

    public HttpUriRequest getRequest() {
        HttpGet request = new HttpGet(url);
        request.addHeader("X-Shopify-Access-Token", token.getAccess_token());


        System.out.println(request.getAllHeaders());

        return request;
    }

    public String getHost() {
        try {
            return new URL(url).getHost();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
