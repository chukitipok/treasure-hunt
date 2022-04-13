package fr.carbonit.th.simulation;

import fr.carbonit.th.simulation.actions.Action;
import fr.carbonit.th.simulation.actions.MoveForwardAction;
import fr.carbonit.th.simulation.actions.TurnLeftAction;
import fr.carbonit.th.simulation.actions.TurnRightAction;
import fr.carbonit.th.simulation.models.Adventurer;
import fr.carbonit.th.simulation.localisation.Coordinates;
import fr.carbonit.th.simulation.models.Treasure;
import fr.carbonit.th.simulation.models.TreasureMap;

import java.util.List;
import java.util.Optional;

public class Simulator {

    public TreasureMap simulate(TreasureMap configuration) {
        List<Adventurer> adventurers = configuration.getAdventurers();
        boolean stillActionsToExecute = true;

        while(stillActionsToExecute) {
            for (Adventurer adventurer : adventurers) {
                Action action = adventurer.getActions().poll();

                if (action instanceof MoveForwardAction) {
                    if (configuration.canMoveForward(adventurer)) {
                        Coordinates position = adventurer.getPosition().forward().getCoordinates();

                        if (configuration.canCollectTreasure(adventurer)) {
                            Optional<Treasure> optional = configuration.getTreasures().stream()
                                    .filter(treasure -> treasure.getPosition().equals(position))
                                    .findFirst();

                            optional.ifPresent(adventurer::collect);
                        }

                        action.execute(adventurer);
                        configuration.swap(adventurer.getPosition().getCoordinates(), position);
                    }
                }
                else if (action instanceof TurnLeftAction) {
                    action.execute(adventurer);
                }
                else if (action instanceof TurnRightAction){
                    action.execute(adventurer);
                }
            }

            Optional<Integer> actions = adventurers.stream()
                    .map(adventurer -> adventurer.getActions().size())
                    .reduce(Integer::sum);

            if (actions.isPresent() && actions.get() == 0) {
                stillActionsToExecute = false;
            }
        }

        return configuration;
    }
}
