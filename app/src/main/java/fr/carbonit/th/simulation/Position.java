package fr.carbonit.th.simulation;

import java.util.Objects;

public class Position {
    private final Integer offsetX;
    private final Integer offsetY;

    public Position(Integer x, Integer y) {
        offsetX = x;
        offsetY = y;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(offsetX, position.offsetX) && Objects.equals(offsetY, position.offsetY);
    }

    public int hashCode() {
        return Objects.hash(offsetX, offsetY);
    }
}
