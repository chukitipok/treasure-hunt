package fr.carbonit.th;

public class TooManyParametersException extends RuntimeException {

    public TooManyParametersException() {
        super("Only one argument expected.");
    }
}
