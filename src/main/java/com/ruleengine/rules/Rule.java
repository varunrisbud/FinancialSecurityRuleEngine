package com.ruleengine.rules;

/**
 * Created by alcohol on 4/15/16.
 */
public class Rule {
    private String condition;
    private String action;
    private String applyOnClass;

    public Rule() {}

    public Rule(String condition, String action, String applyOnClass) {
        this.condition = condition;
        this.action = action;
        this.applyOnClass = applyOnClass;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getApplyOnClass() {
        return applyOnClass;
    }

    public void setApplyOnClass(String applyOnClass) {
        this.applyOnClass = applyOnClass;
    }

    public void setRuleParameters(String rule, String separator) {
        String[] ruleParts = rule.replaceAll("\\s+", "").split(separator);
        if(ruleParts.length == 3) {
            this.setApplyOnClass(ruleParts[0]);
            this.setCondition(ruleParts[1]);
            this.setAction(ruleParts[2]);
        }
    }


}
