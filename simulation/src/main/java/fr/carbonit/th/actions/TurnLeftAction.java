package fr.carbonit.th.actions;

import fr.carbonit.th.models.Adventurer;

public class TurnLeftAction implements Action {

    public void execute(Adventurer adventurer) {
        adventurer.turnLeft();
    }
}
