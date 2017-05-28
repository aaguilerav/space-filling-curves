package org.fractals;

import java.awt.Component;

import org.drawing.CanvasPoint2D;

public class SierpinskiFourSteps extends SpaceFillingCurve
{
	public SierpinskiFourSteps(Component c) 
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
        if (n>=0)
        {
        	CanvasPoint2D pto1 = new CanvasPoint2D(0,0);
        	CanvasPoint2D pto2 = new CanvasPoint2D(0,0);
        	CanvasPoint2D pto3 = new CanvasPoint2D(0,0);

            pto1.setX((b.getX()+c.getX())/2);
            pto1.setY((b.getY()+c.getY())/2);
            pto2.setX((a.getX()+c.getX())/2);
            pto2.setY((a.getY()+c.getY())/2);
            pto3.setX((b.getX()+pto1.getX())/2);
            pto3.setY((b.getY()+pto1.getY())/2);
            if (n==0)
            {
                if (this.malla)
                {
                	dibujarTriangulo(a,b,c,n);
                }
                calcularMedianas(a,b,c);
            }
            if (!sw)
            {
                this.render(pto2,pto1,c,n-1,false);
                this.render(pto2,pto1,a,n-1,true);
                this.render(pto3,pto1,a,n-1,false);
                this.render(pto3,b,a,n-1,true);
            }
            else
            {
            	this.render(pto3,b,a,n-1,false);
            	this.render(pto3,pto1,a,n-1,true);
            	this.render(pto2,pto1,a,n-1,false);
            	this.render(pto2,pto1,c,n-1,true);
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
	            a.setX(this.getCentroDeLaPantalla().getX()-
	            		(Math.sqrt(3)/3)*2*this.getCentroDeLaPantalla().getY()*p);
	            a.setY(this.getCentroDeLaPantalla().getY()*(p+1));
	            
	            b.setX(this.getCentroDeLaPantalla().getX());
	            b.setY(this.getCentroDeLaPantalla().getY()*(1-p));
	            
	            c.setX(this.getCentroDeLaPantalla().getX()+
	            		(Math.sqrt(3)/3)*2*this.getCentroDeLaPantalla().getY()*p);         
	            c.setY(a.getY());
        	}
        	
            pm.setX((a.getX()+c.getX())/2);
            pm.setY((a.getY()+c.getY())/2);
            this.contadorDePuntos = 0;
            this.render(pm,a,b,n,false);
            this.render(pm,c,b,n,false);
            this.pintar(true);
        }
        else
        {
            this.contadorDePuntos = 0;
            a.setX(this.getCentroDeLaPantalla().getX()*p);
            a.setY(this.getCentroDeLaPantalla().getY()*p);
            b.setX(this.getCentroDeLaPantalla().getX()*p);
            b.setY((this.getCentroDeLaPantalla().getY()-
            		this.getCentroDeLaPantalla().getX()/Math.sqrt(3))*p);
            c.setX(2*this.getCentroDeLaPantalla().getX()*p);
            c.setY(this.getCentroDeLaPantalla().getY()*p);
            this.render(a,b,c,n,false);
            b.setX(this.getCentroDeLaPantalla().getX()*p);
            b.setY((this.getCentroDeLaPantalla().getY()+
            		this.getCentroDeLaPantalla().getX()/Math.sqrt(3))*p);
            this.render(a,b,c,n,false);
            c.setX(0);
            this.render(a,b,c,n,false);
            b.setX(this.getCentroDeLaPantalla().getX()*p);
            b.setY((this.getCentroDeLaPantalla().getY()-
            		this.getCentroDeLaPantalla().getX()/Math.sqrt(3))*p);
            this.render(a,b,c,n,false);
            pintar(false);
        }
	}
}
