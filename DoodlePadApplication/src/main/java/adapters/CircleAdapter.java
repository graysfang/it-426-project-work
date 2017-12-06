package adapters;

/*
 * Nicholas Perez
 * 12/4/2017
 * CircleAdapter.java
 *
 * Adapter for Circle Class
 */

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Circle;

/**
 * Adapter for Circle Class
 *
 * @author Nicholas Perez
 * @version 1.0
 */
public class CircleAdapter implements IShape
{
    private Circle circle;

    /**
     * Instantiates a new Circle adapter.
     *
     * @param circle the circle
     */
    public CircleAdapter(Circle circle)
    {
        this.circle = circle;
    }

    @Override
    public IShape setThickness(double value)
    {
        circle = new Circle(circle.getRadius(), circle.getX(),circle.getY(), value, circle.getColor(), circle.isFill());

        return this;
    }

    @Override
    public IShape setColor(Color value)
    {
        circle = new Circle(circle.getRadius(), circle.getX(),circle.getY(), circle.getThickness(), value, circle.isFill());

        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        circle = new Circle(circle.getRadius(), circle.getX(),circle.getY(), circle.getThickness(), circle.getColor(), value);

        return this;
    }

    @Override
    public double getX()
    {
        return circle.getX();
    }

    @Override
    public double getY()
    {
        return circle.getY();
    }

    @Override
    public double getThickness()
    {
        return circle.getThickness();
    }

    @Override
    public Color getColor()
    {
        return circle.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return circle.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        if(this.getFilled())
        {
            graphics.setFill(this.getColor());
            graphics.fillOval(this.getX(), this.getY(), circle.getRadius(),circle.getRadius());

        }
        else{
            graphics.setStroke(circle.getColor());
            graphics.setLineWidth(this.getThickness());
            graphics.strokeOval(this.getX(), this.getY(), circle.getRadius(),circle.getRadius());

        }
    }
}
