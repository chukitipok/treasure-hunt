package fr.carbonit.th.configuration;

import fr.carbonit.th.command.Coordinates;
import fr.carbonit.th.configuration.exceptions.InvalidMountainException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MountainTest {

    @Test
    public void shouldAlertIfPositionXIsLessThanZero() {
        Coordinates position = new Coordinates(-1, 1);
        ThrowableAssert.ThrowingCallable callable = () -> new Mountain(position);

        assertThatExceptionOfType(InvalidMountainException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfPositionYIsLessThanZero() {
        Coordinates position = new Coordinates(0, -1);
        ThrowableAssert.ThrowingCallable callable = () -> new Mountain(position);

        assertThatExceptionOfType(InvalidMountainException.class).isThrownBy(callable);
    }
}
