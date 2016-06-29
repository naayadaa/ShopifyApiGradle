package com;

import java.util.Random;

/**
 * Created by Naya on 27.06.2016.
 */
public class OauthUrlProvider {
    private String url;
    int nonce;

    public String get(){
        nonce = new Random().nextInt();
        return  url = "https://testshop-534.myshopify.com/admin/oauth/authorize?client_id=7297b33bc61280538b7070f08ad83f83&scope=read_customers,read_orders,read_fulfillments,read_analytics&redirect_uri=http:%2F%2Flocalhost:8080%2Fauth%2Fshopify%2Fcallback&state="
                + nonce;
    }
}
