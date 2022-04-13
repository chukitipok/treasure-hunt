package fr.carbonit.th.simulation.mappers;

import fr.carbonit.th.simulation.actions.Action;
import fr.carbonit.th.simulation.actions.MoveForwardAction;
import fr.carbonit.th.simulation.actions.TurnLeftAction;
import fr.carbonit.th.simulation.actions.TurnRightAction;
import fr.carbonit.th.simulation.models.Adventurer;
import fr.carbonit.th.simulation.localisation.Coordinates;
import fr.carbonit.th.simulation.localisation.Orientation;
import fr.carbonit.th.simulation.localisation.Position;

import java.util.LinkedList;
import java.util.Queue;

public class AdventurerMapper {
    public Adventurer map(fr.carbonit.th.configuration.Adventurer adventurer) {
        Position position = mapPosition(adventurer.getOrientation(), adventurer.getPosition());
        Queue<Action> actions = mapActions(adventurer.getActions());

        return new Adventurer(adventurer.getName(), position, actions);
    }

    private Position mapPosition(String orientation, fr.carbonit.th.command.Coordinates position) {
        return new Position(
                mapOrientation(orientation),
                new Coordinates(position.getX(), position.getY())
        );
    }

    private Orientation mapOrientation(String orientation) {
        Orientation mappedOrientation;

        switch (orientation) {
            case "S":
                mappedOrientation = Orientation.SOUTH;
                break;
            case "N":
                mappedOrientation = Orientation.NORTH;
                break;
            case "W":
                mappedOrientation = Orientation.WEST;
                break;
            case "E":
            default:
                mappedOrientation = Orientation.EAST;
                break;
        }

        return mappedOrientation;
    }

    private Queue<Action> mapActions(String actions) {
        String[] s = actions.split("(?<=.)");
        Queue<Action> result = new LinkedList<>();

        for (var a : s) {
            switch (a) {
                case "A":
                    result.add(new MoveForwardAction());
                    break;
                case "D":
                    result.add(new TurnRightAction());
                    break;
                case "G":
                default:
                    result.add(new TurnLeftAction());
                    break;
            }
        }

        return result;
    }
}
