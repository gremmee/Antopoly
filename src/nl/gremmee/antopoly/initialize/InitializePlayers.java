package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.core.lists.PlayerList;
import nl.gremmee.antopoly.core.tiles.Tiles;
import nl.gremmee.antopoly.players.IPlayer;
import nl.gremmee.antopoly.players.impl.Player;

public class InitializePlayers {
    private static InitializePlayers instance;
    private PlayerList playerList;

    private InitializePlayers() {
    }

    public static InitializePlayers getInstance() {
        if (instance == null) {
            instance = new InitializePlayers();
        }
        return instance;
    }

    public PlayerList initializePlayers(int aNumPlayers) {
        System.out.println("Initializing Players");
        playerList = new PlayerList();
        for (int i = 0; i < aNumPlayers; i++) {
            System.out.print("Creating Player " + (i + 1) + "...");
            IPlayer player = new Player(i + 1, "Player " + (i + 1));
            player.setCurrentTile(Initialize.getInstance().getTileList().getTileByName(Tiles.START));
            playerList.add(player);
            System.out.println("[OK]");
        }
        return playerList;
    }

}
