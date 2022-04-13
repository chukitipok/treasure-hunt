package fr.carbonit.th;

import org.junit.jupiter.api.Test;

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
}
