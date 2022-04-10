package fr.carbonit.th.command;

import fr.carbonit.th.configuration.HuntMap;
import fr.carbonit.th.configuration.Mountain;
import fr.carbonit.th.configuration.exceptions.InvalidMapException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MountainCommandTest {

    @Test
    public void shouldAlertIfItemsSizeDifferentThan3() {
        ThrowableAssert.ThrowingCallable callable = () -> new MountainCommand("X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFirstItemIsNotEqualToLetterM() {
        ThrowableAssert.ThrowingCallable callable = () -> new MountainCommand("X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfSecondItemIsNotANumber() {
        ThrowableAssert.ThrowingCallable callable = () -> new MountainCommand("M - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfThirdItemIsNotANumber() {
        ThrowableAssert.ThrowingCallable callable = () -> new MountainCommand("M - 1 - X");
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

    @Test
    public void shouldAlertIfRowNumberIsLessThanOne() {
        MapCommand command = new MapCommand("C - 0 - 1");
        ThrowableAssert.ThrowingCallable callable = command::handle;

        assertThatExceptionOfType(InvalidMapException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfColumnNumberIsLessThanOne() {
        MapCommand command = new MapCommand("C - 1 - 0");
        ThrowableAssert.ThrowingCallable callable = command::handle;

        assertThatExceptionOfType(InvalidMapException.class).isThrownBy(callable);
    }

}
