package fr.carbonit.th.simulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreasureTest {

    @Test
    public void shouldBeCollectedOnce() {
        Treasure treasure = new Treasure(1, new Position(0, 0));
        treasure.collected();

        assertEquals(0, treasure.getChests());
    }

    @Test
    public void shouldBeCollectedManyTimes() {
        Treasure treasure = new Treasure(3, new Position(0, 0));
        treasure.collected();
        treasure.collected();

        assertEquals(1, treasure.getChests());
    }

    @Test
    public void shouldNotHaveNegativeChestsNumber() {
        Treasure treasure = new Treasure(1, new Position(0, 0));
        treasure.collected();
        treasure.collected();

        assertEquals(0, treasure.getChests());
    }

    @Test
    public void shouldHaveInitialPosition() {
        Treasure treasure = new Treasure(1, new Position(1, 1));
        assertEquals(new Position(1, 1), treasure.getPosition());
    }
}
