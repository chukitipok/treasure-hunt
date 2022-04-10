package fr.carbonit.th.configuration;

import fr.carbonit.th.command.*;
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
    public void shouldAlertIfMapHasTooManyMountains() {
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
    public void shouldAlertIfMapHasTooManyAdventurers() {
        commands.add(new MapCommand("C-2-2"));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                commands.add(new AdventurerCommand("A-Laura-" + i + "-" + j + "-S-AAGDDAGAAA"));
            }
        }

        ThrowingCallable callable = () -> new TreasureHuntConfiguration(commands);
        assertThatExceptionOfType(InvalidTreasureHuntConfiguration.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfAdventurersNumberAndMountainsNumberIsMoreThanArea() {
        commands.add(new MapCommand("C-2-2"));

        for (int i = 0; i < 2; i++) {
            commands.add(new MountainCommand("M-" + i + "-" + i));
        }

        for (int j = 0; j < 3; j++) {
            commands.add(new AdventurerCommand("A-Laura-" + j + "-" + j + "-S-AAGDDAGAAA"));
        }

        ThrowingCallable callable = () -> new TreasureHuntConfiguration(commands);
        assertThatExceptionOfType(InvalidTreasureHuntConfiguration.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfTreasuresNumberIsMoreThanArea() {
        commands.add(new MapCommand("C-2-2"));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                commands.add(new TreasureCommand("T-" + i + "-" + j + "-3"));
            }
        }

        commands.add(new AdventurerCommand("A-Laura-1-1-S-AAGDDAGAAA"));

        ThrowingCallable callable = () -> new TreasureHuntConfiguration(commands);
        assertThatExceptionOfType(InvalidTreasureHuntConfiguration.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfAdventurersNumberAndMountainsNumberAndTreasuresNumberIsMoreThanArea() {
        commands.add(new MapCommand("C-2-2"));

        for (int i = 0; i < 2; i++) {
            commands.add(new MountainCommand("M-" + i + "-" + i));
        }

        for (int j = 0; j < 2; j++) {
            commands.add(new TreasureCommand("T-" + j + "-" + j + "-3"));
        }
        commands.add(new AdventurerCommand("A-Laura-0-0-S-AAGDDAGAAA"));

        ThrowingCallable callable = () -> new TreasureHuntConfiguration(commands);
        assertThatExceptionOfType(InvalidTreasureHuntConfiguration.class).isThrownBy(callable);
    }
}
