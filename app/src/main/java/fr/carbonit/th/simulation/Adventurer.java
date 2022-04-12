package fr.carbonit.th.simulation;

public class Adventurer {

    private Position position;
    private Integer treasures;

    public Adventurer(Position position) {
        this.position = position;
        treasures = 0;
    }

    public void collect(Treasure treasure) {
        if (treasure.canBeCollected()) {
            treasures++;
            treasure.collected();
        }
    }

    public void turnLeft() {
    }

    public Integer getTreasures() {
        return treasures;
    }

    public Position getPosition() {
        return position;
    }
}
