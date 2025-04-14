package com.kodilla.testing.shape;

import java.util.Objects;

public class ShapeCircle implements Shape {
    private int r;

    public ShapeCircle(int r) {
        this.r = r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeCircle that = (ShapeCircle) o;
        return r == that.r;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(r);
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public Double getField() {
        return 0.0;
    }
}
