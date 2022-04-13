package fr.carbonit.th.simulation.mappers;

import fr.carbonit.th.configuration.HuntMap;
import fr.carbonit.th.configuration.TreasureHuntConfiguration;
import fr.carbonit.th.simulation.*;

import java.util.*;

public class TreasureMapMapper {

    public TreasureMap map(TreasureHuntConfiguration configuration) {
        List<Adventurer> adventurers = mapAdventurers(configuration.getAdventurers());
        List<Mountain> mountains = mapMountains(configuration.getMountains());
        List<Treasure> treasures = mapTreasures(configuration.getTreasures());
        Map<Coordinates, UUID> plains = initializePlains(configuration.getMap());

        placeElements(plains, adventurers, mountains, treasures);

        return new TreasureMap(plains, mountains, adventurers, treasures);
    }

    private void placeElements(Map<Coordinates, UUID> plains, List<Adventurer> adventurers,
                               List<Mountain> mountains, List<Treasure> treasures)
    {
        for (var mountain : mountains) {
            plains.remove(mountain.getPosition());
            plains.put(mountain.getPosition(), mountain.getId());
        }

        for (var adventurer : adventurers) {
            plains.remove(adventurer.getPosition().getCoordinates());
            plains.put(adventurer.getPosition().getCoordinates(), adventurer.getId());
        }

        for (var treasure : treasures) {
            plains.remove(treasure.getPosition());
            plains.put(treasure.getPosition(), treasure.getId());
        }
    }

    private Map<Coordinates, UUID> initializePlains(HuntMap map) {
        Map<Coordinates, UUID> plains = new HashMap<>();

        for (int i = 0; i < map.getRows(); i++) {
            for (int j = 0; j < map.getColumns(); j++) {
                UUID uuid = UUID.randomUUID();
                plains.put(new Coordinates(i, j), uuid);
            }
        }

        return plains;
    }

    private List<Mountain> mapMountains(List<fr.carbonit.th.configuration.Mountain> mountains) {
        List<Mountain> result = new ArrayList<>();

        for (var mountain : mountains) {
            Coordinates position = new Coordinates(mountain.getPosition().getX(), mountain.getPosition().getY());
            result.add(new Mountain(UUID.randomUUID(), position));
        }

        return result;
    }

    private List<Adventurer> mapAdventurers(List<fr.carbonit.th.configuration.Adventurer> adventurers) {
        List<Adventurer> result = new ArrayList<>();
        AdventurerMapper adventurerMapper = new AdventurerMapper();

        for (var adventurer : adventurers) {
            result.add(adventurerMapper.map(adventurer));
        }

        return result;
    }

    private List<Treasure> mapTreasures(List<fr.carbonit.th.configuration.Treasure> treasures) {
        List<Treasure> result = new ArrayList<>();

        for (var treasure : treasures) {
            Coordinates position = new Coordinates(treasure.getPosition().getX(), treasure.getPosition().getY());
            result.add(new Treasure(treasure.getChests(), position));
        }

        return result;
    }
}
