package org.fractals;

import java.awt.Component;
import org.drawing.CanvasPoint2D;

public class SierpinskiTenSteps2 extends SpaceFillingCurve
{
	public SierpinskiTenSteps2(Component c) 
	{
		super(c);
	}

	private void render(
	   		CanvasPoint2D a,
    		CanvasPoint2D b,
    		CanvasPoint2D c,
    		int n,
    		boolean sw) 
	{
		/*          c
		 *         /|
		 *        / |
		 *       /  |
		 *      /   |
		 *     /    |
		 *    /     |
		 *   /      |
		 * b/_______|
		 *          a
		 * */
        if (n>=0)
        {
        	CanvasPoint2D pto1 = new CanvasPoint2D(0,0);
        	CanvasPoint2D pto2 = new CanvasPoint2D(0,0);
        	CanvasPoint2D pto3 = new CanvasPoint2D(0,0);
        	CanvasPoint2D pto4 = new CanvasPoint2D(0,0);
        	CanvasPoint2D pto5 = new CanvasPoint2D(0,0);
        	CanvasPoint2D pto6 = new CanvasPoint2D(0,0);
        	CanvasPoint2D pto7 = new CanvasPoint2D(0,0);
        	CanvasPoint2D pto8 = new CanvasPoint2D(0,0);

            pto1.setX((a.getX()+c.getX())/2);
            pto1.setY((a.getY()+c.getY())/2);
            
            pto3.setX((b.getX()+c.getX())/2);
            pto3.setY((b.getY()+c.getY())/2);

            pto2.setX((pto3.getX()+pto1.getX())/2);
            pto2.setY((pto3.getY()+pto1.getY())/2);
            
            pto5.setX((b.getX()+a.getX())/2);
            pto5.setY((b.getY()+a.getY())/2);
            
            pto6.setX((pto5.getX()+a.getX())/2);
            pto6.setY((pto5.getY()+a.getY())/2);
            
            pto4.setX((pto5.getX()+pto3.getX())/2);
            pto4.setY((pto5.getY()+pto3.getY())/2);
            
            pto7.setX((a.getX()+pto1.getX())/2);
            pto7.setY((a.getY()+pto1.getY())/2);
            
            pto8.setX((pto3.getX()+a.getX())/2);
            pto8.setY((pto3.getY()+a.getY())/2);
            
            if (n==0)
            {
                if (this.malla)
                {
                	this.dibujarTriangulo(a,b,c,n);
                }
                this.calcularMedianas(a,b,c);
            }
            if (!sw)
            {
            	this.render(pto1,pto3,c,n-1,false);
            	this.render(pto2,pto3,pto8,n-1,true);
            	this.render(pto2,pto8,pto1,n-1,true);
            	this.render(pto7,pto8,pto1,n-1,false);
            	
            	this.render(pto7,pto8,a,n-1,true);
            	this.render(pto6,a,pto8,n-1,true);
            	
            	this.render(pto6,pto5,pto8,n-1,false);
            	this.render(pto4,pto5,pto8,n-1,true);
            	this.render(pto4,pto8,pto3,n-1,true);
            	this.render(pto5,b,pto3,n-1,false);
            }
            else
            {
            	this.render(pto5,b,pto3,n-1,true);
            	this.render(pto4,pto8,pto3,n-1,false);
            	this.render(pto4,pto5,pto8,n-1,false);
            	this.render(pto6,pto5,pto8,n-1,true);

            	this.render(pto6,a,pto8,n-1,false);
            	this.render(pto7,pto8,a,n-1,false);
            	
            	this.render(pto7,pto8,pto1,n-1,true);
            	this.render(pto2,pto8,pto1,n-1,false);
            	this.render(pto2,pto3,pto8,n-1,false);
            	this.render(pto1,pto3,c,n-1,true);
            }
        }
	}

	@Override
	public void start() 
	{
		/*          b
		 *         /|\
		 *        / | \
		 *       /  |  \
		 *      /   |   \
		 *     /    |    \
		 *    /     |     \
		 *   /      |      \
		 * a/_______|_______\c
		 *          pm
		 * */
    	this.perimetro = 0;
    	CanvasPoint2D a  = new CanvasPoint2D(0,0);
    	CanvasPoint2D b  = new CanvasPoint2D(0,0);
    	CanvasPoint2D c  = new CanvasPoint2D(0,0);
        double p=0.99d;
        CanvasPoint2D pm = new CanvasPoint2D(0,0);
        int n;

        this.getCentroDeLaPantalla().setX(((double)this.getComponent().getWidth())/2d);
        this.getCentroDeLaPantalla().setY(((double)this.getComponent().getHeight())/2d);
        n=this.N;
        if (this.conf)
        {
        	if (this.puntos.size() > 0)
        	{
        		a = this.puntos.get(0);
        		b = this.puntos.get(1);
        		c = this.puntos.get(2);
        	}
        	else
        	{
	            a.setX(0);
	            a.setY(this.getCentroDeLaPantalla().getY()*(p+1));
	            
	            b.setX(this.getCentroDeLaPantalla().getX());
	            b.setY(a.getY()-this.getCentroDeLaPantalla().getX());
	            
	            c.setX(this.getCentroDeLaPantalla().getX()*2);         
	            c.setY(a.getY());
        	}
        	
            pm.setX((a.getX()+c.getX())/2);
            pm.setY((a.getY()+c.getY())/2);
            this.contadorDePuntos = 0;
            this.render(pm,a,b,n,false);
            this.render(pm,c,b,n,false);
            pintar(true);
        }
        else
        {
            this.contadorDePuntos = 0;
            a.setX(this.getCentroDeLaPantalla().getX());
            a.setY(this.getCentroDeLaPantalla().getY());
            b.setX(this.getCentroDeLaPantalla().getX());
            b.setY(this.getCentroDeLaPantalla().getY()-
            		this.getCentroDeLaPantalla().getX()/Math.sqrt(3));
            c.setX(2*this.getCentroDeLaPantalla().getX());
            c.setY(this.getCentroDeLaPantalla().getY());
            this.render(a,b,c,n,false);
            b.setX(this.getCentroDeLaPantalla().getX());
            b.setY(this.getCentroDeLaPantalla().getY()+
            		this.getCentroDeLaPantalla().getX()/Math.sqrt(3));
            this.render(a,b,c,n,false);
            c.setX(0);
            this.render(a,b,c,n,false);
            b.setX(this.getCentroDeLaPantalla().getX());
            b.setY(this.getCentroDeLaPantalla().getY()-
            		this.getCentroDeLaPantalla().getX()/Math.sqrt(3));
            this.render(a,b,c,n,false);
            pintar(false);
        }
	}
}
