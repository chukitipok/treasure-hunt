package fr.carbonit.th.parser;

import fr.carbonit.th.provider.FileProvider;

import java.io.File;

public class ParserFileProvider implements FileProvider<ParserFileType> {

    public File provide(ParserFileType fileType) {
        File file;
        switch (fileType) {
            case ROW_WITH_LESS_THAN_3_ITEMS:
                file = new File("src/test/resources/fixtures/parser/row_has_less_than_3_items.txt");
                break;
            case ROW_WITH_MORE_THAN_6_ITEMS:
                file = new File("src/test/resources/fixtures/parser/row_has_more_than_6_items.txt");
                break;
            case ROW_NOT_START_BY_LETTER_X:
                file = new File("src/test/resources/fixtures/parser/row_does_not_start_by_letter_X.txt");
                break;
            case VALID:
                file = new File("src/test/resources/fixtures/parser/valid_input_test.txt");
                break;
            case COLLECT_TREASURE:
                file = new File("src/test/resources/fixtures/parser/collect_treasure_test.txt");
                break;
            default:
                file = new File("src/test/resources/fixtures/parser/input.txt");
                break;
        }

        return file;
    }
}
