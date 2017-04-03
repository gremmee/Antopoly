package nl.gremmee.antopoly.core.cards;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GetOutOfJailCardTest.class, GotoCardTest.class, GotoJailCardTest.class, PayCardTest.class,
        ReceiveCardTest.class })
public class CardTests {

}
