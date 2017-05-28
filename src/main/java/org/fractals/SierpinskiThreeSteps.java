package org.fractals;

import java.awt.Component;

import org.drawing.CanvasPoint2D;

public class SierpinskiThreeSteps extends SpaceFillingCurve
{
	public SierpinskiThreeSteps(Component c) 
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
			CanvasPoint2D ctemp = new CanvasPoint2D(0,0);
			double temp = 0d;

			if ((b.getX()-c.getX())==0){temp=Math.pow(10,40);}
			else {temp=(b.getY()-c.getY())/(b.getX()-c.getX());}

		    if (temp==0){temp=Math.pow(10,40);}
		    else {temp=(-1)/temp;}
		    
		    pto1.setX((b.getX()+c.getX())/2);
		    pto1.setY((b.getY()+c.getY())/2);
		    ctemp.setX(1);
		    ctemp.setY(temp*(ctemp.getX()-pto1.getX())+pto1.getY());
		    this.calcularInterseccion(a,c,ctemp,pto1,pto2);
		    if (n==0)
		    {
				if (this.malla)
					this.dibujarTriangulo(a,b,c,n);
				this.calcularMedianas(a,b,c);
		    }
		    if (!sw)
		    {
				this.render(pto1,pto2,c,n-1,false);
				this.render(pto1,pto2,b,n-1,true);
				this.render(a,pto2,b,n-1,false);
		    }
		    else
		    {
		    	this.render(a,pto2,b,n-1,true);
		    	this.render(pto1,pto2,b,n-1,false);
		    	this.render(pto1,pto2,c,n-1,true);
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
