package fr.carbonit.th.exceptions;

public class NoParameterException extends RuntimeException {

    public NoParameterException() {
        super("No parameter given in arguments.");
    }
}
