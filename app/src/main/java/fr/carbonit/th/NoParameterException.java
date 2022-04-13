package fr.carbonit.th;

public class NoParameterException extends RuntimeException {

    private NoParameterException() {
        super("No parameter given in arguments.");
    }
}
