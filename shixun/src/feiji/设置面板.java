package feiji;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ������� extends  JPanel implements ActionListener {
	     static int �Ѷ�=3;
	     static  int ����;
	     static  int ����=2;
	     static  int ����=0;
	     JRadioButton gao;
	     JRadioButton zhong;
	     JRadioButton di;
	     JRadioButton a1;
	     JRadioButton a2;
	     JRadioButton a3;
	     JRadioButton  da;
	     JRadioButton  jiaohao;
	     JRadioButton  xiao;
	     JRadioButton  be1;
	     JRadioButton  be2;
	     JRadioButton  be3;
	     �������(){
	    	  GridLayout a=new GridLayout(4,3);
	    	  this.setBackground(Color.ORANGE);
	    	  this.setLayout(a);
	    	  Font d=new Font("",Font.BOLD,22);
	    	 JLabel nan=new JLabel("�Ѷ�");
	    	 nan.setFont(d);
	    	 JLabel ����=new JLabel("����");
	    	 ����.setFont(d);
	    	 JLabel huoli=new JLabel("����");
	    	 huoli.setFont(d);
	    	 JLabel ����=new JLabel("����");
	    	 ����.setFont(d);
	    	 ButtonGroup p=new ButtonGroup();
	    	 da=new JRadioButton("��");
	    	 da.addActionListener(this);
	    	 jiaohao=new JRadioButton("��");
	    	 jiaohao.addActionListener(this);
	    	  xiao=new JRadioButton("С");
	    	  jiaohao.setSelected(true);
	    	  xiao.addActionListener(this);//JRadioButto����
	    	 p.add(da);p.add(jiaohao);p.add(xiao);
	    	 this.add(huoli); this.add(da); this.add(jiaohao); this.add(xiao);
	        ButtonGroup s=new ButtonGroup();
	    	  gao=new JRadioButton("��");
	    	 gao.addActionListener(this);
	    	  zhong=new JRadioButton("��");
	    	 zhong.addActionListener(this);
	    	  di=new JRadioButton("��");
	    	  di.setSelected(true);
	    	 di.addActionListener(this);//JRadioButto����
	    	 s.add(gao);s.add(zhong);s.add(di);
	    	 this.add(nan); this.add(gao); this.add(zhong); this.add(di);
	    	 ButtonGroup e=new ButtonGroup();
	    	  a1=new JRadioButton("����1");
	    	  a1.setSelected(true);
	    	 a1.addActionListener(this);
	    	  a2=new JRadioButton("����2");
	    	  a2.addActionListener(this);
	    	  a3=new JRadioButton("����3");
	    	  a3.addActionListener(this);
	    	 e.add(a1);e.add(a2);e.add(a3);
	    	 this.add(����); this.add(a1);this.add(a2);this.add(a3);
	    	 ButtonGroup o=new ButtonGroup();
	    	  be1=new JRadioButton("ɽ��");
	    	  be1.setSelected(true);
	    	  be1.addActionListener(this);
	    	  be2=new JRadioButton("�ǿ�");
	    	  be2.addActionListener(this);
	    	  be3=new JRadioButton("����");
	    	  be3.addActionListener(this);
	    	  o.add(be1);o.add(be2);o.add(be3);
	    	 this.add(����); this.add(be1);this.add(be2);this.add(be3);	  
	     }
	     public void actionPerformed(ActionEvent e){
	    	 if(e.getSource()==gao){
	    	  �Ѷ�=6;
	    	 }
	    	 if(e.getSource()==zhong){
	   		  �Ѷ�=4;
	   	   } if(e.getSource()==di){
			  �Ѷ�=3;
		    }
	   	    if(e.getSource()==a1){
	   	    	����=1;
	   	    }if(e.getSource()==a2){
	   	    	����=2;
	   	    }if(e.getSource()==a3){
	   	    	����=3;
	   	    }
	   	      if(e.getSource()==da){
	   	    	����=1;
	   	    }if(e.getSource()==jiaohao){
	   	    	����=2;
	   	    }if(e.getSource()==xiao){
	   	    	����=3;
	   	    }
	        
	      if(e.getSource()==be1){
	    	����=0;
	    }if(e.getSource()==be2){
	    	
	    	����=1;
	    }if(e.getSource()==be3){
	    	
	    	����=2;
	    }
  }
}
