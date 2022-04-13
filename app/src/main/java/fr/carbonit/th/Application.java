package fr.carbonit.th;

public class Application {
    public static void main(String[] args) {
        if (args.length == 0) throw new NoParameterException();
        if (args.length > 1) throw new TooManyParametersException();
    }
}
