package com.javashixun.feiji.day1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Start extends JFrame {
	JFrame jf1;
	public Start(){//游戏主窗体
		jf1 = new JFrame();
		jf1.setTitle("飞机大战");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		jf1.setSize(dim);
		jf1.setVisible(true);
		jf1.setDefaultCloseOperation(3);
		
		//背景图
		
		MyJPanel mp = new MyJPanel();
		jf1.add(mp);

		mp.addMouseMotionListener(mp);
		mp.addKeyListener(mp);
		Thread th = new Thread(mp);
		th.start();
	}

}
class MyJPanel extends JPanel implements Runnable,MouseMotionListener,KeyListener{
	int a = (int)(Math.random()*3)+1;
	URL imgU0 = StratGame.class.getResource("背景"+a+".jpg");
	ImageIcon im0 = new ImageIcon(imgU0);
	//背景图图片
	URL imgURL = StratGame.class.getResource("fly.png");
	ImageIcon img = new ImageIcon(imgURL);
	//玩家飞机图片
	
	
	URL imgURL1 = StratGame.class.getResource("fly1.png");
	ImageIcon img1 = new ImageIcon(imgURL1);
	URL imgURL2 = StratGame.class.getResource("fly2.png");
	ImageIcon img2 = new ImageIcon(imgURL2);
	URL imgURL3 = StratGame.class.getResource("fly3.png");
	ImageIcon img3 = new ImageIcon(imgURL3);
	
	//爆炸效果图片
	URL imgUR1 = StratGame.class.getResource("打击1.gif");
	ImageIcon u1 = new ImageIcon(imgUR1);
	URL imgUR2 = StratGame.class.getResource("打击2.gif");
	ImageIcon u2 = new ImageIcon(imgUR2);
	URL imgUR3 = StratGame.class.getResource("打击3.gif");
	ImageIcon u3 = new ImageIcon(imgUR3);
	//敌人飞机图片
	URL imgURL10 = StratGame.class.getResource("fire.png");
	ImageIcon img10 = new ImageIcon(imgURL10);

	//子弹图片
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	int x=1000;
	int y=800;
	int b,score;
	int speed = (int)(Math.random()* 10)+1;
	int speed1 = (int)(Math.random()* 10)+1;
	int d=5;//血条
	int feiji1X[] = new int[5];
	int feiji1Y[] = new int[5];//大型飞机个数
	int feiji2X[] = new int[10];
	int feiji2Y[] = new int[10];//中型飞机个数
	int feiji3X[] = new int[15];
	int feiji3Y[] = new int[15];//小型飞机个数
	ArrayList<zidan> zidans = new ArrayList<zidan>();

	
	public void intzidan(){
		zidan zd =new zidan();
		zd.setZidanx(x);
		zd.setZidany(y);
		zidans.add(zd);
	}//子弹方法

	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(im0.getImage(), 0, 0, dim.width, dim.height, null, null);
		//背景
		g.setColor(Color.gray);
		g.fillRect(40, 40, 200, 40);
		g.setColor(Color.red);
		g.setFont(new Font("asd", Font.BOLD, 40));
		g.drawString("我的分数："+score, 1600, 40);
		g.fillRect(40, 40, d*10+150, 40);
		g.drawImage(img.getImage(), x-50, y-50, null);
		for(int i =0;i<zidans.size();i++){
			zidan zd = zidans.get(i);
			g.drawImage(img10.getImage(), zd.getZidanx()-50, zd.getZidany()-100, null);
			}
		
			for(int i = 0; i<5; i++){
				g.drawImage(img1.getImage(), feiji1X[i], feiji1Y[i], null);
				}
			for(int i = 0; i<10; i++){
				g.drawImage(img2.getImage(), feiji2X[i], feiji2Y[i], null);
				}
			for(int i = 0; i<15; i++){
				g.drawImage(img3.getImage(), feiji3X[i]-10, feiji3Y[i]-10, null);
				
				}
	}
	
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x=arg0.getX();
		y=arg0.getY();
		
	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
		
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void run() {
		
		// TODO Auto-generated method stub
			for(int i = 0; i<5; i++){
			feiji1X[i]= (int)(Math.random()* (Toolkit.getDefaultToolkit().getScreenSize().width))-50;
			feiji1Y[i]= (int)(Math.random()* 1000)-2500;
		}//大飞机个数
		for(int i = 0; i<10; i++){
			feiji2X[i]= (int)(Math.random()* (Toolkit.getDefaultToolkit().getScreenSize().width))-50;
			feiji2Y[i]= (int)(Math.random()* 1000)-2000;
		}//中飞机个数
		for(int i = 0; i<15; i++){
			feiji3X[i]= (int)(Math.random()* (Toolkit.getDefaultToolkit().getScreenSize().width))-50;
			feiji3Y[i]= (int)(Math.random()* 1000)-1500;
		}//小飞机个数
		
		
		int cnt=0;
		while(d*10+150>=0){//子弹火力大小
			if(cnt%5==0)
				intzidan();
			cnt++;
			if(d*10+150==0){//生命值为0弹出框
				int i = JOptionPane.showConfirmDialog(this,"游戏结束，是否再来一局","飞机大战",JOptionPane.YES_NO_OPTION);
				if(i==0){
					//Start.DISPOSE_ON_CLOSE;
					new Start();
					}
				
				else
					System.exit(0);
			}
			for(int i=0;i<zidans.size();i++){//子弹坐标
				 zidan zd = zidans.get(i);
				 if(zd.getZidany()>1080)
					 zidans.remove(i);
				 else
					 zd.setZidany(zd.getZidany()-15);
					}
	
			for(int i=0;i<feiji1Y.length;i++){//大飞机下落
				feiji1Y[i]++;
				if(feiji1Y[i]>1080){
					feiji1Y[i]=(int)(Math.random()* 1000)-2500;
					feiji1X[i]=(int)(Math.random()* (Toolkit.getDefaultToolkit().getScreenSize().width));

				}
			}
			for(int i=0;i<feiji2Y.length;i++){//中飞机下落
				feiji2Y[i]=feiji2Y[i]+25;
				if(feiji2Y[i]>1080){
				
					feiji2Y[i]=(int)(Math.random()* 1000)-2000;
					feiji2X[i]=(int)(Math.random()* (Toolkit.getDefaultToolkit().getScreenSize().width));
				}
			}
			for(int i=0;i<feiji3Y.length;i++){//小飞机下落
				feiji3Y[i]=feiji3Y[i]+35;
				if(feiji3Y[i]>1080){
					
					feiji3Y[i]=(int)(Math.random()* 1000)-1500;
				    feiji3X[i]=(int)(Math.random()* (Toolkit.getDefaultToolkit().getScreenSize().width));
                }
				}
			
			for(int i =0;i<zidans.size();i++){//判断是否击中小飞机以及动作
				zidan zd=zidans.get(i);
				for(int a=0;a<feiji3Y.length;a++){
					if(-20<zd.getZidanx()-feiji3X[a]&&zd.getZidany()-feiji3Y[a]<20
							&&zd.getZidany()-feiji3Y[a]>-20 &&60>zd.getZidanx()-feiji3X[a]){
						score+=5;
						zidans.remove(i);
						feiji3Y[a]=(int)(Math.random()* 1000)-1500;
					    feiji3X[a]=(int)(Math.random()* (Toolkit.getDefaultToolkit().getScreenSize().width));
						break;
						
				}}
			}
			for(int i =0;i<zidans.size();i++){//判断是否击中大飞机以及动作
				zidan zd=zidans.get(i);
				for(int a=0;a<feiji1Y.length;a++){
					if(-20<zd.getZidanx()-feiji1X[a]&&zd.getZidany()-feiji1Y[a]<70
							&&zd.getZidany()-feiji1Y[a]>-20 &&80>zd.getZidanx()-feiji1X[a]){
						score+=20;
						zidans.remove(i);
						feiji1Y[a]=(int)(Math.random()* 1000)-2500;
						feiji1X[a]=(int)(Math.random()* (Toolkit.getDefaultToolkit().getScreenSize().width));
                        break;
						
				}}
			}
			for(int i =0;i<zidans.size();i++){//判断是否击中中飞机以及动作
				zidan zd=zidans.get(i);
				for(int a=0;a<feiji2Y.length;a++){
					if(-20<zd.getZidanx()-feiji2X[a]&&zd.getZidany()-feiji2Y[a]<50
							&&zd.getZidany()-feiji2Y[a]>-20 &&70>zd.getZidanx()-feiji2X[a]){
						score+=10;
						zidans.remove(i);
						feiji2Y[a]=(int)(Math.random()* 1000)-2000;
						feiji2X[a]=(int)(Math.random()* (Toolkit.getDefaultToolkit().getScreenSize().width));
						break;
						
				}}
			}
			for(int a=0;a<feiji2Y.length;a++){//中战机撞上敌机后果
				if(-20<x-feiji2X[a]&&y-feiji2Y[a]<50
						&&y-feiji2Y[a]>-20 &&70>x-feiji2X[a]){
					score-=100;
				    d--;
					feiji2Y[a]=(int)(Math.random()* 1000)-2000;
					feiji2X[a]=(int)(Math.random()* (Toolkit.getDefaultToolkit().getScreenSize().width));
					break;
					
			}}
			for(int a=0;a<feiji3Y.length;a++){//小战机撞上敌机后果
				if(-20<x-feiji3X[a]&&y-feiji3Y[a]<50
						&&y-feiji3Y[a]>-20 &&70>x-feiji3X[a]){
					score-=100;
				    d--;
				    feiji3Y[a]=(int)(Math.random()* 1000)-1500;
				    feiji3X[a]=(int)(Math.random()* (Toolkit.getDefaultToolkit().getScreenSize().width));
					break;
					
			}}
			for(int a=0;a<feiji1Y.length;a++){//大战机撞上敌机后果
				if(-20<x-feiji1X[a]&&y-feiji1Y[a]<50
						&&y-feiji1Y[a]>-20 &&70>x-feiji1X[a]){
					score-=100;
				    d--;
				    feiji1Y[a]=(int)(Math.random()* 1000)-2500;
					feiji1X[a]=(int)(Math.random()* (Toolkit.getDefaultToolkit().getScreenSize().width));
                    break;
					
			}}
			try {
				Thread.sleep(45);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			repaint();
			
		}
	}
	
}
class zidan{//子弹类
	int zidanx,zidany;

	public int getZidanx() {
		return zidanx;
	}

	public void setZidanx(int zidanx) {
		this.zidanx = zidanx;
	}

	public int getZidany() {
		return zidany;
	}

	public void setZidany(int zidany) {
		this.zidany = zidany;
	}
}