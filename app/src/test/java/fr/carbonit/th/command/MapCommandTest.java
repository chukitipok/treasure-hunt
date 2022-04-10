package fr.carbonit.th.command;

import fr.carbonit.th.configuration.HuntMap;
import fr.carbonit.th.configuration.exceptions.InvalidMapException;
import org.assertj.core.api.ThrowableAssert;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapCommandTest {

    @Test
    public void shouldAlertIfItemsSizeDifferentThan3() {
        ThrowingCallable callable = () -> new MapCommand("X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFirstItemIsNotEqualToLetterC() {
        ThrowingCallable callable = () -> new MapCommand("X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfSecondItemIsNotANumber() {
        ThrowingCallable callable = () -> new MapCommand("C - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfThirdItemIsNotANumber() {
        ThrowingCallable callable = () -> new MapCommand("C - 1 - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldCreateMapCommandInstance() {
        assertThatCode(() -> new MapCommand("C - 1 - 1")).doesNotThrowAnyException();
    }

    @Test
    public void shouldCreateAnInstanceOfHunMap() {
        MapCommand command = new MapCommand("C - 1 - 1");
        HuntMap map = (HuntMap) command.handle();

        assertTrue(map.getRows().equals(1) && map.getColumns().equals(1));
    }

    @Test
    public void shouldAlertIfRowNumberIsLessThanOne() {
        MapCommand command = new MapCommand("C - 0 - 1");
        ThrowingCallable callable = command::handle;

        assertThatExceptionOfType(InvalidMapException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfColumnNumberIsLessThanOne() {
        MapCommand command = new MapCommand("C - 1 - 0");
        ThrowingCallable callable = command::handle;

        assertThatExceptionOfType(InvalidMapException.class).isThrownBy(callable);
    }
}
