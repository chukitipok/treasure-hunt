package fr.carbonit.th.simulation;

import fr.carbonit.th.configuration.TreasureHuntConfiguration;
import fr.carbonit.th.parser.ConfigurationParser;
import fr.carbonit.th.parser.ParserFileProvider;
import fr.carbonit.th.parser.ParserFileType;
import fr.carbonit.th.reader.ConfigurationReader;

public class ConfigurationProvider {

    public ParserFileProvider fileProvider = new ParserFileProvider();

    public TreasureHuntConfiguration provide() {
        ConfigurationParser parser = new ConfigurationParser(new ConfigurationReader());
        return parser.parse(fileProvider.provide(ParserFileType.VALID));

    }
}
