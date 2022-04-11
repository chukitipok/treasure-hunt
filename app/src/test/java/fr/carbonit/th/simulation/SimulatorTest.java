package fr.carbonit.th.simulation;

import fr.carbonit.th.command.Coordinates;
import fr.carbonit.th.configuration.TreasureHuntConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimulatorTest {

    private final ConfigurationProvider provider;
    private Simulator simulator;

    public SimulatorTest() {
        provider = new ConfigurationProvider();
    }

    @BeforeEach
    public void init() {
        TreasureHuntConfiguration configuration = provider.provide();
        simulator = new Simulator(configuration);
    }

    @Test
    public void shouldHaveAMapOfCoordinatesAsProperty() {
        assertNotEquals(null, simulator.getMap());
    }

    @Test
    public void shouldHaveASizeMapEqualsTo12() {
        assertEquals(12, simulator.getMap().size());
    }

    @Test
    public void shouldFirstMapKeyEqualsTo0_0() {
        assertTrue(simulator.getMap().containsKey(new Coordinates(0, 0)));
    }

    @Test
    public void shouldLastKeyMapKeyEqualsTo2_3() {
        assertTrue(simulator.getMap().containsKey(new Coordinates(2, 3)));
    }

    @Test
    public void shouldNotContainCoordinates3_3() {
        assertFalse(simulator.getMap().containsKey(new Coordinates(3, 3)));
    }

    @Test
    public void shouldNotContainCoordinates2_4() {
        assertFalse(simulator.getMap().containsKey(new Coordinates(2, 4)));
    }
}
