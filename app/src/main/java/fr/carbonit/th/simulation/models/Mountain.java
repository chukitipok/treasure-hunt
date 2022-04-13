package fr.carbonit.th.simulation.models;

import fr.carbonit.th.simulation.localisation.Coordinates;

import java.util.Objects;
import java.util.UUID;

public class Mountain {

    private final UUID uuid;
    private final Coordinates position;

    public Mountain(UUID uuid, Coordinates position) {
        this.uuid = uuid;
        this.position = position;
    }

    public UUID getId() {
        return uuid;
    }

    public Coordinates getPosition() {
        return position;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mountain mountain = (Mountain) o;
        return Objects.equals(uuid, mountain.uuid) && Objects.equals(position, mountain.position);
    }

    public int hashCode() {
        return Objects.hash(uuid, position);
    }

    public String toString() {
        return "Mountain{" +
                "uuid=" + uuid +
                ", position=" + position +
                '}';
    }
}
