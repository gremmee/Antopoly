package nl.gremmee.antopoly.core.lists;

import java.util.ArrayList;

import nl.gremmee.antopoly.players.IPlayer;

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
        int bustedCount = 0;
        for (IPlayer player : this) {
            if (player.isBusted()) {
                bustedCount++;
            }
        }
        if (bustedCount == this.size() - 1) {
            for (IPlayer player : this) {
                if (!player.isBusted()) {
                    return player;
                }
            }

        }
        return null;
    }

}
