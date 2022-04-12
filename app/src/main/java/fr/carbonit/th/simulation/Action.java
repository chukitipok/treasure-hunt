package fr.carbonit.th.simulation;

public abstract class Action implements Comparable<Action> {
    abstract void execute(Adventurer adventurer);

    public int compareTo(Action action) {
        return 1;
    }
}
