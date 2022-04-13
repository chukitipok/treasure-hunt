package fr.carbonit.th.simulation.actions;

import fr.carbonit.th.simulation.models.Adventurer;

public class TurnRightAction extends Action {

    public void execute(Adventurer adventurer) {
        adventurer.turnRight();
    }
}
