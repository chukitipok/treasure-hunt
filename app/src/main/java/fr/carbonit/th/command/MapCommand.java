package fr.carbonit.th.command;

public class MapCommand extends Command {

    private final Integer rows;
    private final Integer columns;

    public MapCommand(String input) {
        super(input);

        if (!items.get(0).equals("C") || items.size() != 3) {
            throw new InvalidCommandException();
        }

        try {
            rows = Integer.valueOf(items.get(1));
            columns = Integer.valueOf(items.get(2));
        }
        catch (NumberFormatException exception) {
            throw new InvalidCommandException();
        }
    }
}
