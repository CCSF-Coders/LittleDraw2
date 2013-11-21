import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;


class MyCanvas extends JPanel implements MouseListener, MouseMotionListener
{
   // This class creates a single JPanel for drawing and then implements 
   // mouse listeners.  
        

   private static final long serialVersionUID = 1L;
   private ArrayList<Point> brushStroke = new ArrayList<Point>();
   private ArrayList<Ball> balls = new ArrayList<Ball>();
   private String mouseStatus = "Mouse Status:";
   private int x;
   private int y;
   private int clickCount = 0;

   
   public MyCanvas()
   {
      // Constructor
      addMouseListener(this);             // add the mouse listeners 
      addMouseMotionListener(this);       // to this panel
      this.setBackground(Color.darkGray); // set the color

   }  // end constructor
   
   
   public void paintComponent(Graphics g)
   {
      // This class gets called when the program starts
      // AND every time the repaint() method is called.
      // this is where everything gets drawn to the panel
       
      super.paintComponent(g);      // Always do this first! 
    
      
      if(ControlPanel.isShowStats())
      {    
          g.setColor(Color.green);      // set the drawing color to green for info
          // print some text to the screen
          g.drawString("Mouse position: "+ x + " , " + y, 10, 10);
          g.drawString(mouseStatus,                       10, 20);
          g.drawString("Click Count = " + clickCount,     10, 30);
          g.drawString("Right click to reset",            10, 40);
          
          // set the color to current color choice
          g.setColor(ControlPanel.getFillColor());      // set the drawing color
          g.drawString("DrawColor", 10, 50);
      }
      
      // draw each a ball at each point
      for (Ball b : balls)  b.drawBall(g);

      // end of drawing the array of points
          
   } // end of paintComponent


   
   
   
   
// ******** Mouse Listener Methods ********************
// any time you use the MouseListener Interface, you must 
// implements these methods.
   
   public void mouseEntered(MouseEvent event) 
   {
      // when your mouse comes into the frame, set the 
      // mouseStatus variable and call the repaint() method.
       
      mouseStatus = "Mouse Status: IN THE FRAME";
      repaint();
   }
   
   public void mouseExited(MouseEvent event)  
   {
      // when your mouse leaves the frame, set the mouseStatus 
      // variable, and set the values of x and y to a -1.
      // This is only for your display so it doesn't show an
      // X and Y coordinate when you're our of the panel.
      // Then call the repaint() method to update the screen.
        
        mouseStatus = "Mouse Status: OUT OF FRAME";
        x = y = -1; 
        repaint();
    }   
    public void mouseClicked(MouseEvent event) 
    {
        if(event.getButton() == event.BUTTON3) 
        {
            balls.clear();
            clickCount = 0;
        }
        else
        {
            x=event.getX(); 
            y=event.getY(); 
            
            Point p = new Point(x,y);
            Color c = ControlPanel.getFillColor();
            
            Ball b = new Ball(p,20,c);
            balls.add(b);

        }
        
        repaint();
    }
    public void mousePressed(MouseEvent event) 
    {
        clickCount += event.getClickCount(); 
        repaint();
    }
    public void mouseReleased(MouseEvent event){}

    // mouse motion listener
    public void mouseDragged(MouseEvent event)
    {
        x=event.getX(); 
        y=event.getY(); 
        
        Point p = new Point(x,y);
        Color c = ControlPanel.getFillColor();
        
        Ball b = new Ball(p,20,c);
        balls.add(b);

        
        repaint();
    }
    public void mouseMoved(MouseEvent event)
    {
        x=event.getX(); 
        y=event.getY(); 
        repaint();
    }
    
}   
