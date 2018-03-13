package shixun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame implements ActionListener{
	
	JPanel contenpane;
	
	JLabel label1=new JLabel("�˿ں�");
	JLabel label2=new JLabel("��������Ϣ");
	
	JTextField text1=new JTextField();
	JTextField text2=new JTextField();
	
	JButton button1=new JButton("����");
	JButton button2=new JButton("����");
	JButton button3=new JButton("����");
	
	JTextArea textarea1=new JTextArea();
	JScrollPane jscrollpane=new JScrollPane();
	//��������е�����
	int[][] allChess=new int[19][19];
	//ͨ��
	ServerSocket server=null;
	Socket server1=null;
	BufferedReader instr=null;
	PrintWriter os=null;
	//��Ŵ��͵���Ϣ
	String[] ss=new String[10];
	//�ж��Ƿ�������
	boolean canPlay=true;
	//������ӵ�λ��
	int x=0;
	int y=0;
	//��ʾ��Ϣ
	String message=null;
	JPanel panel2=null;
	//���췽��
	public Server(){
		//���ô���
		contenpane=(JPanel)this.getContentPane();
		InetAddress ip=null;
		try {
			ip=InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTitle("������"+"/"+ip);
		this.setBounds(20, 20, 600, 750);
		//���ÿ��ϵ��������
		JPanel panel1=new JPanel();
		panel1.setLayout(null);
		label1.setBounds(new Rectangle(20,5,50,22));
		label1.setFont(new Font("����",0,14));
		text1.setBounds(new Rectangle(75,5,50,22));
		text1.setText("4321");
		
		button1.setBounds(new Rectangle(125,5,100,22));
		button1.setFont(new Font("����",0,14));
		
		label2.setBounds(new Rectangle(225,5,70,22));
		label2.setFont(new Font("����",0,14));
		
		text2.setBounds(new Rectangle(295,5,100,22));
		text2.setText("��������Ϣ");
		
		button2.setBounds(new Rectangle(395,5,70,22));
		button2.setFont(new Font("����",0,14));
		
		button3.setBounds(new Rectangle(470,5,70,22));
		button3.setFont(new Font("����",0,14));
		
		
		jscrollpane.setBounds(new Rectangle(5,30,520,100));
		
		textarea1.setText("��������");
		jscrollpane.getViewport().add(textarea1);
		
		panel1.add(label1);
		panel1.add(text1);
		panel1.add(button1);
		panel1.add(label2);
		panel1.add(text2);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(jscrollpane);
		contenpane.setLayout(null);
		panel1.setBounds(new Rectangle(0,0,600,130));
		contenpane.add(panel1);
		
		panel2=new QipanPane();
		panel2.setBounds(10, 140, 540, 460);
		contenpane.add(panel2);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				try {
					sendData("quit|");
					server.close();
					server1.close();
					instr.close();
					os.close();
					System.exit(0);;
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	//�����ڲ����������������
	class QipanPane extends JPanel{
		BufferedImage bi=null;//���̱���ͼƬ
		QipanPane(){
			this.addMouseListener(new MousLis());
			String imagepath="001.jpg";
			URL image=this.getClass().getResource(imagepath);
			try {
				bi=ImageIO.read(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��дpaintComponent����д����
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			
			//˫���弼��
			BufferedImage bImage=new BufferedImage(500,500,BufferedImage.TYPE_INT_RGB);
			Graphics g1=bImage.createGraphics();
			
			g1.setColor(Color.BLACK);
			//������ͼƬ�����������
			g1.drawImage(bi, 0, 0, this);
			//���Ʊ�����Ϣ
			g1.setFont(new Font("����",Font.BOLD,14));
			g1.drawString("��Ϸ��Ϣ:"+message, 130, 60);
			//��������
			for(int i=0;i<19;i++){
				g1.drawLine(10, 70+20*i, 10+18*20, 70+20*i);
				g1.drawLine(10+20*i, 70, 10+20*i, 70+18*20);
			}
			//����׼��
			g1.fillOval(68, 128, 6, 6);
			g1.fillOval(188, 128, 6, 6);
			g1.fillOval(308, 128, 6, 6);
			g1.fillOval(188, 248, 6, 6);
			g1.fillOval(188, 368, 6, 6);
			g1.fillOval(68, 248, 6, 6);
			g1.fillOval(68, 368, 6, 6);
			g1.fillOval(308, 248, 6, 6);
			g1.fillOval(308, 368, 6, 6);
			//����ȫ������
			for(int i=0;i<19;i++)
				for(int j=0;j<19;j++){
					if(allChess[i][j]==1){
						int tempX=10+20*i;
						int tempY=70+20*j;
						g1.setColor(Color.BLACK);
						g1.fillOval(tempX-7, tempY-7, 14, 14);
					}else if(allChess[i][j]==2){
						int tempX=10+20*i;
						int tempY=70+20*j;
						g1.setColor(Color.WHITE);
						g1.fillOval(tempX-7, tempY-7, 14, 14);
						g1.setColor(Color.BLACK);
						g1.drawOval(tempX-7, tempY-7, 14, 14);
					}
						
				}
			
		g.drawImage(bImage, 0, 0, this);	
		}
	}
	class MousLis extends MouseAdapter{
		
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		if(canPlay==true){	
			int x1=e.getX();
			int y1=e.getY();
			if(x1>=10&&x1<=370&&y1>=70&&y1<=430){
				x=x1/20;
				y=(y1-60)/20;
				if(allChess[x][y]==0){
					allChess[x][y]=1;
					canPlay=false;
					message="�Է����ӣ�";
					sendData("move|"+String.valueOf(x)+"|"+String.valueOf(y));
					repaint();
					if(checkWin()){
						message="��Ϸ�������ڷ���ʤ��";
						sendData("over|"+message);
						JOptionPane.showMessageDialog(null, message);
						canPlay=false;
						
					}
				}else{
					JOptionPane.showMessageDialog(null, "�˴��Ѿ��������ˣ���");
				}
		}
		}else{
			JOptionPane.showMessageDialog(null, "�ֵ��Է����ӣ�");
		}
			
		}

		
	}
	//��������
	private void listenClient(final int port){
		if(button1.getText().trim().equals("����")){
			new Thread(new Runnable(){
				public void run(){
			try {
				server=new ServerSocket(port);
				button1.setText("������������");
				server1=server.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sendData("�Ѿ��ɹ�����");
			button1.setText("��������");
			textarea1.append("�ͻ����Ѿ����ӵ�������");
			message="�Լ��Ǻڷ�����";
			panel2.repaint();
			MyThread t=new MyThread();
			t.start();
			}
			}).start();
	}
	}
	//������Ϣ
	private void sendData(String s) {
		// TODO Auto-generated method stub
		try {
			os=new PrintWriter(server1.getOutputStream());
			os.println(s);
			os.flush();
			if(!s.startsWith("chat")){
			textarea1.append("�������ˣ�"+s+"\n");}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//������Ϣ
	class MyThread extends Thread{
		public void run(){
			try {
				while(true){
					
				this.sleep(100);
					instr=new BufferedReader(new InputStreamReader(server1.getInputStream()));
				if(instr.ready()){String cmd=instr.readLine();
				ss=cmd.split("\\|");
				//�����ƶ�����Ϣ
				if(cmd.startsWith("move")){
					x=Integer.parseInt(ss[1]);
					y=Integer.parseInt(ss[2]);
					allChess[x][y]=2;//��ͻ��˵İ���
					message="�ֵ��Լ�����";
					canPlay=true;
					textarea1.append("�ͻ��ˣ�"+cmd+"\n");
					panel2.repaint();
				}
				//������Ϣ
				if(cmd.startsWith("undo")){
					allChess[x][y]=0;
					message="�Է�����";
					canPlay=false;
					panel2.repaint();
				}
				//��Ϸ������Ϣ
				if(cmd.startsWith("over")){
					JOptionPane.showMessageDialog(null, "��Ϸ�������Է���ʤ��");
					canPlay=false;
				}
				//�Է��뿪��Ϣ
				if(cmd.startsWith("quit")){
					JOptionPane.showMessageDialog(null, "��Ϸ�������Է��뿪�ˣ�");	
					canPlay=false;
				}
				//������Ϣ
				if(cmd.startsWith("chat")){
					textarea1.append("�ͻ���˵��"+ss[1]+"\n");
				}
				
			}
				}}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//����
		if(e.getSource()==button1){
			int port=Integer.parseInt(text1.getText().trim());
			listenClient(port);
			System.out.println("��������");
		}
		//����������Ϣ
		if(e.getSource()==button2){
			String str=text2.getText();
			sendData("chat|"+str);
			textarea1.append("��������˵��"+str+"\n");
		}
		//����
		if(e.getSource()==button3){
			if(canPlay!=true){
			allChess[x][y]=0;
			canPlay=true;
			message="�ֵ��Լ�����";
			sendData("undo|"+String.valueOf(x)+"|"+String.valueOf(y));
			repaint();
			}else {
				JOptionPane.showMessageDialog(this, "�Է������壬���ܻ��壡");
			}
			
		}
	}
	private boolean checkWin(){
		boolean Flag=false;
		int count=1;
		int color=allChess[x][y];
		//�жϺ����Ƿ���5�������������ص�����������ͬ
		int i=1;
		while(allChess[x+i][y+0]==color){
				i++;
				count++;
			}
		 i=1;
		while(allChess[x-i][y-0]==color){
			i++;
			count++;
		}
		if(count>=5){
			Flag=true;
		}
		//�ж������Ƿ���5�������������ص��Ǻ�������ͬ
		int i2=1;
		int count2=1;
		while(allChess[x+0][y+i2]==color){
				i2++;
				count2++;
			}
		 i2=1;
		while(allChess[x-0][y-i2]==color){
			i2++;
			count2++;
		}
		if(count2>=5){
			Flag=true;
		}
		//�ж�б��������+���£�
		int i3=1;
		int count3=1;
		while(allChess[x-i3][y-i3]==color){
				i3++;
				count3++;
			}
		 i3=1;
		while(allChess[x+i3][y+i3]==color){
			i3++;
			count3++;
		}
		if(count3>=5){
			Flag=true;
		}
		//�ж�б��������+���ϣ�
		int i4=1;
		int count4=1;
		while(allChess[x-i4][y+i4]==color){
				i4++;
				count4++;
			}
		 i4=1;
		while(allChess[x+i4][y-i4]==color){
			i4++;
			count4++;
		}
		if(count4>=5){
			Flag=true;
		}
		return Flag;
		
	}
	
}
