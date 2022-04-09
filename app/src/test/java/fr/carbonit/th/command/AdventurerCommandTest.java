package fr.carbonit.th.command;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AdventurerCommandTest {

    @Test
    public void shouldAlertIfItemsSizeDifferentThan6() {
        ThrowableAssert.ThrowingCallable callable = () -> new AdventurerCommand("X - X - X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFirstItemIsNotEqualToLetterA() {
        ThrowableAssert.ThrowingCallable callable = () -> new AdventurerCommand("X - X - X - X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfSecondItemIsNotAString() {
        ThrowableAssert.ThrowingCallable callable = () -> new AdventurerCommand("A - 1 - X - X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfThirdItemIsNotANumber() {
        ThrowableAssert.ThrowingCallable callable = () -> new AdventurerCommand("A - Xxx - X - X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFourthItemIsNotANumber() {
        ThrowableAssert.ThrowingCallable callable = () -> new AdventurerCommand("A - Xxx - 1 - X - X - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFifthItemIsNotAString() {
        ThrowableAssert.ThrowingCallable callable = () -> new AdventurerCommand("A - Xxx - 1 - 1 - 1 - X");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfSixthItemIsNotAString() {
        ThrowableAssert.ThrowingCallable callable = () -> new AdventurerCommand("A - Xxx - 1 - 1 - 1 - 1");
        assertThatExceptionOfType(InvalidCommandException.class).isThrownBy(callable);
    }

    @Test
    public void shouldCreateAdventurerCommandInstance() {
        assertThatCode(() -> new AdventurerCommand("A - Xxx - 1 - 1 - S - AADGAADAGA"))
                .doesNotThrowAnyException();
    }
}
