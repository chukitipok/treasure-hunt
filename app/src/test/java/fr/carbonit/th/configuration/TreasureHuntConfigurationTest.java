package fr.carbonit.th.configuration;

import fr.carbonit.th.command.AdventurerCommand;
import fr.carbonit.th.command.Command;
import fr.carbonit.th.command.MapCommand;
import fr.carbonit.th.command.MountainCommand;
import fr.carbonit.th.configuration.exceptions.HuntMapNotFoundException;
import fr.carbonit.th.configuration.exceptions.InvalidTreasureHuntConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.ThrowableAssert.*;

public class TreasureHuntConfigurationTest {

    private final List<Command> commands = new ArrayList<>();

    @BeforeEach
    public void initCommands() {
        commands.clear();
    }

    @Test
    public void shouldAlertIfMapIsNotFound() {
        commands.add(new MountainCommand("M-1-1"));
        ThrowingCallable callable = () -> new TreasureHuntConfiguration(commands);

        assertThatExceptionOfType(HuntMapNotFoundException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfMapTooManyMountains() {
        commands.add(new MapCommand("C-2-2"));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                commands.add(new MountainCommand("M-" + i + "-" + j));
            }
        }

        commands.add(new AdventurerCommand("A-Laura-1-1-S-AAGDDAGAAA"));

        ThrowingCallable callable = () -> new TreasureHuntConfiguration(commands);
        assertThatExceptionOfType(InvalidTreasureHuntConfiguration.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfMapTooManyAdventurers() {
        commands.add(new MapCommand("C-2-2"));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                commands.add(new AdventurerCommand("A-" + i + "-" + j + "-S-AAGDDAGAAA"));
            }
        }

        ThrowingCallable callable = () -> new TreasureHuntConfiguration(commands);
        assertThatExceptionOfType(InvalidTreasureHuntConfiguration.class).isThrownBy(callable);
    }
}
