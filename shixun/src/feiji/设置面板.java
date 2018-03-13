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

public class …Ë÷√√Ê∞Â extends  JPanel implements ActionListener {
	     static int ƒ—∂»=3;
	     static  int “Ù¿÷;
	     static  int ª¡¶=2;
	     static  int ±≥æ∞=0;
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
	     …Ë÷√√Ê∞Â(){
	    	  GridLayout a=new GridLayout(4,3);
	    	  this.setBackground(Color.ORANGE);
	    	  this.setLayout(a);
	    	  Font d=new Font("",Font.BOLD,22);
	    	 JLabel nan=new JLabel("ƒ—∂»");
	    	 nan.setFont(d);
	    	 JLabel “Ù¿÷=new JLabel("“Ù¿÷");
	    	 “Ù¿÷.setFont(d);
	    	 JLabel huoli=new JLabel("ª¡¶");
	    	 huoli.setFont(d);
	    	 JLabel ±≥æ∞=new JLabel("±≥æ∞");
	    	 ±≥æ∞.setFont(d);
	    	 ButtonGroup p=new ButtonGroup();
	    	 da=new JRadioButton("¥Û");
	    	 da.addActionListener(this);
	    	 jiaohao=new JRadioButton("÷–");
	    	 jiaohao.addActionListener(this);
	    	  xiao=new JRadioButton("–°");
	    	  jiaohao.setSelected(true);
	    	  xiao.addActionListener(this);//JRadioButtoªµ ¬
	    	 p.add(da);p.add(jiaohao);p.add(xiao);
	    	 this.add(huoli); this.add(da); this.add(jiaohao); this.add(xiao);
	        ButtonGroup s=new ButtonGroup();
	    	  gao=new JRadioButton("∏ﬂ");
	    	 gao.addActionListener(this);
	    	  zhong=new JRadioButton("÷–");
	    	 zhong.addActionListener(this);
	    	  di=new JRadioButton("µÕ");
	    	  di.setSelected(true);
	    	 di.addActionListener(this);//JRadioButtoªµ ¬
	    	 s.add(gao);s.add(zhong);s.add(di);
	    	 this.add(nan); this.add(gao); this.add(zhong); this.add(di);
	    	 ButtonGroup e=new ButtonGroup();
	    	  a1=new JRadioButton("“Ù¿÷1");
	    	  a1.setSelected(true);
	    	 a1.addActionListener(this);
	    	  a2=new JRadioButton("“Ù¿÷2");
	    	  a2.addActionListener(this);
	    	  a3=new JRadioButton("“Ù¿÷3");
	    	  a3.addActionListener(this);
	    	 e.add(a1);e.add(a2);e.add(a3);
	    	 this.add(“Ù¿÷); this.add(a1);this.add(a2);this.add(a3);
	    	 ButtonGroup o=new ButtonGroup();
	    	  be1=new JRadioButton("…Ω¥®");
	    	  be1.setSelected(true);
	    	  be1.addActionListener(this);
	    	  be2=new JRadioButton("–«ø’");
	    	  be2.addActionListener(this);
	    	  be3=new JRadioButton("∫£±ﬂ");
	    	  be3.addActionListener(this);
	    	  o.add(be1);o.add(be2);o.add(be3);
	    	 this.add(±≥æ∞); this.add(be1);this.add(be2);this.add(be3);	  
	     }
	     public void actionPerformed(ActionEvent e){
	    	 if(e.getSource()==gao){
	    	  ƒ—∂»=6;
	    	 }
	    	 if(e.getSource()==zhong){
	   		  ƒ—∂»=4;
	   	   } if(e.getSource()==di){
			  ƒ—∂»=3;
		    }
	   	    if(e.getSource()==a1){
	   	    	“Ù¿÷=1;
	   	    }if(e.getSource()==a2){
	   	    	“Ù¿÷=2;
	   	    }if(e.getSource()==a3){
	   	    	“Ù¿÷=3;
	   	    }
	   	      if(e.getSource()==da){
	   	    	ª¡¶=1;
	   	    }if(e.getSource()==jiaohao){
	   	    	ª¡¶=2;
	   	    }if(e.getSource()==xiao){
	   	    	ª¡¶=3;
	   	    }
	        
	      if(e.getSource()==be1){
	    	±≥æ∞=0;
	    }if(e.getSource()==be2){
	    	
	    	±≥æ∞=1;
	    }if(e.getSource()==be3){
	    	
	    	±≥æ∞=2;
	    }
  }
}
