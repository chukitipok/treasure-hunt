package fr.carbonit.th.simulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.carbonit.th.simulation.Orientation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrientationTest {

    @ParameterizedTest
    @MethodSource("provideTurnLeftParameters")
    public void shouldHaveTheCorrectOrientationWhenTurningLeft(final Orientation initialOrientation, final Orientation expectedOrientation) {
        final Orientation result = initialOrientation.left();
        assertEquals(expectedOrientation, result);
    }

    private static Stream<Arguments> provideTurnLeftParameters() {
        return Stream.of(
                Arguments.of(NORTH, WEST),
                Arguments.of(WEST, SOUTH),
                Arguments.of(SOUTH, EAST),
                Arguments.of(EAST, NORTH)
        );
    }
}
