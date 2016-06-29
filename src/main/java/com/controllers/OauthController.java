package com.controllers;

import com.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Naya on 27.06.2016.
 */

@RestController
public class OauthController {
    Token token;
    String shop;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/test")
    public ModelAndView testAuth() {
        return new ModelAndView("redirect:"+new OauthUrlProvider().get());

    }

    @RequestMapping("/auth/shopify/callback")
    public Token getShopifyResponce(@RequestParam String code, @RequestParam String shop) throws IOException, URISyntaxException {
        this.shop = shop;
        token = new ShopifyTokenProvider(
                "7297b33bc61280538b7070f08ad83f83", "01a4235d9abe16e5e833ad284ba40245").get(code,shop);
        return token;


    }


    @RequestMapping("/orders")
    public Object getOrders() throws IOException, URISyntaxException {
        ShopifyService service = new ShopifyService(shop, token);
        return service.execute(new ShopifyResponseHandler(), "orders.json");

    }

    @RequestMapping("/customers")
    public Object getCustomers() throws IOException, URISyntaxException {
        ShopifyService service = new ShopifyService(shop, token);
        return service.execute(new ShopifyResponseHandler(), "customers.json");

    }

}
