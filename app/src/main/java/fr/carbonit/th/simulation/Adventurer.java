package fr.carbonit.th.simulation;

public class Adventurer {

    private Integer treasures;

    public Adventurer() {
        treasures = 0;
    }

    public void collect(Treasure treasure) {
        treasures++;
    }

    public Integer getTreasures() {
        return treasures;
    }
}
