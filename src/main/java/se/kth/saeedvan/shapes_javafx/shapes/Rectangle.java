package se.kth.saeedvan.shapes_javafx.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FillableShape{
    private double width, height;

    public Rectangle(double x, double y, double height, double width, Color color){
        super(x, y, color);
        this.height = height;
        this.width = width;
    }
    public Rectangle(){
        super();
        this.height = 100;
        this.width = 150;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void constrain(double boxX, double boxY,
                          double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);

        if (getX() + this.width < boxX) {
            setVelocity(Math.abs(getDx()), getDy());
        } else if (getX() + this.width > boxWidth) {
            setVelocity(-Math.abs(getDx()), getDy());
        }
        if (getY() + this.height < boxY) {
            setVelocity(getDx(), Math.abs(getDy()));
        } else if (getY() + this.height > boxHeight) {
            setVelocity(getDx(), -Math.abs(getDy()));
        }
    }

    @Override
    public void paint(GraphicsContext gc) {
        if (isFilled()) {
            gc.setFill(getColor());
            gc.fillRect(getX(), getY(), this.height, this.width);
        }
        else {
            gc.setStroke(getColor());
            gc.strokeRect(getX(), getY(), this.height, this.width);
        }

    }

    @Override
    public String toString() {
        return super.toString() +
                ", width=" + width +
                ", height=" + height;
    }
}
