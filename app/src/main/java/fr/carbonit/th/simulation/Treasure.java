package fr.carbonit.th.simulation;

import java.util.UUID;

public class Treasure {

    private final UUID uuid;
    private Integer chests;
    private final Coordinates position;

    public Treasure(Integer chests, Coordinates position) {
        this.uuid = UUID.randomUUID();
        this.chests = chests;
        this.position = position;
    }

    public void collected() {
        if (canBeCollected()) {
            chests--;
        }
    }

    public boolean canBeCollected() {
        return chests > 0;
    }

    public Integer getChests() {
        return chests;
    }

    public Coordinates getPosition() {
        return position;
    }

    public UUID getId() {
        return uuid;
    }
}
