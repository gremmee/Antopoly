package nl.gremmee.antopoly.rules.tst;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BankruptRuleTest.class, DoublesJailRuleTest.class, GetMortgageRuleTest.class,
        SellPropertiesRuleTest.class })
public class RuleTests {

}
