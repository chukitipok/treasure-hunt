package fr.carbonit.th.command;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
}
