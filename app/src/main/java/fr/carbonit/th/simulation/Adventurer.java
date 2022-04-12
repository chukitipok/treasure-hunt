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
        position = position.left();
    }

    public void turnRight() {
        position = position.right();
    }

    public void moveForward() {
        Position newPosition = position.forward();
        Coordinates coordinates = newPosition.getCoordinates();

        if (coordinates.getX() >= 0 && coordinates.getY() >= 0) {
            position = newPosition;
        }
    }

    public Integer getTreasures() {
        return treasures;
    }

    public Position getPosition() {
        return position;
    }

    public String toString() {
        return "Adventurer{" +
                "position=" + position +
                ", treasures=" + treasures +
                '}';
    }
}
