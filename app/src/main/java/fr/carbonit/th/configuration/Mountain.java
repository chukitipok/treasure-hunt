package fr.carbonit.th.configuration;

import fr.carbonit.th.command.Coordinates;
import fr.carbonit.th.configuration.exceptions.InvalidMountainException;


public class Mountain {

    private final Coordinates position;

    public Mountain(Coordinates position) {
        if (position.getX() < 0) {
            throw new InvalidMountainException();
        }

        this.position = position;
    }

    public Coordinates getPosition() {
        return position;
    }
}
