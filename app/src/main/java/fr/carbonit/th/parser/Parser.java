package fr.carbonit.th.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public Parser(File input) throws IOException {
        if (!input.exists()) {
            throw new FileNotFoundException();
        }

        List<String> content = Files.readAllLines(input.toPath())
                .stream()
                .filter(line -> !line.isEmpty() && !line.isBlank())
                .collect(Collectors.toList());

        if (content.isEmpty()) {
            throw new FileIsEmptyException();
        }
    }
}
