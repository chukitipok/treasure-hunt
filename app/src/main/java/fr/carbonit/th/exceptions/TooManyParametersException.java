package fr.carbonit.th.exceptions;

public class TooManyParametersException extends RuntimeException {

    public TooManyParametersException() {
        super("Only one argument expected.");
    }
}
