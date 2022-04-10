package fr.carbonit.th.configuration;

import fr.carbonit.th.command.Coordinates;
import fr.carbonit.th.configuration.exceptions.InvalidTreasureException;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TreasureTest {

    @Test
    public void shouldAlertIfPositionXIsLessThanZero() {
        Coordinates position = new Coordinates(-1, 0);
        ThrowingCallable callable = () -> new Treasure(position, 3);

        assertThatExceptionOfType(InvalidTreasureException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfPositionYIsLessThanZero() {
        Coordinates position = new Coordinates(0, -1);
        ThrowingCallable callable = () -> new Treasure(position, 3);

        assertThatExceptionOfType(InvalidTreasureException.class).isThrownBy(callable);
    }

}
