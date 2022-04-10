package fr.carbonit.th.command;

import fr.carbonit.th.configuration.Mountain;
import fr.carbonit.th.configuration.exceptions.InvalidMountainException;

public class MountainCommand extends Command {

    private final Coordinates position;

    public MountainCommand(String input) {
        super(input);

        if (!items.get(0).equals("M") || items.size() != 3) {
            throw new InvalidCommandException();
        }

        try {
            Integer x = Integer.valueOf(items.get(1));
            Integer y = Integer.valueOf(items.get(2));

            position = new Coordinates(x, y);
        }
        catch (NumberFormatException exception) {
            throw new InvalidCommandException();
        }
    }

    public Object handle() {
        try {
            return new Mountain(position);
        }
        catch (InvalidMountainException exception) {
            throw new InvalidCommandException();
        }
    }
}
