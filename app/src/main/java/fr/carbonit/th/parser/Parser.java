package fr.carbonit.th.parser;

import java.io.File;
import java.io.FileNotFoundException;

public class Parser {

    public Parser(File input) throws FileNotFoundException {
        if (!input.exists()) {
            throw new FileNotFoundException();
        }
    }
}
