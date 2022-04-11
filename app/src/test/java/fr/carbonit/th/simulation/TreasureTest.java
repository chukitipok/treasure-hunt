package fr.carbonit.th.simulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreasureTest {

    @Test
    public void shouldBeCollectedOnce() {
        Treasure treasure = new Treasure();
        treasure.collected();

        assertEquals(0, treasure.getChests());
    }

    @Test
    public void shouldBeCollectedManyTimes() {
        Treasure treasure = new Treasure(3);
        treasure.collected();
        treasure.collected();

        assertEquals(1, treasure.getChests());
    }
}
