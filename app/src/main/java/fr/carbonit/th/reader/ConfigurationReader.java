package fr.carbonit.th.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigurationReader implements Reader {

    public List<String> read(File file) {
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            List<String> content = Files.readAllLines(file.toPath())
                    .stream()
                    .filter(line -> !line.isEmpty() && !line.isBlank())
                    .collect(Collectors.toList());

            if (content.isEmpty()) {
                throw new FileIsEmptyException();
            }

            return content;
        }
        catch (IOException | FileIsEmptyException exception) { throw new UnreadableFileException(); }
    }
}
