package fr.carbonit.th.configuration;

import fr.carbonit.th.command.Coordinates;

public class Adventurer {

    private final String name;
    private final Coordinates position;
    private final String orientation;
    private final String actions;

    public Adventurer(String name, Coordinates position, String orientation, String actions) {
        this.name = name;
        this.position = position;
        this.orientation = orientation;
        this.actions = actions;
    }

    public String getName() {
        return name;
    }

    public Coordinates getPosition() {
        return position;
    }

    public String getOrientation() {
        return orientation;
    }

    public String getActions() {
        return actions;
    }
}
