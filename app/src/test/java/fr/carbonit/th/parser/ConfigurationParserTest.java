package fr.carbonit.th.parser;

import fr.carbonit.th.reader.ConfigurationReader;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ConfigurationParserTest {

    private final ParserFileProvider fileProvider;
    private final ConfigurationParser parser;

    public ConfigurationParserTest() {
        fileProvider = new ParserFileProvider();
        parser = new ConfigurationParser(new ConfigurationReader());
    }

    @Test
    public void shouldAlertIfRowContainsLessThan3ElementSeparatedByDashes() {
        var input = fileProvider.provide(ParserFileType.ROW_WITH_LESS_THAN_3_ITEMS);
        ThrowableAssert.ThrowingCallable callable = () -> parser.parse(input);

        assertThatExceptionOfType(UnparsableFileException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfRowContainsMoreThan6ElementSeparatedByDashes() {
        var input = fileProvider.provide(ParserFileType.ROW_WITH_MORE_THAN_6_ITEMS);
        ThrowableAssert.ThrowingCallable callable = () -> parser.parse(input);

        assertThatExceptionOfType(UnparsableFileException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfRowFirstItemIsNotEqualToLetterC() {
        var input = fileProvider.provide(ParserFileType.ROW_NOT_START_BY_LETTER_X);
        ThrowableAssert.ThrowingCallable callable = () -> parser.parse(input);

        assertThatExceptionOfType(UnparsableFileException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfRowFirstItemIsNotEqualToLetterM() {
        var input = fileProvider.provide(ParserFileType.ROW_NOT_START_BY_LETTER_X);
        ThrowableAssert.ThrowingCallable callable = () -> parser.parse(input);

        assertThatExceptionOfType(UnparsableFileException.class).isThrownBy(callable);
    }
}
