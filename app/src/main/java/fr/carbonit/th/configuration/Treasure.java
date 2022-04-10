package fr.carbonit.th.configuration;

import fr.carbonit.th.command.Coordinates;
import fr.carbonit.th.configuration.exceptions.InvalidTreasureException;

public class Treasure {

    private final Coordinates position;
    private final Integer chests;

    public Treasure(Coordinates position, Integer chests) {
        if (chests < 1 || position.getX() < 0 || position.getY() < 0) {
            throw new InvalidTreasureException();
        }

        this.position = position;
        this.chests = chests;
    }
}
