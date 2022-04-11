package fr.carbonit.th.simulation;

public class Adventurer {

    private Integer treasures;

    public Adventurer() {
        treasures = 0;
    }

    public void collect(Treasure treasure) {
        if (treasure.getChests() > 0) {
            treasures++;
            treasure.collected();
        }
    }

    public Integer getTreasures() {
        return treasures;
    }
}
