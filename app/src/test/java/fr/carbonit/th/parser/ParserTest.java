package fr.carbonit.th.parser;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class ParserTest {

    private final File input;
    private Parser parser;

    public ParserTest() {
        input = new File("src/test/resources/fixtures/parser/valid_input_test.txt");
    }

    @BeforeEach
    public void init() {
        parser = new Parser(input);
    }

    @Test
    public void shouldAlertIfFileDoesNotExists() {
        var input = new File("src/test/resources/fixtures/parser/input.txt");
        ThrowingCallable parser = () -> new Parser(input);

        assertThatExceptionOfType(InvalidParserException.class).isThrownBy(parser);
    }

    @Test
    public void shouldAlertIfFileHasEmptyContent() {
        var input = new File("src/test/resources/fixtures/parser/empty_input_test.txt");
        ThrowingCallable parser = () -> new Parser(input);

        assertThatExceptionOfType(InvalidParserException.class).isThrownBy(parser);
    }

    @Test
    public void shouldAlertIfFileContentOnlyContainsWhiteSpaces() {
        var input = new File("src/test/resources/fixtures/parser/whitespace_input_test.txt");
        ThrowingCallable parser = () -> new Parser(input);

        assertThatExceptionOfType(InvalidParserException.class).isThrownBy(parser);
    }

    @Test
    public void shouldAlertIfDetectIOException() {
        var input = new File("src/test/resources/fixtures/parser/input.txt");
        ThrowingCallable parser = () -> new Parser(input);

        assertThatExceptionOfType(InvalidParserException.class).isThrownBy(parser);
    }

    @Test
    public void shouldCreateParserInstance() {
        var input = new File("src/test/resources/fixtures/parser/valid_input_test.txt");
        assertThatCode(() -> new Parser(input)).doesNotThrowAnyException();
    }
}
