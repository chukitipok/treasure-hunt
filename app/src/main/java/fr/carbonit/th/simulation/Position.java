package fr.carbonit.th.simulation;

import java.util.Objects;

public class Position {

    private final Orientation orientation;
    private final Coordinates coordinates;

    public Position(Orientation orientation, Coordinates coordinates) {
        this.orientation = orientation;
        this.coordinates = coordinates;
    }

    public Position left() {
        return new Position(orientation.left(), coordinates);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return orientation == position.orientation && Objects.equals(coordinates, position.coordinates);
    }

    public int hashCode() {
        return Objects.hash(orientation, coordinates);
    }
}
