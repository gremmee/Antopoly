package nl.gremmee.antopoly.core.cards;

import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.players.IPlayer;

public abstract class Card implements ICard {

    private String name;
    private String text;
    private CardType cardType;
    private CardAction cardAction;

    public Card(CardAction aCardAction, String aName, String aText) {
        this.setName(aName);
        this.setText(aText);
        this.setCardAction(aCardAction);
    }

    public boolean isGetOutOfJailCard() {
        return CardAction.CA_GetOutOfJail.equals(this.getCardAction());
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public String getText() {
        return text;
    }

    public void setText(String aText) {
        this.text = aText;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType aCardType) {
        this.cardType = aCardType;
    }

    public CardAction getCardAction() {
        return cardAction;
    }

    public void setCardAction(CardAction aCardAction) {
        this.cardAction = aCardAction;
    }

    @Override
    public String toString() {
        return ("|" + this.getName() + ", " + this.getCardType() + "|");
    }

    @Override
    public void excute(IPlayer aPlayer) {
        switch (getCardAction()) {
            case CA_Pay:
                PayCard payCard = (PayCard) this;

                int pay = payCard.getValue();
                System.out.println("Pay " + pay);
                aPlayer.setMoney(aPlayer.getMoney() - pay);
                break;
            case CA_Recieve:
                RecieveCard recieveCard = (RecieveCard) this;

                int receive = recieveCard.getValue();
                System.out.println("Recieve " + receive);
                aPlayer.setMoney(aPlayer.getMoney() + receive);
                break;
            case CA_GotoJail:
                GotoJailCard goDirectCard = (GotoJailCard) this;

                ITile goDirectTile = goDirectCard.getTile();

                System.out.println("Goto Jail");
                aPlayer.setCurrentTile(goDirectTile);
                aPlayer.setInJail(true);
                break;
            case CA_Goto:
                GotoCard gotoCard = (GotoCard) this;

                ITile gotoTile = gotoCard.getTile();

                System.out.println("Goto Tile " + gotoTile.getName());
                aPlayer.setCurrentTile(gotoTile);
                break;
            case CA_PayProperty:
                PayPropertyCard payPropertyCard = (PayPropertyCard) this;

                int houses = aPlayer.getHouses();
                int hotels = aPlayer.getHotels();

                int houseCosts = payPropertyCard.getPerHouse() * houses;
                int hotelCosts = payPropertyCard.getPerHotel() * hotels;

                int totalCosts = houseCosts + hotelCosts;
                System.out.println("Pay " + totalCosts);
                aPlayer.setMoney(aPlayer.getMoney() - totalCosts);

                break;
            default:
                break;
        }
    }

}
