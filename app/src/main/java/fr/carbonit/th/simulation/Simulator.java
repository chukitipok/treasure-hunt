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

        for (int i = 0; i < configuration.getMap().getRows(); i++) {
            for (int j = 0; j < configuration.getMap().getColumns(); j++) {
                UUID uuid = UUID.randomUUID();
                map.put(new Coordinates(i, j), uuid);
            }
        }
    }

    public Map<Coordinates, UUID> getMap() {
        return map;
    }
}
