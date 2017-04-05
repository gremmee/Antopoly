package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.impl.ChanceTile;
import nl.gremmee.antopoly.core.tiles.impl.CommunityChestTile;
import nl.gremmee.antopoly.core.tiles.impl.FreeParkingTile;
import nl.gremmee.antopoly.core.tiles.impl.GotoJailTile;
import nl.gremmee.antopoly.core.tiles.impl.JailTile;
import nl.gremmee.antopoly.core.tiles.impl.StartTile;
import nl.gremmee.antopoly.core.tiles.impl.StationTile;
import nl.gremmee.antopoly.core.tiles.impl.StreetTile;
import nl.gremmee.antopoly.core.tiles.impl.TaxPercentageTile;
import nl.gremmee.antopoly.core.tiles.impl.TaxTile;
import nl.gremmee.antopoly.core.tiles.impl.UtilityTile;

public class InitializeTiles {
    private static InitializeTiles instance;
    private TileList tileList;
    private Settings settings;

    private InitializeTiles() {
        settings = new Settings();
    }

    public static InitializeTiles getInstance() {
        if (instance == null) {
            instance = new InitializeTiles();
        }
        return instance;
    }

    public TileList initializeTileList() {
        System.out.println("Initializing Tiles");
        tileList = new TileList();
        int i = 0;

        ITile tile = new StartTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Dorpsstraat", Municipality.OnsDorp, 60, 2, 10, 30, 90, 160, 250);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new CommunityChestTile(i++, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Brink", Municipality.OnsDorp, 60, 4, 20, 60, 180, 320, 450);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new TaxTile(i++, "Income Taxes", 200);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StationTile(i++, "Station Zuid");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Steenstraat", Municipality.Arnhem, 100, 6, 30, 90, 270, 400, 550);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new ChanceTile(i++, 1);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Ketelstraat", Municipality.Arnhem, 100, 6, 30, 90, 270, 400, 550);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Velperplein", Municipality.Arnhem, 120, 8, 40, 100, 300, 450, 600);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new JailTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Barteljorisstraat", Municipality.Haarlem, 140, 10, 50, 150, 450, 625, 750);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new UtilityTile(i++, "Elektriciteitsbedrijf");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Zijlweg", Municipality.Haarlem, 140, 10, 50, 150, 450, 625, 750);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Houtstraat", Municipality.Haarlem, 160, 12, 60, 180, 500, 700, 900);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StationTile(i++, "Station West");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Neude", Municipality.Utrect, 180, 14, 70, 200, 550, 750, 950);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new CommunityChestTile(i++, 2);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Biltstraat", Municipality.Utrect, 180, 14, 70, 200, 550, 750, 950);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Vreeburg", Municipality.Utrect, 200, 16, 80, 220, 600, 800, 1000);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new FreeParkingTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "A. Kerkhof", Municipality.Groningen, 220, 18, 90, 250, 700, 875, 1050);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new ChanceTile(i++, 2);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Grote Markt", Municipality.Groningen, 220, 18, 90, 250, 700, 875, 1050);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Heerestraat", Municipality.Groningen, 240, 20, 100, 300, 750, 925, 1100);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StationTile(i++, "Station Noord");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Spui", Municipality.DenHaag, 260, 22, 120, 330, 800, 975, 1150);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Plein", Municipality.DenHaag, 260, 22, 120, 330, 800, 975, 1150);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new UtilityTile(i++, "Waterleiding");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "L. Poten", Municipality.DenHaag, 280, 22, 120, 360, 850, 1025, 1200);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new GotoJailTile(i++);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Hofplein", Municipality.Rotterdam, 300, 26, 130, 390, 900, 1100, 1275);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Blaak", Municipality.Rotterdam, 300, 26, 130, 390, 900, 1100, 1275);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new CommunityChestTile(i++, 3);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Coolsingel", Municipality.Rotterdam, 320, 28, 150, 450, 1000, 1200, 1400);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StationTile(i++, "Station Oost");
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new ChanceTile(i++, 3);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Leidsestraat", Municipality.Amsterdam, 350, 35, 175, 500, 1100, 1300, 1500);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        if (settings.isTaxesPercentage()) {
            tile = new TaxPercentageTile(i++, "Taxes", 10);
        } else {
            tile = new TaxTile(i++, "Taxes", 100);
        }
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");

        tile = new StreetTile(i++, "Kalverstraat", Municipality.Amsterdam, 400, 50, 200, 600, 1400, 1700, 2000);
        tileList.add(tile);
        System.out.print("Creating Tile " + tile.getName() + "...");
        System.out.println("[OK]");
        return tileList;
    }

    public TileList getTileList() {

        return this.tileList;
    }

}
