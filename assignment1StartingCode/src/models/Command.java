package models;

import java.util.List;

import shapes.Shape;
import utilities.SortAlgorithm;


public class Command {
    private final List<Shape> shapes;
    private final SortField sortField;
    private final SortAlgorithm sortAlgorithm;

    public Command(List<Shape> shapes, SortField sortField, SortAlgorithm sortAlgorithm) {
        this.shapes = shapes;
        this.sortField = sortField;
        this.sortAlgorithm = sortAlgorithm;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public SortField getSortField() {
        return sortField;
    }

    public SortAlgorithm getSortAlgorithm() {
        return sortAlgorithm;
    }
}
