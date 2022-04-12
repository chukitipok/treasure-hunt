package fr.carbonit.th.simulation;

import org.junit.jupiter.api.Test;

import static fr.carbonit.th.simulation.Orientation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventurerTest {

    @Test
    public void shouldCollectOneTreasure() {
        Adventurer adventurer = new Adventurer(new Position(NORTH, new Coordinates(1, 1)));
        Treasure treasure = new Treasure(1, new Coordinates(0, 0));
        adventurer.collect(treasure);

        assertEquals(1, adventurer.getTreasures());
    }

    @Test
    public void shouldCollectManyTreasures() {
        Adventurer adventurer = new Adventurer(new Position(NORTH, new Coordinates(1, 1)));
        Treasure treasure = new Treasure(2, new Coordinates(0, 0));
        adventurer.collect(treasure);
        adventurer.collect(treasure);

        assertEquals(2, adventurer.getTreasures());
    }

    @Test
    public void shouldNotCollectIfTreasureHasNoChest() {
        Adventurer adventurer = new Adventurer(new Position(NORTH, new Coordinates(1, 1)));
        Treasure treasure = new Treasure(1, new Coordinates(0, 0));
        adventurer.collect(treasure);
        adventurer.collect(treasure);

        assertEquals(1, adventurer.getTreasures());
    }

    @Test
    public void shouldHaveInitialPosition() {
        Adventurer adventurer = new Adventurer(new Position(NORTH, new Coordinates(1, 1)));
        assertEquals(new Position(NORTH, new Coordinates(1, 1)), adventurer.getPosition());
    }

    @Test
    public void shouldTurnLeft() {
        Adventurer adventurer = new Adventurer(new Position(NORTH, new Coordinates(3, 3)));
        adventurer.turnLeft();

        assertEquals(WEST, adventurer.getPosition().getOrientation());
    }
}
