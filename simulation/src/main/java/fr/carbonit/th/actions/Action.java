package fr.carbonit.th.actions;

import fr.carbonit.th.models.Adventurer;

public abstract class Action implements Comparable<Action> {
    public abstract void execute(Adventurer adventurer);

    public int compareTo(Action action) {
        return 1;
    }
}
