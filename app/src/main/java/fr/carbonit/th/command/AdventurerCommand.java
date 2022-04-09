package fr.carbonit.th.command;

public class AdventurerCommand extends Command {

    private final String name;
    private final Coordinates position;
    private final String orientation;
    private final String actions;

    public AdventurerCommand(String input) {
        super(input);
        checkStringItems();

        try {
            Integer x = Integer.valueOf(items.get(2));
            Integer y = Integer.valueOf(items.get(3));

            name = items.get(1);
            position = new Coordinates(x, y);
            orientation = items.get(4);
            actions =  items.get(5);
        }
        catch (NumberFormatException exception) {
            throw new InvalidCommandException();
        }
    }

    private void checkStringItems() {
        if (items.size() != 6 || !items.get(0).equals("A")) {
            throw new InvalidCommandException();
        }

        if (!items.get(1).matches("[a-zA-Z]+")) {
            throw new InvalidCommandException();
        }

        if (!items.get(4).matches("[NESO]") && items.get(4).length() != 1) {
            throw new InvalidCommandException();
        }

        if (!items.get(5).matches("[ADG]+")) {
            throw new InvalidCommandException();
        }
    }
}
