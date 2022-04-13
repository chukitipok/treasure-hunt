package fr.carbonit.th.provider;

import fr.carbonit.th.configuration.TreasureHuntConfiguration;
import fr.carbonit.th.parser.ConfigurationParser;
import fr.carbonit.th.provider.parser.ParserFileProvider;
import fr.carbonit.th.provider.parser.ParserFileType;
import fr.carbonit.th.reader.ConfigurationReader;

public class ConfigurationProvider {

    public ParserFileProvider fileProvider = new ParserFileProvider();

    public TreasureHuntConfiguration provide() {
        ConfigurationParser parser = new ConfigurationParser(new ConfigurationReader());
        return parser.parse(fileProvider.provide(ParserFileType.VALID));
    }

    public TreasureHuntConfiguration provideCollectTreasure() {
        ConfigurationParser parser = new ConfigurationParser(new ConfigurationReader());
        return parser.parse(fileProvider.provide(ParserFileType.COLLECT_TREASURE));
    }

    public TreasureHuntConfiguration provideBlockedByMountain() {
        ConfigurationParser parser = new ConfigurationParser(new ConfigurationReader());
        return parser.parse(fileProvider.provide(ParserFileType.MOUNTAIN_BLOCK));
    }

    public TreasureHuntConfiguration provideBlockedByAdventurer() {
        ConfigurationParser parser = new ConfigurationParser(new ConfigurationReader());
        return parser.parse(fileProvider.provide(ParserFileType.ADVENTURER_BLOCK));
    }

    public TreasureHuntConfiguration provideFullSimulation() {
        ConfigurationParser parser = new ConfigurationParser(new ConfigurationReader());
        return parser.parse(fileProvider.provide(ParserFileType.FULL_SIMULATION_ONE_PLAYER));
    }
}
