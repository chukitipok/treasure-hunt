package fr.carbonit.th.simulation;

public class Position {

    private final Orientation orientation;
    private final Coordinates coordinates;

    public Position(Orientation orientation, Coordinates coordinates) {
        this.orientation = orientation;
        this.coordinates = coordinates;
    }

    public Position left() {
        return null;
    }
}
