package se.kth.saeedvan.shapes_javafx.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape{
    private double diameter;

    public Circle(double x,double y, double diameter, Color color){
        super(x, y, color);
        this.diameter = diameter;
    }

    public Circle(){
        super();
        this.diameter = 100;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public void paint(GraphicsContext gc){
        gc.setStroke(getColor());
        gc.strokeOval(getX(), getY(), this.diameter, this.diameter);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", diameter=" + diameter;
    }
}
