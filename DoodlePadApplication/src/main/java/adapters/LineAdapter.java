package adapters;

/*
 * Nicholas Perez
 * 12/4/2017
 * LineAdapter.java
 *
 * Adapter for Line Class
 */

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Line;

/**
 * Adapter for Line Class
 *
 * @author Nicholas Perez
 * @version 1.0
 */
public class LineAdapter implements IShape
{
    private Line line;

    /**
     * Instantiates a new Line adapter.
     *
     * @param line the line
     */
    public LineAdapter(Line line)
    {
        this.line = line;
    }

    @Override
    public IShape setThickness(double value)
    {
        line = new Line(line.getX(), line.getY(), line.getX2(), line.getY2(), value, line.getColor(), line.isFill());
        return this;
    }

    @Override
    public IShape setColor(Color value)
    {
        line = new Line(line.getX(), line.getY(), line.getX2(), line.getY2(), line.getThickness(), value, line.isFill());
        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        line = new Line(line.getX(), line.getY(), line.getX2(), line.getY2(), line.getThickness(), line.getColor(), value);
        return this;
    }

    @Override
    public double getX()
    {
        return line.getX();
    }

    @Override
    public double getY()
    {
        return line.getY();
    }

    @Override
    public double getThickness()
    {
        return line.getThickness();
    }

    @Override
    public Color getColor()
    {
        return line.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return line.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setLineWidth(this.getThickness());
        graphics.setStroke(this.getColor());
        graphics.strokeLine(this.getX(), this.getY(),line.getX2(), line.getY2());
    }
}
