package feiji;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ������ extends  JFrame implements ActionListener{
	JLabel r;
	JButton b1=new JButton();
	JButton b2=new JButton();
	JButton b3=new JButton();
	��Ϸ��� a ;
	 ������� h;
	 Font s=new Font("",Font.BOLD,22);
	JButton b4=new JButton("�ص����˵�");
	
	������(String c){
		this.setTitle(c);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.setIcon(new ImageIcon("3.jpg"));
		b2.setIcon(new ImageIcon("4.jpg"));
		b3.setIcon(new ImageIcon("2.jpg"));
		this.getContentPane().add(b1);
		this.getContentPane().add(b2);
		this.getContentPane().add(b3);
		b1.setBorderPainted(false);
		b2.setBorderPainted(false);
		b3.setBorderPainted(false);
		b1.setBounds(180, 250, 115, 35);
		b2.setBounds(180, 300, 115, 35);
		b3.setBounds(320, 270, 115, 35);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
         b3.addActionListener(this);
		this.setBounds(500,200,510,400);
	     r=new JLabel();
		r.setIcon(new ImageIcon("��ʼ.jpg"));
		r.setHorizontalAlignment(JLabel.CENTER);
		r.setBounds(0, -20, 500, 400);
		this.getContentPane().add(r);
		this.setVisible(true);
    }
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource()==b1){
			 this.getContentPane().removeAll();
				this.setLayout(new BorderLayout());
				a=new ��Ϸ���(�������.����,�������.�Ѷ�,�������.����);
				this.getContentPane().add(a);
				Thread th=new Thread(a);
				th.start();
				this.addKeyListener(a);
				this.getContentPane().validate();
              
				
		 }
		 if(e.getSource()==b2){
					 this.getContentPane().removeAll();
					 this.setLayout(null);
					 h=new �������();
					 this.getContentPane().add(h);
					 h.setBounds(0, 0, 510, 300);
					 this.add(b4);
						b4.setFont(s);
					    b4.setBackground(Color.RED);
						b4.addActionListener(this);
						b4.setBounds(0, 300, 510, 100);
						
						 }
		 if(e.getSource()==b3){
			 System.exit(0);
		 }if(e.getSource()==b4){
			 this.getContentPane().removeAll();
			 this.setVisible(false);
			 ������ g=new ������("�ɻ�"); 
			
			}}
	 
				
	 
	 public static void main (String[] args){
		������ e=new ������("�ɻ�"); 
		
	 }
}
