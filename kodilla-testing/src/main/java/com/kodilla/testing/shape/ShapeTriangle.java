package com.kodilla.testing.shape;

import java.util.Objects;

public class ShapeTriangle implements Shape {
    private int a, h;

    public ShapeTriangle(int a, int h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeTriangle that = (ShapeTriangle) o;
        return a == that.a && h == that.h;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, h);
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public Double getField() {
        return 0.0;
    }
}
