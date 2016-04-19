package com.ruleengine.rulereaders;

import com.ruleengine.rules.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alcohol on 4/15/16.
 */
public class StringRuleReader implements RuleReader {
    private String ruleString;
    private String rulePartsSeparator = ",";
    private String ruleSeparator = "\n";

    public StringRuleReader(String ruleString) {
        this.ruleString = ruleString;
    }

    public StringRuleReader(String ruleString, String rulePartsSeparator, String ruleSeparator) {
        this.ruleString = ruleString;
        this.rulePartsSeparator = rulePartsSeparator;
        this.ruleSeparator = ruleSeparator;
    }

    public String getRuleString() {
        return ruleString;
    }

    public void setRuleString(String ruleString) {
        this.ruleString = ruleString;
    }

    public String getRulePartsSeparator() {
        return rulePartsSeparator;
    }

    public void setRulePartsSeparator(String rulePartsSeparator) {
        this.rulePartsSeparator = rulePartsSeparator;
    }

    public String getRuleSeparator() {
        return ruleSeparator;
    }

    public void setRuleSeparator(String ruleSeparator) {
        this.ruleSeparator = ruleSeparator;
    }

    public List<Rule> getRuleList() {
        String[] rules = ruleString.split("\n");
        List<Rule> ruleList = new ArrayList<Rule>(rules.length);
        for(String rule: rules) {
            Rule newRule = new Rule();
            newRule.setRuleParameters(rule, rulePartsSeparator);
            ruleList.add(newRule);
        }
        return ruleList;
    }
}
