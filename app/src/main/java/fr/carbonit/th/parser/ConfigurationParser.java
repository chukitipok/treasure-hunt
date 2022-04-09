package fr.carbonit.th.parser;

import fr.carbonit.th.reader.Reader;

import java.io.File;
import java.util.List;

public class ConfigurationParser {

    private final Reader reader;

    public ConfigurationParser(Reader reader) {
        this.reader = reader;
    }

    public void parse(File file) {
        List<String> content = reader.read(file);
        for (var row : content) {
            var s = row.split("-");
            if (s.length < 3 || s.length > 6) {
                throw new UnparsableFileException();
            }

            if (!s[0].equals("C")) {
                throw new UnparsableFileException();
            }
        }
    }
}
