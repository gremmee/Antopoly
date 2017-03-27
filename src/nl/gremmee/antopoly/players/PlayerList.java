package nl.gremmee.antopoly.players;

import java.util.ArrayList;

public class PlayerList extends ArrayList<IPlayer> {

    private static final long serialVersionUID = -8862672490776383051L;

    public boolean isWinner() {
        for (IPlayer player : this) {
            if (player.isWinner()) {
                return true;
            }
        }
        return false;
    }

    public IPlayer getWinner() {
        for (IPlayer player : this) {
            if (player.isWinner()) {
                return player;
            }
        }
        return null;
    }
}
