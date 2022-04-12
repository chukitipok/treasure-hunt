package fr.carbonit.th.simulation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static fr.carbonit.th.simulation.Orientation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventurerTest {

    private Adventurer adventurer;

    @BeforeEach
    public void init() {
        Position position = new Position(EAST, new Coordinates(0, 0));
        Queue<Action> actions = new PriorityQueue<>(List.of(new Action()));
        adventurer = new Adventurer(position, actions);
    }

    @Test
    public void shouldCollectOneTreasure() {
        Treasure treasure = new Treasure(1, new Coordinates(0, 0));
        adventurer.collect(treasure);

        assertEquals(1, adventurer.getTreasures());
    }

    @Test
    public void shouldCollectManyTreasures() {
        Treasure treasure = new Treasure(2, new Coordinates(0, 0));
        adventurer.collect(treasure);
        adventurer.collect(treasure);

        assertEquals(2, adventurer.getTreasures());
    }

    @Test
    public void shouldNotCollectIfTreasureHasNoChest() {
        Treasure treasure = new Treasure(1, new Coordinates(0, 0));
        adventurer.collect(treasure);
        adventurer.collect(treasure);

        assertEquals(1, adventurer.getTreasures());
    }

    @Test
    public void shouldHaveInitialPosition() {
        assertEquals(new Position(EAST, new Coordinates(1, 1)), adventurer.getPosition());
    }

    @Test
    public void shouldTurnLeft() {
        adventurer.turnLeft();
        assertEquals(NORTH, adventurer.getPosition().getOrientation());
    }

    @Test
    public void shouldTurnRight() {
        adventurer.turnRight();
        assertEquals(SOUTH, adventurer.getPosition().getOrientation());
    }

    @Test
    public void shouldMoveForwardWithEastOrientation() {
        adventurer.moveForward();
        assertEquals(new Position(EAST, new Coordinates(1, 0)), adventurer.getPosition());
    }

    @Test
    public void shouldMoveForwardWithSouthOrientation() {
        Position position = new Position(SOUTH, new Coordinates(0, 0));
        Queue<Action> actions = new PriorityQueue<>(List.of(new Action()));
        adventurer = new Adventurer(position, actions);
        adventurer.moveForward();

        assertEquals(new Position(SOUTH, new Coordinates(0, 1)), adventurer.getPosition());
    }

    @Test
    public void shouldMoveForwardWithWestOrientation() {
        Position position = new Position(WEST, new Coordinates(1, 0));
        Queue<Action> actions = new PriorityQueue<>(List.of(new Action()));
        adventurer = new Adventurer(position, actions);
        adventurer.moveForward();

        assertEquals(new Position(WEST, new Coordinates(0, 0)), adventurer.getPosition());
    }

    @Test
    public void shouldMoveForwardWithNorthOrientation() {
        Position position = new Position(NORTH, new Coordinates(0, 1));
        Queue<Action> actions = new PriorityQueue<>(List.of(new Action()));
        adventurer = new Adventurer(position, actions);
        adventurer.moveForward();

        assertEquals(new Position(NORTH, new Coordinates(0, 0)), adventurer.getPosition());
    }

    @Test
    public void shouldNotMoveNegativeCoordinatesOnAxisX() {
        Position position = new Position(WEST, new Coordinates(0, 0));
        Queue<Action> actions = new PriorityQueue<>(List.of(new Action()));
        adventurer = new Adventurer(position, actions);
        adventurer.moveForward();

        assertEquals(new Position(WEST, new Coordinates(0, 0)), adventurer.getPosition());
    }

    @Test
    public void shouldNotMoveNegativeCoordinatesOnAxisY() {
        Position position = new Position(NORTH, new Coordinates(0, 0));
        Queue<Action> actions = new PriorityQueue<>(List.of(new Action()));
        adventurer = new Adventurer(position, actions);
        adventurer.moveForward();

        assertEquals(new Position(NORTH, new Coordinates(0, 0)), adventurer.getPosition());
    }

    @Test
    public void shouldDoAdventurerTurnLeftAfterExecutingAction() {
        adventurer.executeAction();
        assertEquals(NORTH, adventurer.getPosition().getOrientation());
    }
}
