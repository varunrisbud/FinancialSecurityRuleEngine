package com.ruleengine.rulereader;

import com.ruleengine.rulereaders.RuleReader;
import com.ruleengine.rulereaders.StringRuleReader;
import com.ruleengine.rules.Rule;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by alcohol on 4/15/16.
 */
public class StringRuleReaderTest {
    @Test
    public void getRuleListTest() {
        StringBuilder rulesString = new StringBuilder();
        rulesString.append("Security.class, issue!=abc, accept\n")
                .append("Security.class, issue!=bcd, accept\n")
                .append("Security.class, debt!=1week, accept\n")
                .append("Security.class, issue!=xyz, reject\n");

        RuleReader ruleReader = new StringRuleReader(rulesString.toString());
        List<Rule> ruleList = ruleReader.getRuleList();
        assertEquals(4, ruleList.size());
        assertEquals("Security.class", ruleList.get(1).getApplyOnClass());
        assertEquals("debt!=1week", ruleList.get(2).getCondition());
        assertEquals("reject", ruleList.get(3).getAction());
    }
}
