package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();
    private String allShapesJoined = "";

    public ShapeCollector() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeCollector that = (ShapeCollector) o;
        return Objects.equals(shapes, that.shapes) && Objects.equals(allShapesJoined, that.allShapesJoined);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shapes, allShapesJoined);
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public int getShapesQuantity() {
        return shapes.size();
    }

    public boolean removeFigure(Shape shape) {
        if (shapes.contains(shape)) {
            shapes.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int figureNumber) {
        if (figureNumber >= 0 && figureNumber < shapes.size()) {
            return shapes.get(figureNumber);
        }
        return null;
    }

    public String showFigures() {
        StringBuilder joined = new StringBuilder();

        for (int i = 0; i < shapes.size(); i++) {
            if (i > 0) {
                joined.append(", ");
            }
            joined.append(shapes.get(i).getShapeName());
        }
        return joined.toString();
    }
}
