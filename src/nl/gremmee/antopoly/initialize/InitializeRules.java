package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.core.lists.RuleList;
import nl.gremmee.antopoly.rules.impl.BankruptRule;
import nl.gremmee.antopoly.rules.impl.DoublesJailRule;
import nl.gremmee.antopoly.rules.impl.GetMortgageRule;
import nl.gremmee.antopoly.rules.impl.RepayMortgageRule;
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
        if (this.ruleList == null) {
            System.out.println("Initializing Rules");
            this.ruleList = new RuleList();
            // keep in order
            this.ruleList.add(new RepayMortgageRule());
            this.ruleList.add(new SellPropertiesRule());
            this.ruleList.add(new GetMortgageRule());
            this.ruleList.add(new BankruptRule());
            this.ruleList.add(new DoublesJailRule());
        }
        return this.ruleList;
    }

}
