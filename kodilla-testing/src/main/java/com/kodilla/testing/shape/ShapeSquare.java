package com.kodilla.testing.shape;

import java.util.Objects;

public class ShapeSquare implements Shape {
    private int a;

    public ShapeSquare(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeSquare that = (ShapeSquare) o;
        return a == that.a;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(a);
    }

    @Override
    public String getShapeName() {
        return "";
    }

    @Override
    public Double getField() {
        return 0.0;
    }
}
