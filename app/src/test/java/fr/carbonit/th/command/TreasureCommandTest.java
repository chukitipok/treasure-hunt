package fr.carbonit.th.command;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TreasureCommandTest {

    @Test
    public void shouldAlertIfItemsSizeDifferentThan4() {
        ThrowableAssert.ThrowingCallable callable = () -> new TreasureCommand("X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFirstItemIsNotEqualToLetterT() {
        ThrowableAssert.ThrowingCallable callable = () -> new TreasureCommand("X - X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfSecondItemIsNotANumber() {
        ThrowableAssert.ThrowingCallable callable = () -> new TreasureCommand("T - X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfThirdItemIsNotANumber() {
        ThrowableAssert.ThrowingCallable callable = () -> new TreasureCommand("T - 1 - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFourthItemIsNotANumber() {
        ThrowableAssert.ThrowingCallable callable = () -> new TreasureCommand("T - 1 - 1 - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldCreateTreasureCommandInstance() {
        assertThatCode(() -> new TreasureCommand("T - 1 - 1 - 2")).doesNotThrowAnyException();
    }
}
