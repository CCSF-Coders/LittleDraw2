//  Author: Chuck Griffin
//  Purpose: an example for my friends
//  Date:  11/19/13

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawDemo extends JFrame
{

   private static final long serialVersionUID = 1L;
   private static MyCanvas mc;
   private static ControlPanel cp;

   public static void main(String[] args) 
   {
       
	  // This is that class that creates the frame, sets it's size
	  // and title and the calls my MyCanvas class and adds it
	  // to the frame.
	   
	  // make the frame
      JFrame mf = new JFrame();
      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mf.setSize(800, 600);
      mf.setTitle("My Little Draw Demo");
      mf.setVisible(true);
      
      // create the canvas and add it to the frame.
      setMc(new MyCanvas());
      cp = new ControlPanel();
      mf.add(getMc());
      mf.add(cp, BorderLayout.SOUTH);
      
   }  // end of main

public static MyCanvas getMc()
{
    return mc;
}

public static void setMc(MyCanvas mc)
{
    DrawDemo.mc = mc;
}
} // end of class that creates the frame

	
	
	
	

