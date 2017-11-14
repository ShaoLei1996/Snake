package Ã∞≥‘…ﬂ;

import javax.swing.JFrame;

public class Snake {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
             JFrame frame=new JFrame("Snake");
             frame.setBounds(50,50,1000,800);
             frame.setResizable(false);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
             SnakePanel panel=new SnakePanel();
             
             frame.add(panel);

             frame.setVisible(true);
             
	}

}
