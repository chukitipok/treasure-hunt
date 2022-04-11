package fr.carbonit.th.simulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventurerTest {

    @Test
    public void shouldIncrementTreasureCollected() {
        Adventurer adventurer = new Adventurer();
        Treasure treasure = new Treasure();
        adventurer.collect(treasure);

        assertEquals(1, adventurer.getTreasures());
    }
}
