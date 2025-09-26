package se.kth.saeedvan.shapes_javafx.shapes;

import javafx.scene.paint.Color;
import java.util.ArrayList;

/**
 * A representation of a world containing a set of moving shapes. NB! The worlds
 * y-axis points downward.
 *
 * @author Anders Lindström, anderslm@kth.se 2021-09-15
 */
public class World {

    private double width, height; // this worlds width and height

    private final ArrayList<Shape> shapes; // an array of references to the shapes

    /**
     * Creates a new world, containing a pad and a set of balls. NB! The worlds
     * y-axis points downward.
     *
     * @param width the width of this world
     * @param height the height of this world
     */
    public World(double width, double height) {
        this.width = width;
        this.height = height;

        shapes = new ArrayList<>();
        shapes.add(new Line(0,0,100,100,Color.RED));
        shapes.add(new Rectangle(0,0,100,100,Color.GREEN));
        shapes.add(new Circle(100,100,80,Color.CYAN));
        shapes.get(0).setVelocity(300,400);
        shapes.get(1).setVelocity(200,300);
        shapes.get(2).setVelocity(250,150);

        for (Shape sh : shapes) {
            if (sh instanceof FillableShape) {
                ((FillableShape) sh).setFilled(true);
            }
        }
        //Rectangle rect = (Rectangle) shapes[1];
        //rect.setFilled();



        // Create the actual Shape objects (sub types)
        // ....
    }

    /**
     * Sets the new dimensions, in pixels, for this world. The method could be
     * used for example when the canvas is reshaped.
     *
     * @param newWidth
     * @param newHeight
     */
    public void setDimensions(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    /**
     * Move the world one step, based on the time elapsed since last move.
     *
     * @param elapsedTimeNs the elapsed time in nanoseconds
     */
    public void moveAndConstrain(long elapsedTimeNs) {
        // alterantive loop: for(Shape s : shapes) { ...
        for (Shape s : shapes) {
            s.moveAndConstrain(elapsedTimeNs, 0, 0, width, height);
        }
    }

    /**
     * Returns a copy of the list of ball references.
     * Due to the implementation of clone, a shallow copy is returned.
     *
     * @return a copy of the list of balls
     */
    public ArrayList<Shape> getShapes() {
        return (ArrayList<Shape>) shapes.clone();
    }
}
