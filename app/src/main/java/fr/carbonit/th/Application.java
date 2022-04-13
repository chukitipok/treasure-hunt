package fr.carbonit.th;


import fr.carbonit.th.configuration.TreasureHuntConfiguration;
import fr.carbonit.th.exceptions.NoParameterException;
import fr.carbonit.th.exceptions.TooManyParametersException;
import fr.carbonit.th.parser.ConfigurationParser;
import fr.carbonit.th.reader.ConfigurationReader;

import java.io.File;

public class Application {
    public static void main(String[] args) {
        if (args.length == 0) throw new NoParameterException();
        if (args.length > 1) throw new TooManyParametersException();

        ConfigurationParser parser = new ConfigurationParser(new ConfigurationReader());
        TreasureHuntConfiguration configuration = parser.parse(new File(args[0]));
    }
}
