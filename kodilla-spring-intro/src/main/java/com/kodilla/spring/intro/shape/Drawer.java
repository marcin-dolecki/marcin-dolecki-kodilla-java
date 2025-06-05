package com.kodilla.spring.intro.shape;

public class Drawer {
    public void doDrawing() {
        Circle circle = new Circle();
        Triangle triangle = new Triangle();

        circle.draw();
        triangle.draw();
    }
}
