package fr.carbonit.th.simulation;

import java.util.Objects;

public class Coordinates {
    private final Integer offsetX;
    private final Integer offsetY;

    public Coordinates(Integer x, Integer y) {
        offsetX = x;
        offsetY = y;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates position = (Coordinates) o;
        return Objects.equals(offsetX, position.offsetX) && Objects.equals(offsetY, position.offsetY);
    }

    public int hashCode() {
        return Objects.hash(offsetX, offsetY);
    }
}
