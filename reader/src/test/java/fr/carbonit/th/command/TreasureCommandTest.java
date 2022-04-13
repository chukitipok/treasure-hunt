package fr.carbonit.th.command;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.ThrowableAssert.*;

public class TreasureCommandTest {

    @Test
    public void shouldAlertIfItemsSizeDifferentThan4() {
        ThrowingCallable callable = () -> new TreasureCommand("X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFirstItemIsNotEqualToLetterT() {
        ThrowingCallable callable = () -> new TreasureCommand("X - X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfSecondItemIsNotANumber() {
        ThrowingCallable callable = () -> new TreasureCommand("T - X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfThirdItemIsNotANumber() {
        ThrowingCallable callable = () -> new TreasureCommand("T - 1 - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFourthItemIsNotANumber() {
        ThrowingCallable callable = () -> new TreasureCommand("T - 1 - 1 - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldCreateTreasureCommandInstance() {
        assertThatCode(() -> new TreasureCommand("T - 1 - 1 - 2")).doesNotThrowAnyException();
    }

    @Test
    public void shouldAlertIfLastItemValueIsLessThanOne() {
        TreasureCommand command = new TreasureCommand("T - 1 - 1 - 0");
        ThrowingCallable callable = command::handle;

        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }
}
