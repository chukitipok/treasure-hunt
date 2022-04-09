package fr.carbonit.th.reader;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ConfigurationReaderTest {

    private final ConfigurationReader reader;
    private final ReaderFileProvider testFileProvider;

    public ConfigurationReaderTest() {
        reader = new ConfigurationReader();
        testFileProvider = new ReaderFileProvider();
    }

    @Test
    public void shouldAlertIfFileDoesNotExists() {
        File input = testFileProvider.provide(ReaderFileType.NON_EXISTENT);
        ThrowableAssert.ThrowingCallable callable = () -> reader.read(input);

        assertThatExceptionOfType(UnreadableFileException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFileHasEmptyContent() {
        File input = testFileProvider.provide(ReaderFileType.EMPTY);
        ThrowableAssert.ThrowingCallable callable = () -> reader.read(input);

        assertThatExceptionOfType(UnreadableFileException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFileContentOnlyContainsWhiteSpaces() {
        var input = testFileProvider.provide(ReaderFileType.WHITESPACE);
        ThrowableAssert.ThrowingCallable callable = () -> reader.read(input);

        assertThatExceptionOfType(UnreadableFileException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfDetectIOException() {
        var input = testFileProvider.provide(ReaderFileType.NON_EXISTENT);
        ThrowableAssert.ThrowingCallable callable = () -> reader.read(input);

        assertThatExceptionOfType(UnreadableFileException.class).isThrownBy(callable);
    }

    @Test
    public void shouldReturnNonEmptyListOfStrings() {
        List<String> content = reader.read(testFileProvider.provide(ReaderFileType.VALID));
        assertFalse(content.isEmpty());
    }

    @Test
    public void shouldAlertIfFileIsDirectory() {
        var input = testFileProvider.provide(ReaderFileType.DIRECTORY);
        ThrowableAssert.ThrowingCallable callable = () -> reader.read(input);

        assertThatExceptionOfType(UnreadableFileException.class).isThrownBy(callable);
    }
}
