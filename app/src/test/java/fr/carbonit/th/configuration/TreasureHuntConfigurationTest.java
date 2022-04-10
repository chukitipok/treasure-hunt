package fr.carbonit.th.configuration;

import fr.carbonit.th.command.Command;
import fr.carbonit.th.command.MountainCommand;
import fr.carbonit.th.configuration.exceptions.HuntMapNotFoundException;
import org.assertj.core.api.ThrowableAssert;
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
}
