package fr.carbonit.th.command;

import fr.carbonit.th.configuration.Mountain;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.ThrowableAssert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MountainCommandTest {

    @Test
    public void shouldAlertIfItemsSizeDifferentThan3() {
        ThrowingCallable callable = () -> new MountainCommand("X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFirstItemIsNotEqualToLetterM() {
        ThrowingCallable callable = () -> new MountainCommand("X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfSecondItemIsNotANumber() {
        ThrowingCallable callable = () -> new MountainCommand("M - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfThirdItemIsNotANumber() {
        ThrowingCallable callable = () -> new MountainCommand("M - 1 - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldCreateMountainCommandInstance() {
        assertThatCode(() -> new MountainCommand("M - 1 - 1")).doesNotThrowAnyException();
    }

    @Test
    public void shouldCreateAnInstanceOfMountain() {
        MountainCommand command = new MountainCommand("M - 1 - 1");
        Mountain mountain = (Mountain) command.handle();

        assertTrue(mountain.getPosition().getX().equals(1)
                && mountain.getPosition().getY().equals(1));
    }
}
