package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.core.lists.RuleList;
import nl.gremmee.antopoly.rules.IRule;
import nl.gremmee.antopoly.rules.impl.BankruptRule;
import nl.gremmee.antopoly.rules.impl.DoublesJailRule;
import nl.gremmee.antopoly.rules.impl.GetMortgageRule;

public class InitializeRules {
    private static InitializeRules instance;
    private RuleList ruleList;

    private InitializeRules() {
    }

    public static InitializeRules getInstance() {
        if (instance == null) {
            instance = new InitializeRules();
        }
        return instance;
    }

    public RuleList initializeRules() {
        System.out.println("Initializing Rules");
        ruleList = new RuleList();

        IRule rule = new GetMortgageRule();
        ruleList.add(rule);
        System.out.println("Creating Rule " + rule.getName() + "...[OK]");

        rule = new BankruptRule();
        ruleList.add(rule);
        System.out.println("Creating Rule " + rule.getName() + "...[OK]");

        rule = new DoublesJailRule();
        ruleList.add(rule);
        System.out.println("Creating Rule " + rule.getName() + "...[OK]");

        return ruleList;
    }

}
