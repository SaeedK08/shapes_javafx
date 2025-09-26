package se.kth.saeedvan.shapes_javafx.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape {
    private double diameter;

    public Circle(double x,double y, double diameter, Color color, boolean fill){
        super(x, y, color, fill);
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
        if (isFilled()) {
            gc.setFill(getColor());
            gc.fillOval(getX(), getY(), this.diameter, this.diameter);
        }
        else {
            gc.setStroke(getColor());
            gc.strokeOval(getX(), getY(), this.diameter, this.diameter);
        }
    }

    @Override
    public void constrain(double boxX, double boxY,
                          double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);
        if (getX() + this.diameter < boxX) {
            setVelocity(Math.abs(getDx()), getDy());
        } else if (getX() + this.diameter > boxWidth) {
            setVelocity(-Math.abs(getDx()), getDy());
        }
        if (getY() + this.diameter < boxY) {
            setVelocity(getDx(), Math.abs(getDy()));
        } else if (getY() + this.diameter > boxHeight) {
            setVelocity(getDx(), -Math.abs(getDy()));
        }
    }
    @Override
    public String toString() {
        return super.toString() +
                ", diameter=" + diameter;
    }
}
