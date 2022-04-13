package fr.carbonit.th;

import fr.carbonit.th.localisation.Orientation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.carbonit.th.localisation.Orientation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrientationTest {

    @ParameterizedTest
    @MethodSource("provideTurnLeftParameters")
    public void shouldHaveTheCorrectOrientationWhenTurningLeft(final Orientation initialOrientation, final Orientation expectedOrientation) {
        final Orientation result = initialOrientation.left();
        assertEquals(expectedOrientation, result);
    }

    @ParameterizedTest
    @MethodSource("provideTurnRightParameters")
    public void shouldHaveTheCorrectOrientationWhenTurningRight(final Orientation initialOrientation, final Orientation expectedOrientation) {
        final Orientation result = initialOrientation.right();
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

    private static Stream<Arguments> provideTurnRightParameters() {
        return Stream.of(
                Arguments.of(NORTH, EAST),
                Arguments.of(EAST, SOUTH),
                Arguments.of(SOUTH, WEST),
                Arguments.of(WEST, NORTH)
        );
    }
}
