package fr.carbonit.th.simulation;

import fr.carbonit.th.configuration.TreasureHuntConfiguration;
import fr.carbonit.th.provider.ConfigurationProvider;
import fr.carbonit.th.simulation.models.Adventurer;
import fr.carbonit.th.simulation.localisation.Coordinates;
import fr.carbonit.th.simulation.mappers.TreasureMapMapper;
import fr.carbonit.th.simulation.models.TreasureMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulatorTest {

    private final ConfigurationProvider provider;
    private final Simulator simulator;
    private final TreasureMapMapper mapper;

    public SimulatorTest() {
        simulator = new Simulator();
        provider = new ConfigurationProvider();
        mapper = new TreasureMapMapper();
    }

    @Test
    public void shouldAdventurerHaveCollected3Treasures() {
        TreasureHuntConfiguration configuration = provider.provideFullSimulation();
        TreasureMap map = simulator.simulate(mapper.map(configuration));
        Adventurer adventurer = map.getAdventurers().get(0);

        assertEquals(3, adventurer.getTreasures());
    }

    @Test
    public void shouldAdventurerBeAtCoordinates0_3() {
        TreasureHuntConfiguration configuration = provider.provideFullSimulation();
        TreasureMap map = simulator.simulate(mapper.map(configuration));
        Adventurer adventurer = map.getAdventurers().get(0);

        assertEquals(new Coordinates(0, 3), adventurer.getPosition().getCoordinates());
    }
}
