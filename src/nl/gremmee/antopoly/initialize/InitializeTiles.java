package nl.gremmee.antopoly.initialize;

import nl.gremmee.antopoly.Settings;
import nl.gremmee.antopoly.core.Municipality;
import nl.gremmee.antopoly.core.lists.TileList;
import nl.gremmee.antopoly.core.tiles.ITile;
import nl.gremmee.antopoly.core.tiles.Tiles;
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
        this.tileList = new TileList();

        ITile tile = new StartTile(Tiles.START);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.MEDITERRANEAN_AVENUE, Municipality.BROWN, 60, 2, 10, 30, 90, 160, 250);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new CommunityChestTile(Tiles.COMMUNITY_CHEST_1);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.BALTIC_AVENUE, Municipality.BROWN, 60, 4, 20, 60, 180, 320, 450);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new TaxTile(Tiles.INCOME_TAXES, 200);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StationTile(Tiles.READING_RAILROAD);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.ORIENTAL_AVENUE, Municipality.BLUE, 100, 6, 30, 90, 270, 400, 550);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new ChanceTile(Tiles.CHANCE_1);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.VERMONT_AVENUE, Municipality.BLUE, 100, 6, 30, 90, 270, 400, 550);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.CONNECTICUT_AVENUE, Municipality.BLUE, 120, 8, 40, 100, 300, 450, 600);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new JailTile(Tiles.JAIL);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.ST_CHARLES_PLACE, Municipality.PINK, 140, 10, 50, 150, 450, 625, 750);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new UtilityTile(Tiles.ELECTRIC_COMPANY);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.STATES_AVENUE, Municipality.PINK, 140, 10, 50, 150, 450, 625, 750);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.VIRGINIA_AVENUE, Municipality.PINK, 160, 12, 60, 180, 500, 700, 900);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StationTile(Tiles.PENNSYLVANIA_RAILROAD);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.ST_JAMES_PLACE, Municipality.ORANGE, 180, 14, 70, 200, 550, 750, 950);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new CommunityChestTile(Tiles.COMMUNITY_CHEST_2);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.TENNESSEE_AVENUE, Municipality.ORANGE, 180, 14, 70, 200, 550, 750, 950);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.NEW_YORK_AVENUE, Municipality.ORANGE, 200, 16, 80, 220, 600, 800, 1000);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new FreeParkingTile(Tiles.FREE_PARKING);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.KENTUCKY_AVENUE, Municipality.RED, 220, 18, 90, 250, 700, 875, 1050);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new ChanceTile(Tiles.CHANCE_2);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.INDIANA_AVENUE, Municipality.RED, 220, 18, 90, 250, 700, 875, 1050);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.ILLINOIS_AVENUE, Municipality.RED, 240, 20, 100, 300, 750, 925, 1100);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StationTile(Tiles.B_O_RAILROAD);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.ATLANTIC_AVENUE, Municipality.YELLOW, 260, 22, 120, 330, 800, 975, 1150);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.VENTOR_AVENUE, Municipality.YELLOW, 260, 22, 120, 330, 800, 975, 1150);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new UtilityTile(Tiles.WATER_WORKS);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.MARVIN_GARDENS, Municipality.YELLOW, 280, 22, 120, 360, 850, 1025, 1200);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new GotoJailTile(Tiles.GOTO_JAIL);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.PACIFIC_AVENUE, Municipality.GREEM, 300, 26, 130, 390, 900, 1100, 1275);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.NORTH_CAROLINA_AVENUE, Municipality.GREEM, 300, 26, 130, 390, 900, 1100, 1275);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new CommunityChestTile(Tiles.COMMUNITY_CHEST_3);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.PENNSYLVANIA_AVENUE, Municipality.GREEM, 320, 28, 150, 450, 1000, 1200, 1400);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StationTile(Tiles.SHORT_LINE);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new ChanceTile(Tiles.CHANCE_3);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.PARK_PLACE, Municipality.PURPLE, 350, 35, 175, 500, 1100, 1300, 1500);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        if (settings.isTaxesPercentage()) {
            tile = new TaxPercentageTile(Tiles.TAXES_PERCENTAGE, 10);
        } else {
            tile = new TaxTile(Tiles.TAXES_PERCENTAGE, 100);
        }
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");

        tile = new StreetTile(Tiles.BOARDWALK, Municipality.PURPLE, 400, 50, 200, 600, 1400, 1700, 2000);
        this.tileList.add(tile);
        System.out.println("Creating Tile " + tile.getName() + "...[OK]");
        return this.tileList;
    }

    public TileList getTileList() {

        return this.tileList;
    }

}
