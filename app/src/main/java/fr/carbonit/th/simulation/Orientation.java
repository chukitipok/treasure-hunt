package fr.carbonit.th.simulation;

public enum Orientation {

    NORTH(0, -1),
    EAST(1, 0),
    SOUTH(0, 1),
    WEST(-1, 0);

    private final int offsetX;
    private final int offsetY;

    Orientation(final int offsetX, final int offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public Orientation left() {
        if (this == NORTH)
            return WEST;
        return Orientation.values()[this.ordinal() - 1];
    }

    public Orientation right() {
        if (this == WEST)
            return NORTH;
        return Orientation.values()[this.ordinal() + 1];
    }

    public Coordinates forward(Coordinates coordinates) {
        return coordinates.add(offsetX, offsetY);
    }
}
