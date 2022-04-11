package fr.carbonit.th.configuration;

import fr.carbonit.th.command.*;
import fr.carbonit.th.configuration.exceptions.AnyAdventurerFoundException;
import fr.carbonit.th.configuration.exceptions.HuntMapNotFoundException;
import fr.carbonit.th.configuration.exceptions.InvalidTreasureHuntConfiguration;

import java.util.List;
import java.util.stream.Collectors;

public class TreasureHuntConfiguration {

    private final HuntMap map;
    private final List<Adventurer> adventurers;
    private final List<Mountain> mountains;
    private final List<Treasure> treasures;

    public TreasureHuntConfiguration(List<Command> commands) {
        map = handleHuntMap(commands);
        adventurers = handleAdventurers(commands);
        mountains = handleMountains(commands);
        treasures = handleTreasures(commands);

        checkValidity();
    }

    private void checkValidity() {
        int mapArea = map.getRows() * map.getColumns();
        int sum = mountains.size() + adventurers.size() + treasures.size();

        if (sum > mapArea)
            throw new InvalidTreasureHuntConfiguration();
    }

    private HuntMap handleHuntMap(List<Command> commands) {
        Command mapCommand = commands.stream()
                .filter(command -> command instanceof MapCommand)
                .findFirst()
                .orElseThrow(HuntMapNotFoundException::new);

        return (HuntMap) mapCommand.handle();
    }

    private List<Adventurer> handleAdventurers(List<Command> commands) {
        List<Adventurer> adventurers = commands.stream()
                .filter(command -> command instanceof AdventurerCommand)
                .map(command -> (Adventurer) command.handle())
                .collect(Collectors.toList());

        if (adventurers.isEmpty()) {
            throw new AnyAdventurerFoundException();
        }

        return adventurers;
    }

    private List<Mountain> handleMountains(List<Command> commands) {
        return commands.stream()
                .filter(command -> command instanceof MountainCommand)
                .map(command -> (Mountain) command.handle())
                .collect(Collectors.toList());
    }

    private List<Treasure> handleTreasures(List<Command> commands) {
        return commands.stream()
                .filter(command -> command instanceof TreasureCommand)
                .map(command -> (Treasure) command.handle())
                .collect(Collectors.toList());
    }

    public HuntMap getMap() {
        return map;
    }
}
