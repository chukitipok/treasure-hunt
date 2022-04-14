package fr.carbonit.th;

import fr.carbonit.th.actions.Action;
import fr.carbonit.th.actions.MoveForwardAction;
import fr.carbonit.th.actions.TurnLeftAction;
import fr.carbonit.th.actions.TurnRightAction;
import fr.carbonit.th.models.Adventurer;
import fr.carbonit.th.localisation.Coordinates;
import fr.carbonit.th.models.Treasure;
import fr.carbonit.th.models.TreasureMap;

import java.util.List;
import java.util.Optional;

public class Simulator {

    public TreasureMap simulate(TreasureMap configuration) {
        List<Adventurer> adventurers = configuration.getAdventurers();

        while(!isHuntOver(adventurers)) {
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
        }

        return configuration;
    }

    private boolean isHuntOver(List<Adventurer> adventurers) {
        Optional<Integer> optional = adventurers.stream()
                .map(adventurer -> adventurer.getActions().size())
                .reduce(Integer::sum);

        return optional.isPresent() && optional.get() == 0;
    }
}
