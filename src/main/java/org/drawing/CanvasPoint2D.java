package org.drawing;

import java.awt.geom.Point2D;

public class CanvasPoint2D 
{
	private double x;
	private double y;
	
	public CanvasPoint2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public Point2D getPoint2Dobject()
	{
		return new Point2D.Double(this.x, this.y);
	}
	
	public double getDistanceBetweenPoints(CanvasPoint2D p)
	{
		return Math.sqrt(Math.pow(this.x-p.getX(),2)+Math.pow(this.y-p.getY(),2));
	}
}