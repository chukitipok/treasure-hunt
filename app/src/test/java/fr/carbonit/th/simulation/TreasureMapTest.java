package fr.carbonit.th.simulation;

import fr.carbonit.th.configuration.TreasureHuntConfiguration;
import fr.carbonit.th.provider.ConfigurationProvider;
import fr.carbonit.th.simulation.mappers.TreasureMapMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreasureMapTest {

    private final ConfigurationProvider provider;
    private TreasureMap map;
    
    public TreasureMapTest() {
        provider = new ConfigurationProvider();
    }

    @BeforeEach
    public void init() {
        TreasureHuntConfiguration configuration = provider.provide();
        map = new TreasureMapMapper().map(configuration);
    }

    @Test
    public void shouldHaveAMapOfCoordinatesAsProperty() {
        assertNotEquals(null, map.getCells());
    }

    @Test
    public void shouldHaveAnAreaEqualsTo12() {
        assertEquals(12, map.getCells().size());
    }

    @Test
    public void shouldFirstMapKeyEqualsTo0_0() {
        assertTrue(map.getCells().containsKey(new Coordinates(0, 0)));
    }

    @Test
    public void shouldLastKeyMapKeyEqualsTo2_3() {
        assertTrue(map.getCells().containsKey(new Coordinates(2, 3)));
    }

    @Test
    public void shouldNotContainCoordinates3_3() {
        assertFalse(map.getCells().containsKey(new Coordinates(3, 3)));
    }

    @Test
    public void shouldNotContainCoordinates2_4() {
        assertFalse(map.getCells().containsKey(new Coordinates(2, 4)));
    }

    @Test
    public void shouldHaveAnAdventurerAtCell1_1() {
        Coordinates key = new Coordinates(1, 1);
        assertTrue(map.containsAdventurerAt(key));
    }

    @Test
    public void shouldNotHaveAnAdventurerAtCell1_0() {
        Coordinates key = new Coordinates(1, 0);
        assertFalse(map.containsAdventurerAt(key));
    }

    @Test
    public void shouldNotHaveATreasureAtCell1_0() {
        Coordinates key = new Coordinates(1, 0);
        assertFalse(map.containsTreasureAt(key));
    }

    @Test
    public void shouldHaveATreasureAtCell1_3() {
        Coordinates key = new Coordinates(1, 3);
        assertTrue(map.containsTreasureAt(key));
    }

    @Test
    public void shouldNotHaveAMountainAtCell2_0() {
        Coordinates key = new Coordinates(1, 0);
        assertFalse(map.containsMountainAt(key));
    }

    @Test
    public void shouldHaveAMountainAtCell1_0() {
        Coordinates key = new Coordinates(1, 3);
        assertTrue(map.containsMountainAt(key));
    }
}
