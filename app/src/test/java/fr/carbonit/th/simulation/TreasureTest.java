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
}
