package se.kth.saeedvan.shapes_javafx.shapes;


import javafx.scene.paint.Color;

public abstract class FillableShape extends Shape {
    private boolean filled;
    protected FillableShape(double x, double y, Color color, boolean fill) {
        super(x, y, color);
        this.filled = fill;
    }
    protected FillableShape() {
        super();
        this.filled = false;
    }
    public boolean isFilled() {
        return this.filled;
    }
    public void setFilled(boolean fill) {

        this.filled = fill;
    }
}
