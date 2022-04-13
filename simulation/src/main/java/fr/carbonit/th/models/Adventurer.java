package fr.carbonit.th.models;

import fr.carbonit.th.actions.Action;
import fr.carbonit.th.localisation.Coordinates;
import fr.carbonit.th.localisation.Position;

import java.util.Queue;
import java.util.UUID;

public class Adventurer {

    private final UUID uuid;
    private final String name;
    private Position position;
    private Integer treasures;
    private final Queue<Action> actions;

    public Adventurer(String name, Position position, Queue<Action> actions) {
        this.name = name;
        this.position = position;
        this.actions = actions;
        treasures = 0;
        uuid = UUID.randomUUID();
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
        Action action = actions.poll();

        if (action != null) {
            action.execute(this);
        }
    }

    public UUID getId() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Queue<Action> getActions() {
        return actions;
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
                ", actions=" + actions +
                '}';
    }
}
