package fr.carbonit.th.simulation;

public class Treasure {

    private Integer chests;

    public Treasure() {
        chests = 1;
    }

    public Treasure(Integer chests) {
        this.chests = chests;
    }

    public Integer getChests() {
        return chests;
    }

    public void collected() {
        if (chests > 0) {
            chests--;
        }
    }
}
