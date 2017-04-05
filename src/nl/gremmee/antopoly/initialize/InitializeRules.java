package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.core.lists.RuleList;
import nl.gremmee.antopoly.rules.IRule;
import nl.gremmee.antopoly.rules.impl.BankruptRule;
import nl.gremmee.antopoly.rules.impl.DoublesJailRule;

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

        IRule rule = new BankruptRule();
        ruleList.add(rule);
        System.out.print("Creating Rule " + rule.getName() + "...");
        System.out.println("[OK]");

        rule = new DoublesJailRule();
        ruleList.add(rule);
        System.out.print("Creating Rule " + rule.getName() + "...");
        System.out.println("[OK]");

        return ruleList;
    }

}
