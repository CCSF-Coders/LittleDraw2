import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;


public class Ball
{
    private int x, y, w, h;
    private Color c;
    private Graphics g;
  
    // getters 
    public int   getX()      {return x;}
    public int   getY()      {return y;}    
    public int   getW()      {return w;}
    public int   getH()      {return h;}
    public Color getC()      {return c;}   
    public Graphics getG()      {return g;}   
    
    // setters
    public void setX(int x)  {this.x = x;}
    public void setY(int y)  {this.y = y;}
    public void setW(int w)  {this.w = w;}    
    public void setH(int h)  {this.h = h;}
    public void setC(Color c){this.c = c;}

    // constructor
    Ball(Point p, int radius, Color c)
    {
        x = p.x - radius;
        y = p.y - radius;
        w = h = radius * 2;
        this.c = c;
    }
    
    void drawBall(Graphics g)
    {
        g.setColor(c);
        g.drawOval(x,y,w,h);
    }
    

}
