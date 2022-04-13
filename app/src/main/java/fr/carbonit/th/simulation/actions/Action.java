package fr.carbonit.th.simulation.actions;

import fr.carbonit.th.simulation.models.Adventurer;

public abstract class Action implements Comparable<Action> {
    public abstract void execute(Adventurer adventurer);

    public int compareTo(Action action) {
        return 1;
    }
}
