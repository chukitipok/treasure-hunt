package fr.carbonit.th.simulation;

public class Adventurer {

    private Coordinates position;
    private Integer treasures;

    public Adventurer(Coordinates position) {
        this.position = position;
        treasures = 0;
    }

    public void collect(Treasure treasure) {
        if (treasure.canBeCollected()) {
            treasures++;
            treasure.collected();
        }
    }

    public Integer getTreasures() {
        return treasures;
    }

    public Coordinates getPosition() {
        return position;
    }
}
