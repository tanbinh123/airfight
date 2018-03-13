package feiji;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;


import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class 游戏面板 extends  JPanel implements Runnable,KeyListener {
	int dijishu, zidanju;
	Image dijizhao[]=new Image[6];
	Image diji[];
	Image zhuji;
	Image beijing[];
	
	Image zidan;int diji_X[];int diji_Y[];
    int zhux; int zhuy;int beijinshu;
	int zidanx[]=new int[20]; int zidany[]=new int[20];
	int score=1000;
	public  游戏面板(int 火力,int 难度,int 背景){
		 zidanju=火力*30;
		  dijishu= 难度;
		  beijinshu=背景;
		  beijing=new Image[3];
		 diji=new Image[dijishu];
		  diji_X=new int[dijishu];
	     diji_Y=new int[dijishu];//字母的Y坐标
	    try {//for(int i=0;i<6;i++){
	 	   zhuji=ImageIO.read(new File("主机.gif"));
		  dijizhao[0]=ImageIO.read(new File("敌机1.gif"));
		  dijizhao[1]=ImageIO.read(new File("敌机2.gif"));
		  dijizhao[2]=ImageIO.read(new File("敌机3.gif"));
		  dijizhao[3]=ImageIO.read(new File("敌机4.gif"));
		  dijizhao[4]=ImageIO.read(new File("敌机5.gif"));
		  dijizhao[5]=ImageIO.read(new File("敌机6.gif"));
		   beijing[0]=ImageIO.read(new File("背景1.jpg"));
		   beijing[1]=ImageIO.read(new File("背景2.jpg"));
		   beijing[2]=ImageIO.read(new File("背景3.jpg"));
		    zidan=ImageIO.read(new File("1.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}}
	
	//字母的X坐标
	
	
  public void paint(Graphics g){
		super.paint(g);
		g.drawImage(beijing[beijinshu], -5, -5,510,400, null);
		g.setColor(Color.RED);
		g.setFont(new Font("宋体",Font.BOLD,20));
		g.drawString("您的分数为："+score, 10, 20);
		g.drawString("您的分数为："+score, 10, 20);
		for(int i=0;i<zidanx.length;i++){
		g.drawImage(zidan, zidanx[i], zidany[i],40,40, null);
		}
		g.drawImage(zhuji, zhux, zhuy,50,70, null);
		for(int i=0;i<dijishu;i++){
		g.drawImage(diji[i], diji_X[i], diji_Y[i],40,40, null);
		}
	}
	public void run() {
		  zhux=220;zhuy=300;
		  zidanx[0]=zhux+10;zidany[0]=zhuy-30;
		  for(int i=1;i<zidanx.length;i++){
			  zidanx[i]=zidanx[0];
			  zidany[i]=zidany[i-1]-zidanju; 
		  }
		for(int i=0;i<dijishu;i++){
			int e=(int)(Math.random()*6);
			diji[i]=dijizhao[e];
			diji_X[i]=(int)(Math.random()*470);
			diji_Y[i]=(int)(Math.random()*-400);
			}
	while(score>0){
		
		        zidany[0]--;
		   for(int i=1;i<zidanx.length;i++){//子弹坐标
				
		       if(zidany[0]-zhuy>=-zidanju-40){
					zidanx[zidanx.length-1]=zhux+10;
					zidany[zidanx.length-1]=zhuy-30;
				}	
		        zidany[i]--;
				if(zidany[i]-zhuy==-zidanju-40){
						zidanx[i-1]=zhux+10;
						zidany[i-1]=zhuy-30;
				}	
				}
		for(int i=0;i<dijishu;i++){
			if(diji_X[i]>0&&diji_Y[i]>0){
			 if(-50<zhux-diji_X[i]&&zhuy-diji_Y[i]<=50
						&&zhuy-diji_Y[i]>=30 &&50>zhux-diji_X[i]){
				   score-=10;
					int e=(int)(Math.random()*6);
					diji[i]=dijizhao[e]; 
					diji_X[i]=(int)(Math.random()*470);
					diji_Y[i]=-200;
					break;
				}
			   
			for(int j=0;j<zidanx.length;j++){
				if(-40<zidanx[j]-diji_X[i]&&zidany[j]-diji_Y[i]<40
						&&zidany[j]-diji_Y[i]>-30 &&40>zidanx[j]-diji_X[i]){
					score+=10;
					int e=(int)(Math.random()*6);
					diji[i]=dijizhao[e]; 
					diji_X[i]=(int)(Math.random()*470);
					diji_Y[i]=-200;
					break;
				}
		  }
					
					
				if(diji_Y[i]>400){//判断敌机是否越界
						score-=10;		
						int e=(int)(Math.random()*6);
						diji[i]=dijizhao[e];
						diji_X[i]=(int)(Math.random()*450);
						diji_Y[i]=-200;
				}}diji_Y[i]++;
		}
	   	try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				repaint();
			 }
		}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		/*if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W){
	           zhuy-=3;  
	        }
	        if(e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_S){
	            zhuy+=3;  
	           
	        }*/
		
			/*if(zhux>=0){
	         if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){
	            zhux-=6; 
	            
	        }
	        }
			if(zhux<=440){
	           if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){
	            zhux+=6; 
	        }
	        	
	        }*/
			
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	     /*if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W){
	           zhuy-=3;  
	        }
	        if(e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_S){
	            zhuy+=3;  
	           
	        }*/
		if(zhux>=0){
	         if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){
	            zhux-=6; 
	            
	        }
	        }
			if(zhux<=440){
	           if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){
	            zhux+=6; 
	        }
	        	
	        }
			}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
