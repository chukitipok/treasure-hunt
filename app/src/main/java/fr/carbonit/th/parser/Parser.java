package fr.carbonit.th.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Parser {

    public Parser(File input) throws IOException {
        if (!input.exists()) {
            throw new FileNotFoundException();
        }

        List<String> content = Files.readAllLines(input.toPath());

        if (content.isEmpty()) {
            throw new FileIsEmptyException();
        }
    }
}
