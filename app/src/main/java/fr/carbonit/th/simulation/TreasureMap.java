package fr.carbonit.th.simulation;

import fr.carbonit.th.configuration.TreasureHuntConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TreasureMap {
    private final Map<Coordinates, UUID> cells;

    public TreasureMap(TreasureHuntConfiguration configuration) {
        cells = new HashMap<>();

        for (int i = 0; i < configuration.getMap().getRows(); i++) {
            for (int j = 0; j < configuration.getMap().getColumns(); j++) {
                UUID uuid = UUID.randomUUID();
                cells.put(new Coordinates(i, j), uuid);
            }
        }
    }

    public Map<Coordinates, UUID> getCells() {
        return cells;
    }
}
