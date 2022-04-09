package fr.carbonit.th.parser;

public class Command {
    public Command(String input) {
        var s = input.split("-");
        if (s.length < 3 || s.length > 6) {
            throw new UnparsableFileException();
        }

        if (!s[0].equals("C") || !s[0].equals("M")) {
            throw new UnparsableFileException();
        }
    }
}
