package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.Initialize;

public class GotoJailCard extends GotoCard {

    public GotoJailCard() {
        super(CardAction.CA_GotoJail, "Goto Jail",
                "Ga direct naar de gevangenis. Ga niet langs \"Start\". U ontvangt geen ƒ 20",
                Initialize.getInstance().getTileList().getTileByName("Jail"));
    }

}
