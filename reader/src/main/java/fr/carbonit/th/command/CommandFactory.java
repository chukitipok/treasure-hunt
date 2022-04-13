package fr.carbonit.th.command;

public class CommandFactory {

    public Command create(String input) {
        char first = input.trim().toUpperCase().charAt(0);
        Command command;

        switch (first) {
            case 'A':
                command = new AdventurerCommand(input);
                break;
            case 'C':
                command = new MapCommand(input);
                break;
            case 'M':
                command = new MountainCommand(input);
                break;
            case 'T':
            default:
                command = new TreasureCommand(input);
                break;
        }

        return command;
    }
}
