package fr.carbonit.th.provider;

import java.io.File;

public class TestFileProvider {

    public File create(TestFileType type) {
        File file;
        switch (type) {
            case EMPTY:
                file = new File("src/test/resources/fixtures/parser/empty_input_test.txt");
                break;
            case WHITESPACE:
                file = new File("src/test/resources/fixtures/parser/whitespace_input_test.txt");
                break;
            case VALID:
                file = new File("src/test/resources/fixtures/parser/valid_input_test.txt");
                break;
            default:
                file = new File("src/test/resources/fixtures/parser/input.txt");
                break;
        }

        return file;
    }
}
