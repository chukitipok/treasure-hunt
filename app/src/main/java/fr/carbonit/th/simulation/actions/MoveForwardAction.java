package fr.carbonit.th.simulation.actions;

import fr.carbonit.th.simulation.Adventurer;

public class MoveForwardAction extends Action {

    public void execute(Adventurer adventurer) {
        adventurer.moveForward();
    }
}
