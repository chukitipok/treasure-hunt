package fr.carbonit.th;

public class NoParameterException extends RuntimeException {

    public NoParameterException() {
        super("No parameter given in arguments.");
    }
}
