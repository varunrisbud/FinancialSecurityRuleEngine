package com.ruleengine.rules;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by alcohol on 4/15/16.
 */
public class RuleTest {
    @Test
    public void setRuleParametersTest() {
        String ruleString = "Security.class, issuer!=abc, accept";
        Rule rule = new Rule();
        rule.setRuleParameters(ruleString, ",");
        assertEquals("Security.class", rule.getApplyOnClass());
        assertEquals("issuer!=abc", rule.getCondition());
        assertEquals("accept", rule.getAction());
    }
}