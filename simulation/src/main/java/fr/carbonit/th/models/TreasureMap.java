package fr.carbonit.th.models;

import fr.carbonit.th.localisation.Coordinates;

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

    public boolean containsAdventurerAt(Coordinates key) {
        UUID cellValue = cells.get(key);
        List<UUID> ids = adventurers.stream().map(Adventurer::getId).collect(Collectors.toList());

        return ids.contains(cellValue);
    }

    public boolean containsTreasureAt(Coordinates key) {
        UUID cellValue = cells.get(key);
        List<UUID> ids = treasures.stream().map(Treasure::getId).collect(Collectors.toList());

        return ids.contains(cellValue);
    }

    public boolean containsMountainAt(Coordinates key) {
        UUID cellValue = cells.get(key);
        List<UUID> ids = mountains.stream().map(Mountain::getId).collect(Collectors.toList());

        return ids.contains(cellValue);
    }

    public void swap(Coordinates position1, Coordinates position2) {
        UUID temporary = cells.get(position1);
        cells.remove(position1);

        cells.put(position1, cells.get(position2));
        cells.remove(position2);

        cells.put(position2, temporary);
    }

    public boolean canCollectTreasure(Adventurer adventurer) {
        Coordinates target = adventurer.getPosition().forward().getCoordinates();
        return containsTreasureAt(target);
    }

    public boolean canMoveForward(Adventurer adventurer) {
        Coordinates target = adventurer.getPosition().forward().getCoordinates();
        return !containsAdventurerAt(target) && !containsMountainAt(target);
    }

    public Map<Coordinates, UUID> getCells() {
        return cells;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    public List<Mountain> getMountains() {
        return mountains;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }
}
