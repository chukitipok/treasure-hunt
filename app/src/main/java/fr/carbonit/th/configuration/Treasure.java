package fr.carbonit.th.configuration;

import fr.carbonit.th.command.Coordinates;
import fr.carbonit.th.configuration.exceptions.InvalidChestsNumberException;

public class Treasure {

    private final Coordinates position;
    private final Integer chests;

    public Treasure(Coordinates position, Integer chests) {
        if (chests < 1) {
            throw new InvalidChestsNumberException();
        }

        this.position = position;
        this.chests = chests;
    }
}
