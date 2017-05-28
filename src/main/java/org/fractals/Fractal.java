package org.fractals;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import org.drawing.CanvasPoint2D;

public abstract class Fractal 
{
	private CanvasPoint2D centroDeLaPantalla = new CanvasPoint2D(0,0);
	private Graphics2D g2d = null;
	private Component C = null;
	private String description;
	
	public Fractal(Component c)
	{
		this.g2d = (Graphics2D)c.getGraphics();
        this.centroDeLaPantalla.setX(((double)c.getWidth())/2d);
        this.centroDeLaPantalla.setY(((double)c.getHeight())/2d);
        this.description = "<sin nombre>";
        this.C = c;
	}
	
	public Fractal(Component c, String description)
	{
		this.g2d = (Graphics2D)c.getGraphics();
        this.centroDeLaPantalla.setX(((double)c.getWidth())/2d);
        this.centroDeLaPantalla.setY(((double)c.getHeight())/2d);
        this.description = description; 
        this.C = c;
	}
	
    public String getDescription() 
    {
		return description;
	}

	protected void dibujarLinea(CanvasPoint2D a, CanvasPoint2D b, Color color, float stroke)
    {
    	Line2D line = new Line2D.Double(
    			a.getPoint2Dobject(), 
    			b.getPoint2Dobject());
    	
    	this.g2d.setPaint(color);
    	this.g2d.setStroke(new BasicStroke(stroke));
    	this.g2d.draw(line);
    }
	
	protected Graphics2D getG2d()
	{
		return this.g2d;
	}
	
	protected CanvasPoint2D getCentroDeLaPantalla()
	{
		return this.centroDeLaPantalla;
	}

	protected Component getComponent()
	{
		return this.C;
	}
}