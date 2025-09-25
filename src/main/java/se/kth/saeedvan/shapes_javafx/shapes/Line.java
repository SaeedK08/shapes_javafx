package se.kth.saeedvan.shapes_javafx.shapes;

import se.kth.saeedvan.shapes_javafx.App;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Line extends Shape {
        private double x2, y2;

        public Line(double x, double y, double x2, double y2, Color color){
            super(x, y, color);
            this.x2 = x2;
            this.y2 = y2;
        }
        public Line(){
            super();
            this.x2 = 100;
            this.y2 = 100;
        }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    @Override
    public void constrain(double boxX, double boxY,
                          double boxWidth, double boxHeight){
            super.constrain(boxX, boxY, boxWidth,boxHeight);

        if (this.x2 < boxX) {
            setVelocity(Math.abs(getDx()), getDy());
        } else if (this.x2 > boxWidth) {
            setVelocity(-Math.abs(getDx()), getDy());
        }
        if (this.y2 < boxY) {
            setVelocity(getDx(), Math.abs(getDy()));
        } else if (this.y2 > boxHeight) {
            setVelocity(getDx(), -Math.abs(getDy()));
        }
    }
    @Override
    public void move(long elapsedTime){
        super.move(elapsedTime);
        x2 += getDx() * elapsedTime / BILLION;
        y2 += getDy() * elapsedTime / BILLION;
    }

    @Override
    public void paint(GraphicsContext gc){
        gc.setStroke(getColor());
        gc.strokeLine(getX(), getY(), x2, y2);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", x2=" + x2 +
                ", y2=" + y2;
    }
}
