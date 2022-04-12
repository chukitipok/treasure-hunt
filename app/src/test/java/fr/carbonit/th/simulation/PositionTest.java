package fr.carbonit.th.simulation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.carbonit.th.simulation.Orientation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    public void shouldTurnLeft() {
        final Position position = new Position(NORTH, new Coordinates(0, 0));
        final Position result = position.left();

        assertEquals(new Position(WEST, new Coordinates(0, 0)), result);
    }

    @Test
    public void shouldTurnRight() {
        final Position position = new Position(NORTH, new Coordinates(0, 0));
        final Position result = position.right();

        assertEquals(new Position(EAST, new Coordinates(0, 0)), result);
    }

    @ParameterizedTest
    @MethodSource("provideForwardCalculationArguments")
    public void shouldCalculateForwardPositionWithOrientation(
            final int initialX, final int initialY,
            final Orientation orientation,
            final int expectedX, final int expectedY)
    {
        final Position position = new Position(orientation, new Coordinates(initialX, initialY));
        final Position result = position.forward();

        assertEquals(new Position(orientation, new Coordinates(expectedX, expectedY)), result);
    }

    private static Stream<Arguments> provideForwardCalculationArguments() {
        return Stream.of(
                Arguments.of(0, 2, NORTH, 0, 1),
                Arguments.of(0, 0, SOUTH, 0, 1),
                Arguments.of(0, 0, EAST, 1, 0),
                Arguments.of(1, 0, WEST, 0, 0)
        );
    }
}
