package ̰����;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class SnakePanel extends JPanel {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public SnakePanel() {
    	   this.setBackground(Color.black);
    	   this.setFocusable(true);  //��ý���
    	   this.repaint();
       }
       
       public void paint(Graphics g) {
    	   
    	   this.setBackground(Color.black);
  
    	   
       }
}
