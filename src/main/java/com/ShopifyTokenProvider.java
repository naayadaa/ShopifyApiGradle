package com;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naya on 27.06.2016.
 */
public class ShopifyTokenProvider {

    private HttpClient httpClient;
    private String code;
    private String clientId;
    private String clientSecret;
    private Token token;


    public ShopifyTokenProvider(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public Token get(String code, String shop) throws IOException, URISyntaxException {
        httpClient = HttpClientBuilder.create().build();

        HttpPost request = new HttpPost("https://" + shop + "/admin/oauth/access_token");
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("client_id", clientId));
        urlParameters.add(new BasicNameValuePair("client_secret", clientSecret));
        urlParameters.add(new BasicNameValuePair("code", code));
        request.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = httpClient.execute(request);

        ObjectMapper mapper = new ObjectMapper();
        token = mapper.readValue(response.getEntity().getContent(), Token.class);
        return  token;



    }
}
