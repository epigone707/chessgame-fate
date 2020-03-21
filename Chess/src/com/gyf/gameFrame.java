package com.gyf;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class gameFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1626493072817436258L;
	public JPanel panel_1,panel_2;
	public JButton[] mapButton=new JButton[40];
	public JButton roll;
	public JButton attack;
	public JButton north;
	public JButton east;
	public JButton south;
	public JButton west;
	public JButton servantConfirm;
	public Player nowply;
	public boolean isRoll=false;
	public boolean isAttack=false;
	public boolean isNorth=false;
	public boolean isEast=false;
	public boolean isSouth=false;
	public boolean isWest=false;
	public boolean isServantConfirm=false;
	public static Icon iconroll = new ImageIcon("image/roll.png");
	public static Icon iconattack = new ImageIcon("image/attack.png");
	public static Icon iconact1 = new ImageIcon("image/act1.png");
	public static Icon iconbackground = new ImageIcon("image/background.png");
	JLabel label = new JLabel(iconbackground);// �ѱ���ͼƬ��ʾ��һ����ǩ����
	JComboBox<String> jc1 = new JComboBox<>(new MyComboBox());
	JComboBox<String> jc2 = new JComboBox<>(new MyComboBox());
	public int p1choice=1;
	public int p2choice=2;
	



	/*
	 * ���췽��
	 */
	public gameFrame() {
		Sound.backgroud_1();// ���ű�������1
		gameSetPane();//�������ѡ�����
		while(true) {
			if(isServantConfirm) {
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		getContentPane().removeAll();
		//repaint(); 
		invalidate(); // Changed here
		gamePlayPane();//������Ϸ����
        Sound.bg_1.stop();//ֹͣ���ű�������1
        Sound.backgroud_2();//���ű�������2
	}

	
	/*
	 * ����ѡ�����
	 */
	public void gameSetPane() {
		Container c=getContentPane();
		JLabel jl1 = new JLabel("���1��ѡ�����:");
		JLabel jl2 = new JLabel("���2��ѡ�����:");
		servantConfirm=new JButton("ȷ�ϴ���ѡ��");
		jc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jc1.getSelectedItem()=="����") {
	    			System.out.println("���1ѡ���ˡ�������");
	    			Sound.selected(1);//����selected����
	    			p1choice=1;
	    		}
	    		else if(jc1.getSelectedItem()=="����������") {
	    			System.out.println("���1ѡ���ˡ����������š�");
	    			Sound.selected(2);//����selected����
	    			p1choice=2;
	    		}
	    		else if(jc1.getSelectedItem()=="��������˹") {
	    			System.out.println("���1ѡ���ˡ���������˹��");
	    			Sound.selected(3);//����selected����
	    			p1choice=3;
	    		}
	    		else if(jc1.getSelectedItem()=="����٤��ʲ") {
	    			System.out.println("���1ѡ���ˡ�����٤��ʲ��");
	    			Sound.selected(4);//����selected����
	    			p1choice=4;
	    		}
	    		else if(jc1.getSelectedItem()=="������") {
	    			System.out.println("���1ѡ���ˡ������֡�");
	    			Sound.selected(5);//����selected����
	    			p1choice=5;
	    		}
	    		else if(jc1.getSelectedItem()=="����ɯ") {
	    			System.out.println("���1ѡ���ˡ�����ɯ��");
	    			Sound.selected(6);//����selected����
	    			p1choice=6;
	    		}
			}
		});
		jc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jc2.getSelectedItem()=="����") {
	    			System.out.println("���2ѡ���ˡ�������");
	    			Sound.selected(1);//����selected����
	    			p2choice=1;
	    		}
	    		else if(jc2.getSelectedItem()=="����������") {
	    			System.out.println("���2ѡ���ˡ����������š�");
	    			Sound.selected(2);//����selected����
	    			p2choice=2;
	    		}
	    		else if(jc2.getSelectedItem()=="��������˹") {
	    			System.out.println("���2ѡ���ˡ���������˹��");
	    			Sound.selected(3);//����selected����
	    			p2choice=3;
	    		}
	    		else if(jc2.getSelectedItem()=="����٤��ʲ") {
	    			System.out.println("���2ѡ���ˡ�����٤��ʲ��");
	    			Sound.selected(4);//����selected����
	    			p2choice=4;
	    		}
	    		else if(jc2.getSelectedItem()=="������") {
	    			System.out.println("���2ѡ���ˡ������֡�");
	    			Sound.selected(5);//����selected����
	    			p2choice=5;
	    		}
	    		else if(jc2.getSelectedItem()=="����ɯ") {
	    			System.out.println("���2ѡ���ˡ�����ɯ��");
	    			Sound.selected(6);//����selected����
	    			p2choice=6;
	    		}
			}
		});
		servantConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isServantConfirm=true;
			}
		});
		setBounds(400,200,800,500);//����Ϊx,y,width,height
		setVisible(true);
		setTitle("��ɫѡ��");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		c.setLayout(null);
		jl1.setBounds(300, 200, 100, 30);//����Ϊx,y,width,height
		jc1.setBounds(400, 200, 100, 30);
		jl2.setBounds(300, 250, 100, 30);
		jc2.setBounds(400, 250, 100, 30);
		servantConfirm.setBounds(300, 350, 200, 30);
		c.add(jl1);
		c.add(jc1);
		c.add(jl2);
		c.add(jc2);
		c.add(servantConfirm);
		
		// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		JPanel imagePanel = (JPanel) this.getContentPane();
		//ʹ���ݴ���͸��
		imagePanel.setOpaque(false);
		// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
	}
	
	/*
	 * ��Ϸ����
	 */
	public void gamePlayPane() {
		Container c=getContentPane();
		setBounds(400,50,900,700);//����Ϊx,y,width,height
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		c.setLayout(new GridBagLayout());
		final GridBagConstraints gbc_1=new GridBagConstraints();//���1=��ͼ
		gbc_1.gridy=0;
		gbc_1.gridx=0;
		gbc_1.weightx=90;
		//gbc_1.fill=GridBagConstraints.BOTH;
		final GridBagConstraints gbc_2=new GridBagConstraints();//���2=������
		gbc_2.gridy=0;
		gbc_2.gridx=1;
		gbc_2.weightx=10;
		gbc_2.insets = new Insets(0, 5, 0, 0);
		gbc_2.fill=GridBagConstraints.BOTH;
		JPanel p1=new JPanel(new GridLayout(8,5,1,1));
		for(int i=0;i<40;i++) {
			mapButton[i]=new JButton(String.valueOf(i));
			mapButton[i].setPreferredSize(new Dimension(100, 100));//��ť�Ĵ�С
			p1.add(mapButton[i]);//����ť��ӵ����1
		}
		JPanel p2=new JPanel();
		roll=new JButton("roll");
		attack=new JButton("attack!");
		north=new JButton("���ƶ�");
		east=new JButton("���ƶ�");
		south=new JButton("�����ƶ�");
		west=new JButton("�����ƶ�");
		roll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isRoll=true;
			}
		});
		attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isAttack=true;
			}
		});
		north.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isNorth=true;
			}
		});
		east.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isEast=true;
			}
		});
		south.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isSouth=true;
			}
		});
		west.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isWest=true;
			}
		});
		p2.setLayout(new GridLayout(2,3,5,5));
		roll.setIcon(iconroll);
		attack.setIcon(iconattack);
		p2.add(roll);
		p2.add(north);
		p2.add(attack);
		p2.add(west);
		p2.add(south);
		p2.add(east);
		roll.setEnabled(false);
	    attack.setEnabled(false);
	    north.setEnabled(false);
	    east.setEnabled(false);
	    south.setEnabled(false);
	    west.setEnabled(false);
		c.add(p1,gbc_1);
		c.add(p2,gbc_2);
		setTitle("��Ϸ����");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	
	/*
	 * ˢ����Ϸ���棬��gf�ڸ��µ�ǰ���nowply����myMap��ˢ�µ�ͼ��ť����
	 */
	public void refrFrame(Player now,Player p1, Player p2, Map m) {
		if (m.chooseMap==1) {
			for(int i=0;i<40;i++) {
				m.terrain[i]=m.MAP_1[i];
			}
		}else if(m.chooseMap==2) {
			for(int i=0;i<40;i++) {
				m.terrain[i]=m.MAP_2[i];
			}
		}
		int x1=p1.getPositionX();
		int y1=p1.getPositionY();
		int num1=5*(y1-1)+x1-1;
		//System.out.println("x1:"+x1+"y1:"+y1+"num1"+num1);
		m.terrain[num1]=(p1.name);//�ڵ�ͼ��ť�����ϸ���p1λ��
		int x2=p2.getPositionX();
		int y2=p2.getPositionY();
		int num2=5*(y2-1)+x2-1;
		//System.out.println("x2:"+x2+"y2:"+y2+"num2"+num2);
		m.terrain[num2]=(p2.name);//�ڵ�ͼ��ť�����ϸ���p2λ��
		nowply=now; //��gf�ڸ��µ�ǰ���
		for(int i=0;i<40;i++) {
			if(m.terrain[i]==-1) {
				//��ɫΪ�ϰ���,-1
				mapButton[i].setIcon(null);
				mapButton[i].setBackground(Color.BLACK);
			}else if(m.terrain[i]==0) {
				//��ɫΪ���и�,0
				mapButton[i].setIcon(null);
				mapButton[i].setBackground(Color.WHITE);
			}else if(m.terrain[i]==1) {
				//��ɫΪp1,1
				mapButton[i].setBackground(Color.BLUE);
				setServantIcon(mapButton[i],p1);
			}else if(m.terrain[i]==2) {
				//��ɫΪp2,2
				setServantIcon(mapButton[i],p2);
				mapButton[i].setBackground(Color.RED);
			}
		}
	}
	
	/*
	 * ����������ҵĴ���ͼ��
	 */
	private void setServantIcon(JButton a,Player pla) {
		if(pla.servant==1) {
			
		}else if(pla.servant==2) {
			a.setIcon(iconact1);
		}else if(pla.servant==3) {
			
		}else if(pla.servant==4) {
			
		}else if(pla.servant==5) {
			
		}else if(pla.servant==6) {
			
		}
		
		//������
		
		
	}

}


class MyComboBox extends AbstractListModel<String> implements ComboBoxModel<String> {
	
	private static final long serialVersionUID = 1L;
	String selecteditem = null;
	String[] test = { "����", "����������","��������˹", "����٤��ʲ","������","����ɯ" };
	
	public String getElementAt(int index) {
		return test[index];
	}
	
	public int getSize() {
		return test.length;
	}
	
	public void setSelectedItem(Object item) {
		selecteditem = (String) item;
	}
	
	public Object getSelectedItem() {
		return selecteditem;
	}
	
	public int getIndex() {
		for (int i = 0; i < test.length; i++) {
			if (test[i].equals(getSelectedItem()))
				return i;
		}
		return 0;
	}
}

