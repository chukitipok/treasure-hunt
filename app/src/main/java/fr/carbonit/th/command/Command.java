package fr.carbonit.th.command;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Command {

    protected List<String> items;

    protected Command(String input) {
        String[] s = input.split("-");
        List<String> items = List.of(s);
        this.items = items.stream().map(String::trim).collect(Collectors.toList());
    }

    public abstract Object handle();
}
