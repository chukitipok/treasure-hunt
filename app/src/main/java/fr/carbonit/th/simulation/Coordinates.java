package fr.carbonit.th.simulation;

import java.util.Objects;

public class Coordinates {
    private final Integer x;
    private final Integer y;

    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates add(final int x, final int y) {
        return new Coordinates(this.x + x, this.y + y);
    }

    public Integer getY() {
        return y;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates coordinates = (Coordinates) o;
        return Objects.equals(x, coordinates.x) && Objects.equals(y, coordinates.y);
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
