package fr.carbonit.th.simulation;

import org.junit.jupiter.api.Test;

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
}
