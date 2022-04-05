package fr.carbonit.th.parser;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class ParserTest {

    @Test
    public void shouldAlertIfFileDoesNotExists() {
        var input = new File("src/test/resources/fixtures/parser/input.txt");
        ThrowingCallable parser = () -> new Parser(input);

        assertThatExceptionOfType(FileNotFoundException.class).isThrownBy(parser);
    }

    @Test
    public void shouldAlertIfFileHasEmptyContent() {
        var input = new File("src/test/resources/fixtures/parser/empty_input_test.txt");
        ThrowingCallable parser = () -> new Parser(input);

        assertThatExceptionOfType(FileIsEmptyException.class).isThrownBy(parser);
    }

    @Test
    public void shouldAlertIfFileContentOnlyContainsWhiteSpaces() {
        var input = new File("src/test/resources/fixtures/parser/whitespace_input_test.txt");
        ThrowingCallable parser = () -> new Parser(input);

        assertThatExceptionOfType(FileIsEmptyException.class).isThrownBy(parser);
    }

    @Test
    public void shouldCreateParserInstance() {
        var input = new File("src/test/resources/fixtures/parser/valid_input_test.txt");
        assertThatCode(() -> new Parser(input)).doesNotThrowAnyException();
    }
}
