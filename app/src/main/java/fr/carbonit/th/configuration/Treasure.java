package fr.carbonit.th.configuration;

import fr.carbonit.th.command.Coordinates;

public class Treasure {

    private final Coordinates position;
    private final Integer chests;

    public Treasure(Coordinates position, Integer chests) {
        this.position = position;
        this.chests = chests;
    }
}
