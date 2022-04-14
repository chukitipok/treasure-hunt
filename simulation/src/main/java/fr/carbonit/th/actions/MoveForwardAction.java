package fr.carbonit.th.actions;

import fr.carbonit.th.models.Adventurer;

public class MoveForwardAction implements Action {

    public void execute(Adventurer adventurer) {
        adventurer.moveForward();
    }
}
