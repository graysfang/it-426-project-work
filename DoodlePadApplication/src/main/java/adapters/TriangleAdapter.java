package adapters;

/*
 * Nicholas Perez
 * 12/4/2017
 * TriangleAdapter.java
 *
 * Adapter for Triangle Class
 */

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Triangle;

/**
 * Adapter for Triangle Class
 *
 * @author Nicholas Perez
 * @version 1.0
 */
public class TriangleAdapter implements IShape
{
    private Triangle triangle;

    /**
     * Instantiates a new Triangle adapter.
     *
     * @param triangle the triangle
     */
    public TriangleAdapter(Triangle triangle)
    {
        this.triangle = triangle;
    }

    @Override
    public IShape setThickness(double value)
    {
        triangle = new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(), triangle.getHeight(), value, triangle.getColor(), triangle.isFill());
        return this;
    }

    @Override
    public IShape setColor(Color value)
    {
        triangle = new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(), triangle.getHeight(), triangle.getThickness(), value, triangle.isFill());
        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        triangle = new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(), triangle.getHeight(), triangle.getThickness(), triangle.getColor(), value);
        return this;
    }

    @Override
    public double getX()
    {
        return triangle.getX();
    }

    @Override
    public double getY()
    {
        return triangle.getY();
    }

    @Override
    public double getThickness()
    {
        return triangle.getThickness();
    }

    @Override
    public Color getColor()
    {
        return triangle.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return triangle.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {

        if(this.getFilled())
        {
            graphics.setFill(this.getColor());
            graphics.fillPolygon(new double[]{
                    this.getX(),
                    this.getX()+triangle.getWidth(),
                    this.getX()+(triangle.getWidth()/2)

            },new double[]{
                    this.getY(),
                    this.getY(),
                    this.getY()-(triangle.getHeight())

            }, 3);
        }

        graphics.setStroke(this.getColor());
        graphics.setLineWidth(this.getThickness());

        graphics.strokePolygon(new double[]{
                this.getX(),
                this.getX()+triangle.getWidth(),
                this.getX()+(triangle.getWidth()/2)

        },new double[]{
                this.getY(),
                this.getY(),
                this.getY()-(triangle.getHeight())

        }, 3);

    }
}
