import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class ControlPanel extends JPanel
{

    private static final long serialVersionUID = 1L;
    private  JCheckBox showStatsCB;
    private static boolean showStats; 
    private static Color fillColor;
    


    public static  Color getFillColor()
    {
        return fillColor;
    }

    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
    }


    public ControlPanel()
    {
       showStatsCB = new JCheckBox("Show Stats", false);
       StatsListener listener = new StatsListener();
       showStatsCB.addItemListener(listener);
       add(showStatsCB);      
       

       
       JButton fillColorButton = new JButton("Fill Color");
   
       // Button setting for the fill color
       fillColorButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event) {
               fillColor = JColorChooser.showDialog(null,
                       "Choose your fill color", fillColor);
               if(fillColor == null) fillColor = (Color.BLACK);
   
           }
       });

       add(fillColorButton);


       
   }
 
    
 
    public static boolean isShowStats(){return showStats;}
    public void setShowStats(boolean showStats) { this.showStats = showStats;}
    
    private class StatsListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent event)
        {
            setShowStats(showStatsCB.isSelected()); 
            DrawDemo.getMc().repaint();
        }
    }
  
}
