package adapters;

/*
 * Nicholas Perez
 * 12/5/2017
 * HexagonAdapter.java
 *
 * DESCRIPTION
 */

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Hexagon;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 */
public class HexagonAdapter implements IShape
{
    private Hexagon hexagon;

    /**
     * Instantiates a new Hexagon adapter.
     *
     * @param hexagon the hexagon
     */
    public HexagonAdapter(Hexagon hexagon)
    {
        this.hexagon = hexagon;
    }

    @Override
    public IShape setThickness(double value)
    {
        hexagon = new Hexagon(hexagon.getX(), hexagon.getY(), hexagon.getWidth(), hexagon.getHeight(), value, hexagon.getColor(), hexagon.isFill());
        return this;
    }

    @Override
    public IShape setColor(Color value)
    {
        hexagon = new Hexagon(hexagon.getX(), hexagon.getY(), hexagon.getWidth(), hexagon.getHeight(), hexagon.getThickness(), value, hexagon.isFill());
        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        hexagon = new Hexagon(hexagon.getX(), hexagon.getY(), hexagon.getWidth(), hexagon.getHeight(), hexagon.getThickness(), hexagon.getColor(), value);
        return this;
    }

    @Override
    public double getX()
    {
        return hexagon.getX();
    }

    @Override
    public double getY()
    {
        return hexagon.getY();
    }

    @Override
    public double getThickness()
    {
        return hexagon.getThickness();
    }

    @Override
    public Color getColor()
    {
        return hexagon.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return hexagon.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        if(this.getFilled())
        {
            graphics.setFill(this.getColor());
            graphics.fillPolygon(new double[]{
                    this.getX(),
                    this.getX()+(hexagon.getWidth()/2),
                    this.getX()+(hexagon.getWidth()),
                    this.getX()+(hexagon.getWidth()),
                    this.getX()+(hexagon.getWidth()/2),
                    this.getX(),
                    this.getX()


            },new double[]{
                    this.getY(),
                    this.getY()+(hexagon.getHeight()/4),
                    this.getY(),
                    this.getY()-(hexagon.getHeight()-(hexagon.getHeight()/2)),
                    this.getY()-(hexagon.getHeight()-25),
                    this.getY()-(hexagon.getHeight()-(hexagon.getHeight()/2)),
                    this.getY()

            }, 7);
        }

        graphics.setStroke(this.getColor());
        graphics.setLineWidth(this.getThickness());
        graphics.strokePolygon(new double[]{
                this.getX(),
                this.getX()+(hexagon.getWidth()/2),
                this.getX()+(hexagon.getWidth()),
                this.getX()+(hexagon.getWidth()),
                this.getX()+(hexagon.getWidth()/2),
                this.getX(),
                this.getX()


        },new double[]{
                this.getY(),
                this.getY()+(hexagon.getHeight()/4),
                this.getY(),
                this.getY()-(hexagon.getHeight()-(hexagon.getHeight()/2)),
                this.getY()-(hexagon.getHeight()-25),
                this.getY()-(hexagon.getHeight()-(hexagon.getHeight()/2)),
                this.getY()

        }, 7);
    }
}
