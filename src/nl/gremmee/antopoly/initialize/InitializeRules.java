package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.core.lists.RuleList;
import nl.gremmee.antopoly.rules.impl.BankruptRule;
import nl.gremmee.antopoly.rules.impl.DoublesJailRule;
import nl.gremmee.antopoly.rules.impl.GetMortgageRule;
import nl.gremmee.antopoly.rules.impl.SellPropertiesRule;

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
        // keep in order
        ruleList.add(new SellPropertiesRule());
        ruleList.add(new GetMortgageRule());
        ruleList.add(new BankruptRule());
        ruleList.add(new DoublesJailRule());

        return ruleList;
    }

}
