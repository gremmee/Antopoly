package nl.gremmee.antopoly.core.tiles;

public enum Tiles {
    START(0, "Start"), JAIL(10, "Jail"), FREE_PARKING(20, "Free Parking"), GOTO_JAIL(30, "Goto Jail"), //
    INCOME_TAXES(4, "Income Taxes"), TAXES_PERCENTAGE(38, "Taxes Percentage"), //
    COMMUNITY_CHEST_1(2, "Community Chest 1"), COMMUNITY_CHEST_2(17, "Community Chest 2"), COMMUNITY_CHEST_3(33,
            "Community Chest 3"), //
    CHANCE_1(7, "Chance 1"), CHANCE_2(22, "Chance 2"), CHANCE_3(36, "Chance 3"), //
    // Brown
    MEDITERRANEAN_AVENUE(1, "Mediterranean Avenue"), BALTIC_AVENUE(3, "Baltic Avenue"), //
    // Light blue
    ORIENTAL_AVENUE(6, "Oriental Avenue"), VERMONT_AVENUE(8, "Vermont Avenue"), CONNECTICUT_AVENUE(9,
            "Connecticut Avenue"), //
    // Pink
    ST_CHARLES_PLACE(11, "St. Charles Place"), STATES_AVENUE(13, "States Avenue"), VIRGINIA_AVENUE(14,
            "Virginia Avenue"), //
    // Orage
    ST_JAMES_PLACE(16, "St. James Place"), TENNESSEE_AVENUE(18, "Tennessee Avenue"), NEW_YORK_AVENUE(19,
            "New York Avenue"), //
    // Red
    KENTUCKY_AVENUE(21, "Kentucky Avenue"), INDIANA_AVENUE(23, "Indiana Avenue"), ILLINOIS_AVENUE(24,
            "Illinois Avenue"), //
    // Yellow
    ATLANTIC_AVENUE(26, "Atlantic Avenue"), VENTOR_AVENUE(27, "Ventnor Avenue"), MARVIN_GARDENS(29, "Marvin Gardens"), //
    // Green
    PACIFIC_AVENUE(31, "Pacific Avenue"), NORTH_CAROLINA_AVENUE(32, "North Carolina Avenue"), PENNSYLVANIA_AVENUE(34,
            "Pennsylvania Avenue"), //
    // Dark blue
    PARK_PLACE(37, "Park Place"), BOARDWALK(39, "Boardwalk"), //
    READING_RAILROAD(5, "Reading Railroad"), PENNSYLVANIA_RAILROAD(15, "Pennsylvania Railroad"), B_O_RAILROAD(25,
            "B. & O. Railroad"), SHORT_LINE(35, "Short Line"), //
    ELECTRIC_COMPANY(12, "Electric Company"), WATER_WORKS(28, "Water Works");
    ;

    private int id;
    private String name;

    private Tiles(final int aID, final String aName) {
        this.setId(aID);
        this.setName(aName);
    }

    public int getId() {
        return id;
    }

    private void setId(final int aID) {
        this.id = aID;
    }

    public String getName() {
        return name;
    }

    private void setName(final String aName) {
        this.name = aName;
    }

}
