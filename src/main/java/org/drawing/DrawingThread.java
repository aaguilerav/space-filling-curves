package org.drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;


public class DrawingThread implements Runnable
{
	private CanvasPoint2D arregloDePuntos[];
	private int limInf = 0;
	private int limSup = 0;
	private Graphics2D g2d;
	
	public DrawingThread(CanvasPoint2D arregloDePuntos[], int limInf, int limSup, Graphics2D g2d)
	{
		this.arregloDePuntos = arregloDePuntos;
		this.limInf = limInf;
		this.limSup = limSup;
		this.g2d = g2d;
        this.g2d.setStroke(new BasicStroke(0.25f));
        this.g2d.setPaint(Color.RED);
	}
	
    private void dibujarLinea(CanvasPoint2D a, CanvasPoint2D b)
    {
    	Line2D line = new Line2D.Double(
    			a.getPoint2Dobject(), 
    			b.getPoint2Dobject());

        this.g2d.draw(line);
    }

	public void run() 
	{
        for (int i=limInf;i<this.limSup;i++)
        {
        	this.dibujarLinea(this.arregloDePuntos[i-1],
        			this.arregloDePuntos[i]);
        }
	}
}
