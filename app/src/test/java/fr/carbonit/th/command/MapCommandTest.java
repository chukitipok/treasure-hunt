package fr.carbonit.th.command;

import fr.carbonit.th.configuration.HuntMap;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MapCommandTest {

    @Test
    public void shouldAlertIfItemsSizeDifferentThan3() {
        ThrowableAssert.ThrowingCallable callable = () -> new MapCommand("X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFirstItemIsNotEqualToLetterC() {
        ThrowableAssert.ThrowingCallable callable = () -> new MapCommand("X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfSecondItemIsNotANumber() {
        ThrowableAssert.ThrowingCallable callable = () -> new MapCommand("C - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfThirdItemIsNotANumber() {
        ThrowableAssert.ThrowingCallable callable = () -> new MapCommand("C - 1 - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldCreateMapCommandInstance() {
        assertThatCode(() -> new MapCommand("C - 1 - 1")).doesNotThrowAnyException();
    }


}
