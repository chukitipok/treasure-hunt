package fr.carbonit.th.configuration;

import fr.carbonit.th.command.AdventurerCommand;
import fr.carbonit.th.command.Command;
import fr.carbonit.th.command.MapCommand;
import fr.carbonit.th.command.MountainCommand;
import fr.carbonit.th.configuration.exceptions.AnyAdventurerFoundException;
import fr.carbonit.th.configuration.exceptions.HuntMapNotFoundException;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class TreasureHuntConfiguration {

    private final HuntMap map;
    private final List<Adventurer> adventurers;
    private final List<Mountain> mountains;

    public TreasureHuntConfiguration(Queue<Command> commands) {
        map = handleHuntMap(commands);
        adventurers = handleAdventurers(commands);
        mountains = handleMountains(commands);
    }

    private HuntMap handleHuntMap(Queue<Command> commands) {
        Command mapCommand = commands.stream()
                .filter(command -> command instanceof MapCommand)
                .findFirst()
                .orElseThrow(HuntMapNotFoundException::new);

        return (HuntMap) mapCommand.handle();
    }

    private List<Adventurer> handleAdventurers(Queue<Command> commands) {
        List<Adventurer> adventurers = commands.stream()
                .filter(command -> command instanceof AdventurerCommand)
                .map(command -> (Adventurer) command.handle())
                .collect(Collectors.toList());

        if (adventurers.isEmpty()) {
            throw new AnyAdventurerFoundException();
        }

        return adventurers;
    }

    private List<Mountain> handleMountains(Queue<Command> commands) {
        return commands.stream()
                .filter(command -> command instanceof MountainCommand)
                .map(command -> (Mountain) command.handle())
                .collect(Collectors.toList());
    }
}
