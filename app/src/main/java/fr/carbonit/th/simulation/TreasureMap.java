package fr.carbonit.th.simulation;

import fr.carbonit.th.configuration.TreasureHuntConfiguration;
import fr.carbonit.th.simulation.mappers.AdventurerMapper;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureMap {
    private final Map<Coordinates, UUID> cells;
    private final List<Adventurer> adventurers;
    private final List<Mountain> mountains;
    private final List<Treasure> treasures;

    public TreasureMap(Map<Coordinates, UUID> plains, List<Mountain> mountains,
                       List<Adventurer> adventurers, List<Treasure> treasures) {
        this.cells = plains;
        this.mountains = mountains;
        this.adventurers = adventurers;
        this.treasures = treasures;
    }

    public Map<Coordinates, UUID> getCells() {
        return cells;
    }

    public boolean containsAdventurerAt(Coordinates key) {
        UUID cellValue = cells.get(key);
        List<UUID> ids = adventurers.stream().map(Adventurer::getId).collect(Collectors.toList());

        return ids.contains(cellValue);
    }
}
