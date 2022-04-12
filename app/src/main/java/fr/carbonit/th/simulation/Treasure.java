package fr.carbonit.th.simulation;

public class Treasure {

    private Integer chests;
    private final Coordinates position;

    public Treasure(Integer chests, Coordinates position) {
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
}
