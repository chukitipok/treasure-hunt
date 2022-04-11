package fr.carbonit.th.simulation;

public class Treasure {

    private Integer chests;
    private final Position position;

    public Treasure(Integer chests, Position position) {
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

    public Position getPosition() {
        return position;
    }
}
