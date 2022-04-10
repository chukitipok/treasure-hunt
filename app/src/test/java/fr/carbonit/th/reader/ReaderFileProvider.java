package fr.carbonit.th.reader;

import fr.carbonit.th.provider.FileProvider;

import java.io.File;

public class ReaderFileProvider implements FileProvider<ReaderFileType> {

    public File provide(ReaderFileType type) {
        File file;
        switch (type) {
            case EMPTY:
                file = new File("src/test/resources/fixtures/reader/empty_input_test.txt");
                break;
            case WHITESPACE:
                file = new File("src/test/resources/fixtures/reader/whitespace_input_test.txt");
                break;
            case VALID:
                file = new File("src/test/resources/fixtures/reader/valid_input_test.txt");
                break;
            case DIRECTORY:
                file = new File("src/test/resources/fixtures/reader/");
                break;
            default:
                file = new File("src/test/resources/fixtures/reader/input.txt");
                break;
        }

        return file;
    }
}
