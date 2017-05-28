package org.fractals;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import org.drawing.CanvasPoint2D;

public abstract class SpaceFillingCurve extends Fractal
{
	protected int contadorDePuntos=0;
	protected int N=1;
	protected CanvasPoint2D todosLosPuntos[] = new CanvasPoint2D[8*1024*1024];
    protected boolean malla=true;
    protected boolean relleno=false;
    protected boolean conf=true;
    protected double perimetro = 0;
    protected double area = 0;
    protected ArrayList<CanvasPoint2D> puntos = null;
    protected Color curveColor = new Color(0,0,220);
    
    public SpaceFillingCurve(Component c)
    {
    	super(c);
    	this.puntos = new ArrayList<CanvasPoint2D>();
    }
    
    public SpaceFillingCurve(Component c, ArrayList<CanvasPoint2D> puntos)
    {
    	super(c);
    	this.puntos = puntos;
    }
    
    protected void calcularInterseccion(
    		CanvasPoint2D a,
    		CanvasPoint2D pm2,
    		CanvasPoint2D c,
    		CanvasPoint2D pm1, 
    		CanvasPoint2D mediana)
    {
        double determinante;
        double m[] = new double[2];
        double k[] = new double[2];

        if    ((a.getX()-pm2.getX())==0) {m[0]=Math.pow(10,40);}
        else  {m[0]=(a.getY()-pm2.getY())/(a.getX()-pm2.getX());}

        if    ((c.getX()-pm1.getX())==0) {m[1]=Math.pow(10,40);}
        else  {m[1]=(c.getY()-pm1.getY())/(c.getX()-pm1.getX());}

        k[0]=m[0]*a.getX()-a.getY();
        k[1]=m[1]*c.getX()-c.getY();
        determinante=(m[1]-m[0]);
        mediana.setY(((m[0]*k[1])-(m[1]*k[0]))/determinante);
        mediana.setX((k[1]-k[0])/determinante);
    }
    
    protected void calcularMedianas(
    		CanvasPoint2D a, 
    		CanvasPoint2D b, 
    		CanvasPoint2D c)
    {
    	CanvasPoint2D pm1 = new CanvasPoint2D(0,0);
    	CanvasPoint2D pm2 = new CanvasPoint2D(0,0);
    	CanvasPoint2D mediana = new CanvasPoint2D(0,0);

        pm1.setX((a.getX()+b.getX())/2);
        pm1.setY((a.getY()+b.getY())/2);
        pm2.setX((b.getX()+c.getX())/2);
        pm2.setY((b.getY()+c.getY())/2);
        
        this.calcularInterseccion(a,pm2,c,pm1,mediana);
        
        this.todosLosPuntos[this.contadorDePuntos] 
        		= new CanvasPoint2D(mediana.getX(),mediana.getY()); 

        this.contadorDePuntos++;
    }
    
    protected void dibujarTriangulo(
    		CanvasPoint2D a,
    		CanvasPoint2D b,
    		CanvasPoint2D c,int n)
    {
    	float stroke = 0.25f;
    	this.dibujarLinea(a, b, Color.LIGHT_GRAY, stroke);
    	this.dibujarLinea(b, c, Color.LIGHT_GRAY, stroke);
    	this.dibujarLinea(c, a, Color.LIGHT_GRAY, stroke);
    }
    
    protected void pintar(boolean sw)
    {
    	float stroke = 1f;
        if (sw)
        {
            if (!this.relleno)
            {
                for (int i=1;i<this.contadorDePuntos/2;i++)
                {
                	//try{Thread.sleep(10);}catch(Exception e){}
                	this.dibujarLinea(this.todosLosPuntos[i-1],
                			this.todosLosPuntos[i], curveColor, stroke);
                }
                
                for (int i=this.contadorDePuntos/2+1;i<this.contadorDePuntos;i++)
                {
                	//try{Thread.sleep(10);}catch(Exception e){}
                	this.dibujarLinea(this.todosLosPuntos[i-1],
                			this.todosLosPuntos[i], curveColor, stroke);
                }
 
            	this.dibujarLinea(this.todosLosPuntos[0], 
            			this.todosLosPuntos[this.contadorDePuntos/2], curveColor, stroke);
            }
        }
        else
        {
            if (!this.relleno)
            {
                for (int i=1;i<this.contadorDePuntos/4;i++)
                {
                	this.dibujarLinea(this.todosLosPuntos[i-1],
                			this.todosLosPuntos[i], curveColor, stroke);
                }
                
                for (int i=this.contadorDePuntos/4+1;i<this.contadorDePuntos/2;i++)
                {
                	this.dibujarLinea(this.todosLosPuntos[i-1],
                			this.todosLosPuntos[i], curveColor, stroke);
                }
                
                for (int i=this.contadorDePuntos/2+1;i<3*this.contadorDePuntos/4;i++)
                {
                	this.dibujarLinea(this.todosLosPuntos[i-1],
                			this.todosLosPuntos[i], curveColor, stroke);
                }
                
                for (int i=3*this.contadorDePuntos/4+1;i<this.contadorDePuntos;i++)
                {
                	this.dibujarLinea(this.todosLosPuntos[i-1],
                			this.todosLosPuntos[i], curveColor, stroke);
                }
            }
        }
    }

    public abstract void start();
    
    public void setN(int N)
    {
    	this.N = N;
    }

	public void setPuntos(ArrayList<CanvasPoint2D> puntos) 
	{
		this.puntos = puntos;
	}
}