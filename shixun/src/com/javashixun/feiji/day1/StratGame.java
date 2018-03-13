package com.javashixun.feiji.day1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//游戏启动界面
public class StratGame extends JFrame implements ActionListener{
	JButton b1,b2;
	JFrame jf;
	JPanel jp;
	JLabel r;
	public  StratGame(){
		jf= new JFrame();
		jf.setTitle("飞机大战");
		jp=(JPanel)this.getContentPane();
		
		jf.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		jf.setBounds(dim.width/2-300, dim.height/2-200, 600, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(3);
		r=new JLabel();
		b1 = new JButton();
		b2 = new JButton();
		b1.setBounds(250, 260,105, 35);
		b2.setBounds(250, 310,105, 35);
		r.setBounds(0, -20, 600, 400);
		
		URL imgURL1 = StratGame.class.getResource("background.jpg");
		URL imgURL2 = StratGame.class.getResource("StartGame.jpg");
		URL imgURL3 = StratGame.class.getResource("QuateGame.jpg");

         ImageIcon img1 = new ImageIcon(imgURL1);
         ImageIcon img2 = new ImageIcon(imgURL2);
         ImageIcon img3 = new ImageIcon(imgURL3);
		//背景图片的设置
         
		b1.setIcon(img2);
		b2.setIcon(img3);
		jf.getContentPane().add(b1);
		jf.getContentPane().add(b2);
		jf.getContentPane().add(r);
		
		 b1.setBorderPainted(false);
		 b2.setBorderPainted(false);
		 
		 
		 r.setIcon(img1);
		 r.setHorizontalAlignment(JLabel.CENTER);
		 
		 
		b1.addActionListener(this);
		b2.addActionListener(this);
		 
		

	}
	
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1){
			new Start();
		}else if(e.getSource()==b2){
			System.exit(0);
		}
	}

}
