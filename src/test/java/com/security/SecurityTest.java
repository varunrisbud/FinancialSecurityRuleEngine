package com.security;

import com.security.securityreader.SecurityReader;
import com.security.securityreader.StringSecurityReader;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;


/**
 * Created by alcohol on 4/18/16.
 */
public class SecurityTest {
    @Test
    public void createSecurityTest() {
        StringBuilder securityListString = new StringBuilder();

        securityListString.append("Equity.class\n")
                .append(" issuer: abcCorp\n")
                .append(" price: 34\n")
                .append(" dividendDate: 04/21/2016\n");

        securityListString.append("Coupon.class\n")
                .append(" issuer: xyzCorp\n")
                .append(" price: 501\n")
                .append(" couponDate: 05/07/2016");

        System.out.println(securityListString.toString());

        SecurityReader securityReader = new StringSecurityReader(securityListString.toString());

        List<Security> securityList = securityReader.getSecurityList();

        for(Security security: securityList) System.out.println(security.getAttributes().toString());

        assertEquals(2, securityList.size());

    }
}
