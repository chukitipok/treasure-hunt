package fr.carbonit.th.configuration;

import fr.carbonit.th.configuration.exceptions.InvalidMapException;

public class HuntMap {

    private final Integer rows;
    private final Integer columns;

    public HuntMap(Integer rows, Integer columns) {
        if (rows < 1 || columns < 1) {
            throw new InvalidMapException();
        }

        this.rows = rows;
        this.columns = columns;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }
}
