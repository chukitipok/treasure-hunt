package fr.carbonit.th.actions;

import fr.carbonit.th.models.Adventurer;

public class TurnRightAction extends Action {

    public void execute(Adventurer adventurer) {
        adventurer.turnRight();
    }
}
