package fr.carbonit.th;

import fr.carbonit.th.exceptions.NoParameterException;
import fr.carbonit.th.exceptions.TooManyParametersException;
import fr.carbonit.th.parser.UnparsableFileException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.ThrowableAssert.*;

public class ApplicationTest {

    @Test
    public void shouldAlertIfArgsAreEmpty() {
        ThrowingCallable callable = () -> Application.main(new String[0]);
        assertThatExceptionOfType(NoParameterException.class).isThrownBy(callable);
    }

    @Test
    public void shouldAlertIfArgsAreMoreThanOne() {
        ThrowingCallable callable = () -> Application.main(new String[2]);
        assertThatExceptionOfType(TooManyParametersException.class).isThrownBy(callable);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidFilePaths")
    public void shouldAlertIfFileIsNotValid(String[] args) {
        ThrowingCallable callable = () -> Application.main(args);
        assertThatExceptionOfType(UnparsableFileException.class).isThrownBy(callable);
    }

    private static Stream<Arguments> provideInvalidFilePaths() {
        return Stream.of(
                Arguments.of((Object) new String[]{""}),
                Arguments.of((Object) new String[]{"john/doe"}),
                Arguments.of((Object) new String[]{"john.doe"})
        );
    }
}
