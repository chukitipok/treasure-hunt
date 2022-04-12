package fr.carbonit.th.simulation;

import java.util.Queue;

public class Adventurer {

    private Position position;
    private Integer treasures;
    private Queue<Action> actions;

    public Adventurer(Position position, Queue<Action> actions) {
        this.position = position;
        this.actions = actions;
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

    public void executeAction() {
        Action action = actions.peek();
        action.execute(this);
    }

    public Integer getTreasures() {
        return treasures;
    }

    public Position getPosition() {
        return position;
    }

    public Action getAction() {
        return actions.peek();
    }

    public String toString() {
        return "Adventurer{" +
                "position=" + position +
                ", treasures=" + treasures +
                '}';
    }
}
