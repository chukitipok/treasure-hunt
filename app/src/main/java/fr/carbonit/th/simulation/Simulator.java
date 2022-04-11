package fr.carbonit.th.simulation;

import fr.carbonit.th.command.Coordinates;
import fr.carbonit.th.configuration.TreasureHuntConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Simulator {

    private final Map<Coordinates, UUID> map;

    public Simulator(TreasureHuntConfiguration configuration) {
        map = new HashMap<>();
    }

    public Map<Coordinates, UUID> getMap() {
        return map;
    }
}
