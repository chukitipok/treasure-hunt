package fr.carbonit.th.parser;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class ParserTest {

    @Test
    public void shouldAlertIfFileDoesNotExists() {
        var input = new File("src/test/resources/input.txt");
        ThrowingCallable parser = () -> new Parser(input);

        assertThatExceptionOfType(FileNotFoundException.class).isThrownBy(parser);
    }

    @Test
    public void shouldAlertIfFileHasEmptyContent() {
        var input = new File("src/test/resources/empty_input_test.txt");
        ThrowingCallable parser = () -> new Parser(input);

        assertThatExceptionOfType(FileIsEmptyException.class).isThrownBy(parser);
    }


}
