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
}
