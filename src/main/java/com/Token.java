package com;

/**
 * Created by Naya on 27.06.2016.
 */
public class Token {
    private String access_token;
    private String scope;

    public Token() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
