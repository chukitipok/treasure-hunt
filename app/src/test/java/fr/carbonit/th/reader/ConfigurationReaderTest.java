package fr.carbonit.th.reader;

import fr.carbonit.th.provider.TestFileProvider;
import fr.carbonit.th.provider.TestFileType;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ConfigurationReaderTest {

    private final ConfigurationReader reader;
    private final TestFileProvider testFileProvider;

    public ConfigurationReaderTest() {
        reader = new ConfigurationReader();
        testFileProvider = new TestFileProvider();
    }

    @Test
    public void shouldAlertIfFileDoesNotExists() {
        File input = testFileProvider.create(TestFileType.NON_EXISTENT);
        ThrowableAssert.ThrowingCallable callable = () -> reader.read(input);

        assertThatExceptionOfType(UnreadableFileException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFileHasEmptyContent() {
        File input = testFileProvider.create(TestFileType.EMPTY);
        ThrowableAssert.ThrowingCallable callable = () -> reader.read(input);

        assertThatExceptionOfType(UnreadableFileException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfFileContentOnlyContainsWhiteSpaces() {
        var input = testFileProvider.create(TestFileType.WHITESPACE);
        ThrowableAssert.ThrowingCallable callable = () -> reader.read(input);

        assertThatExceptionOfType(UnreadableFileException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfDetectIOException() {
        var input = testFileProvider.create(TestFileType.NON_EXISTENT);
        ThrowableAssert.ThrowingCallable callable = () -> reader.read(input);

        assertThatExceptionOfType(UnreadableFileException.class).isThrownBy(callable);
    }

    @Test
    public void shouldReturnNonEmptyListOfStrings() {
        List<String> content = reader.read(testFileProvider.create(TestFileType.VALID));
        assertFalse(content.isEmpty());
    }
}
