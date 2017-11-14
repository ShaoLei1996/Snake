package snake;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakePanel extends JPanel implements KeyListener,ActionListener {
	
	//蛇的各个部位的图片
	ImageIcon up=new ImageIcon("up.png");
	ImageIcon down=new ImageIcon("down.png");
	ImageIcon left=new ImageIcon("left.png");
	ImageIcon right=new ImageIcon("right.png");
	ImageIcon body=new ImageIcon("body.jpg");
	ImageIcon food=new ImageIcon("food.png");
	ImageIcon title=new ImageIcon("title.png");
	
	int snakex[]=new int[900];   //记录当前坐标
	int snakey[]=new int[900];
	int len;           //记录蛇的长度
	String fangxiang=new String();    //记录蛇头方向  R,U,L,D
    boolean	 start=false;
	Timer time=new Timer(200,this);
	Random ran=new Random();
    int foodx=ran.nextInt(35)*25;
    int foody=ran.nextInt(27)*25+100;
    
	public SnakePanel() {
    	   this.setFocusable(true);  //获得焦点
    	   this.addKeyListener(this);
           setup();
           time.start();
       }
       
       public void paint(Graphics g) {
    	   super.paint(g);          
    	   this.setBackground(Color.white);   	   
           title.paintIcon(this, g,0, 0);
     //        g.setColor(Color.WHITE);
      //     g.fillRect(0, 100, 900, 700);
          
           
           if(fangxiang.equals("R")) {
        	   right.paintIcon(this, g, snakex[0], snakey[0]);
           }else  if(fangxiang.equals("L")) {
        	   left.paintIcon(this, g, snakex[0], snakey[0]);
           }else  if(fangxiang.equals("U")) {
        	   up.paintIcon(this, g, snakex[0], snakey[0]);
           }else  if(fangxiang.equals("D")) {
        	   down.paintIcon(this, g, snakex[0], snakey[0]);
           }
           
           for(int i=1;i<len;i++) {
          	   body.paintIcon(this, g, snakex[i],snakey[i]);
           }      
           if(!start) {
        	   g.setColor(Color.green);
        	   g.setFont(new Font("arial",Font.BOLD,40));
        	   g.drawString("Please Press  SPACE  to Start or Pause", 50, 700);  	   
           }
           
           food.paintIcon(this, g, foodx, foody);
   
       }
       
       
       
       public void setup() {
    	   fangxiang="R";
    	   len=3;
    	   snakex[0]=100;
    	   snakey[0]=150;
    	   snakex[1]=75;
    	   snakey[1]=150;
    	   snakex[2]=50;
    	   snakey[2]=150;
       }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int keycode=e.getKeyCode();
		//上下左右移动
	   if(keycode==KeyEvent.VK_SPACE) {
			start=!start;
			repaint();
		}else   if(keycode==KeyEvent.VK_UP  &&  fangxiang!="D") {
			fangxiang="U"	;	
		}else	if(keycode==KeyEvent.VK_DOWN && fangxiang!="U"){
			fangxiang="D";
		}else	if(keycode==KeyEvent.VK_RIGHT &&fangxiang!="L") {
			fangxiang="R";
		}else	if(keycode==KeyEvent.VK_LEFT  &&fangxiang!="R") {
			fangxiang="L";
		}
		
		//WASD移动
	/*	if(keycode==KeyEvent.VK_SPACE) {
			start=!start;
			repaint();
		}else   if(keycode==KeyEvent.VK_W  &&  fangxiang!="D") {
			fangxiang="U"	;	
		}else	if(keycode==KeyEvent.VK_S && fangxiang!="U"){
			fangxiang="D";
		}else	if(keycode==KeyEvent.VK_A &&fangxiang!="L") {
			fangxiang="R";
		}else	if(keycode==KeyEvent.VK_D  &&fangxiang!="R") {
			fangxiang="L";
		}*/
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub			
			time.start();
			if(start) {
				for(int i=len;i>0;i--) {
					snakex[i]=snakex[i-1];
				    snakey[i]=snakey[i-1];
				}
				   if(fangxiang.equals("R")) {
		        	  snakex[0]=snakex[0]+25;
		        	  if(snakex[0]>875)
		        		  snakex[0]=0;
		           }else     if(fangxiang.equals("L")) {
		        	   snakex[0]=snakex[0]-25;
		        	   if(snakex[0]<0)
		        		   snakex[0]=875;
		           }else     if(fangxiang.equals("U")) {
		        	   snakey[0]=snakey[0]-25;
		        	   if(snakey[0]<100)
		        		   snakey[0]=800;
		           }else     if(fangxiang.equals("D")) {
		        	   snakey[0]=snakey[0]+25;
		        	    if(snakey[0]>800)
		        	    	snakey[0]=100;
		           }
		           
			if(snakex[0]==foodx&&snakey[0]==foody) {   //成长检测
				len++;
			    foodx=ran.nextInt(36)*25;
			    foody=ran.nextInt(28)*25+100;    
			}	  
			//碰撞检测
			
			for(int i=1;i<len;i++) {
				if(snakex[0]==snakex[i ]&& snakey[0]==snakey[i]) {
				start=false;}
			}
				   
				   
		           }
				
				repaint();
			}	
	}
       

