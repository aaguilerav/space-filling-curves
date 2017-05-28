package org.fractals;

import java.awt.Component;
import org.drawing.CanvasPoint2D;

public class SierpinskiFiveSteps extends SpaceFillingCurve
{
	public SierpinskiFiveSteps(Component c) 
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
        	CanvasPoint2D ptoT = new CanvasPoint2D(0,0);

            ptoT.setX((b.getX()+c.getX())/2);
            ptoT.setY((b.getY()+c.getY())/2);
            
            pto2.setX((b.getX()+ptoT.getX())/2);
            pto2.setY((b.getY()+ptoT.getY())/2);
        	
            pto1.setX((pto2.getX()+c.getX())/2);
            pto1.setY((pto2.getY()+c.getY())/2);
            
            pto3.setX((pto2.getX()+a.getX())/2);
            pto3.setY((pto2.getY()+a.getY())/2);
            
            pto4.setX((c.getX()+a.getX())/2);
            pto4.setY((c.getY()+a.getY())/2);
            
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
            	this.render(pto1,pto4,c,n-1,false);
            	this.render(pto1,pto4,pto2,n-1,true);
            	this.render(pto3,pto2,pto4,n-1,true);
            	this.render(pto3,a,pto4,n-1,false);
            	this.render(pto2,b,a,n-1,false);
            }
            else
            {
            	this.render(pto2,b,a,n-1,true);
            	this.render(pto3,a,pto4,n-1,true);
            	this.render(pto3,pto2,pto4,n-1,false);
            	this.render(pto1,pto4,pto2,n-1,false);
            	this.render(pto1,pto4,c,n-1,true);
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
            
    		/*          b
    		 *         /|
    		 *        / |
    		 *       /  |
    		 *      /   |
    		 *     /    |
    		 *    / IZQ |
    		 *   /      |
    		 * a/_______|
    		 *          pm
    		 * */
            this.render(pm,a,b,n,false); //Triangulo de la izq.
            
    		/* b
    		 * |\
    		 * | \
    		 * |  \
    		 * |   \
    		 * |    \
    		 * | DER \
    		 * |      \
    		 * |_______\c
    		 * pm
    		 * */
            this.render(pm,c,b,n,false); //Triangulo de la der.
            
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
