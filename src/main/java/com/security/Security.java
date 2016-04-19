package com.security;

import java.util.HashMap;

/**
 * Created by alcohol on 4/18/16.
 */
public class Security {
    private String securityType;
    private HashMap<String, String> attributes;


    public String getSecurityType() {
        return securityType;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = new HashMap<String, String>(attributes);
    }
}
