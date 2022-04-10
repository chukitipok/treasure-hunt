package fr.carbonit.th.configuration;

import fr.carbonit.th.command.Command;
import fr.carbonit.th.command.MountainCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TreasureHuntConfigurationTest {

    private final List<Command> commands = new ArrayList<>();

    @BeforeEach
    public void initCommands() {
        commands.clear();
    }

    @Test
    public void shouldAlertIfMapIsNotFound() {
        commands.add(new MountainCommand("M-1-1"));
        TreasureHuntConfiguration configuration = new TreasureHuntConfiguration(commands);
    }
}
