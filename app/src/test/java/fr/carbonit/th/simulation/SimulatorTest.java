package fr.carbonit.th.simulation;

import fr.carbonit.th.configuration.TreasureHuntConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
}
