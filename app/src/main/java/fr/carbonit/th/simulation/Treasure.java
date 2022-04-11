package fr.carbonit.th.simulation;

public class Treasure {

    private Integer chests;

    public Treasure() {
        chests = 1;
    }

    public Integer getChests() {
        return chests;
    }

    public void collected() {
        chests = 0;
    }
}
