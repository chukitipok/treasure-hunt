package fr.carbonit.th.parser;

import fr.carbonit.th.configuration.TreasureHuntConfiguration;
import fr.carbonit.th.command.Command;
import fr.carbonit.th.command.CommandFactory;
import fr.carbonit.th.command.InvalidCommandException;
import fr.carbonit.th.reader.Reader;

import java.io.File;
import java.util.*;

public class ConfigurationParser {

    private final Reader reader;

    public ConfigurationParser(Reader reader) {
        this.reader = reader;
    }

    public TreasureHuntConfiguration parse(File file) {
        try {
            List<String> content = reader.read(file);
            Queue<Command> commands = new PriorityQueue<>();
            CommandFactory commandFactory = new CommandFactory();

            for (var row : content) {
                Command command = commandFactory.create(row);
                commands.add(command);
            }

            return new TreasureHuntConfiguration(commands);
        }
        catch (InvalidCommandException exception) {
            throw new UnparsableFileException();
        }
    }
}
