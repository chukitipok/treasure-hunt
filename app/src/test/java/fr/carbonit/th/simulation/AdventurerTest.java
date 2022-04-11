package fr.carbonit.th.simulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventurerTest {

    @Test
    public void shouldCollectOneTreasure() {
        Adventurer adventurer = new Adventurer();
        Treasure treasure = new Treasure(1, new Position(0, 0));
        adventurer.collect(treasure);

        assertEquals(1, adventurer.getTreasures());
    }

    @Test
    public void shouldCollectManyTreasures() {
        Adventurer adventurer = new Adventurer();
        Treasure treasure = new Treasure(2, new Position(0, 0));
        adventurer.collect(treasure);
        adventurer.collect(treasure);

        assertEquals(2, adventurer.getTreasures());
    }

    @Test
    public void shouldNotCollectIfTreasureHasNoChest() {
        Adventurer adventurer = new Adventurer();
        Treasure treasure = new Treasure(1, new Position(0, 0));
        adventurer.collect(treasure);
        adventurer.collect(treasure);

        assertEquals(1, adventurer.getTreasures());
    }
}
