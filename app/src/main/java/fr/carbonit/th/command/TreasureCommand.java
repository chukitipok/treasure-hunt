package fr.carbonit.th.command;

import fr.carbonit.th.configuration.Treasure;

public class TreasureCommand extends Command {

    private final Coordinates position;
    private final Integer chests;

    public TreasureCommand(String input) {
        super(input);

        if (items.size() != 4 || !items.get(0).equals("T")) {
            throw new InvalidCommandException();
        }

        try {
            Integer x = Integer.valueOf(items.get(1));
            Integer y = Integer.valueOf(items.get(2));

            position = new Coordinates(x, y);
            chests = Integer.valueOf(items.get(3));
        }
        catch (NumberFormatException exception) {
            throw new InvalidCommandException();
        }
    }

    public Object handle() {
        return new Treasure(position, chests);
    }
}
