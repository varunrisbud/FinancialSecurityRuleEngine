package com.security.securityreader;

import com.security.Security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alcohol on 4/18/16.
 */
public class StringSecurityReader implements SecurityReader{
    String securityListString;

    public StringSecurityReader(String securityListString) {
        this.securityListString = securityListString;
    }

    public List<Security> getSecurityList() {
        List<Security> outputList = new ArrayList<Security>();
        String[] securityListSplit = securityListString.split("\n");
        Security security = new Security();
        security.setSecurityType(securityListSplit[0]);
        HashMap<String, String> attributes = new HashMap<String, String>();
        for(int i = 1; i < securityListSplit.length; ++i) {
            int leadingSpaces = securityListSplit[i].indexOf(' ') + 1;
            if(leadingSpaces == 0) {    //new Security
                security.setAttributes(attributes);
                outputList.add(security);
                security = new Security();
                attributes.clear();
                security.setSecurityType(securityListSplit[i]);
            }
            else if(leadingSpaces == 1) {
                String[] attributeSplit = securityListSplit[i].substring(1).split(":");
                attributes.put(attributeSplit[0], attributeSplit[1].substring(attributeSplit[1].indexOf(" ") + 1));
            }
        }
        security.setAttributes(attributes);
        outputList.add(security);
        return outputList;
    }

    public void setSecurityListString(String securityListString) {
        this.securityListString = securityListString;
    }

    public String getSecurityListString() {
        return this.securityListString;
    }
}
