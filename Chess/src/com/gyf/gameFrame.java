package com.gyf;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;



public class gameFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1626493072817436258L;
	public JPanel p1,p2;
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
	public static Icon iconroll = new ImageIcon(gameFrame.class.getResource("roll.png"));
	public static Icon iconattack = new ImageIcon(gameFrame.class.getResource("attack.png"));
	JComboBox<String> jc1 = new JComboBox<>(new MyComboBox());
	JComboBox<String> jc2 = new JComboBox<>(new MyComboBox());
	public int p1choice=1;
	public int p2choice=2;
	



	/*
	 * ���췽��
	 */
	public gameFrame() {
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
		//invalidate(); // Changed here
		gamePlayPane();//������Ϸ����
        repaint(); // 
	}

	
	/*
	 * ����ѡ�����
	 */
	public void gameSetPane() {
		Container c=getContentPane();
		setSize(new Dimension(800, 800));
		setVisible(true);
		setTitle("��ɫѡ��");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		c.setLayout(new FlowLayout());
		JLabel jl1 = new JLabel("���1��ѡ�����:");
		JLabel jl2 = new JLabel("���2��ѡ�����:");
		servantConfirm=new JButton("ȷ�ϴ���ѡ��");
		jc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jc1.getSelectedItem()=="����") {
	    			System.out.println("���1ѡ���ˡ�������");
	    			p1choice=1;
	    		}
	    		else if(jc1.getSelectedItem()=="����������") {
	    			System.out.println("���1ѡ���ˡ����������š�");
	    			p1choice=2;
	    		}
	    		else if(jc1.getSelectedItem()=="��������˹") {
	    			System.out.println("���1ѡ���ˡ���������˹��");
	    			p1choice=3;
	    		}
	    		else if(jc1.getSelectedItem()=="����٤��ʲ") {
	    			System.out.println("���1ѡ���ˡ�����٤��ʲ��");
	    			p1choice=4;
	    		}
	    		else if(jc1.getSelectedItem()=="������") {
	    			System.out.println("���1ѡ���ˡ������֡�");
	    			p1choice=5;
	    		}
	    		else if(jc1.getSelectedItem()=="����ɯ") {
	    			System.out.println("���1ѡ���ˡ�����ɯ��");
	    			p1choice=6;
	    		}
			}
		});
		jc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jc2.getSelectedItem()=="����") {
	    			System.out.println("���2ѡ���ˡ�������");
	    			p2choice=1;
	    		}
	    		else if(jc2.getSelectedItem()=="����������") {
	    			System.out.println("���2ѡ���ˡ����������š�");
	    			p2choice=2;
	    		}
	    		else if(jc2.getSelectedItem()=="��������˹") {
	    			System.out.println("���2ѡ���ˡ���������˹��");
	    			p2choice=3;
	    		}
	    		else if(jc2.getSelectedItem()=="����٤��ʲ") {
	    			System.out.println("���2ѡ���ˡ�����٤��ʲ��");
	    			p2choice=4;
	    		}
	    		else if(jc2.getSelectedItem()=="������") {
	    			System.out.println("���2ѡ���ˡ������֡�");
	    			p2choice=5;
	    		}
	    		else if(jc2.getSelectedItem()=="����ɯ") {
	    			System.out.println("���2ѡ���ˡ�����ɯ��");
	    			p2choice=6;
	    		}
			}
		});
		servantConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isServantConfirm=true;
			}
		});
		c.add(jl1);
		c.add(jc1);
		c.add(jl2);
		c.add(jc2);
		c.add(servantConfirm);
	}
	
	/*
	 * ��Ϸ����
	 */
	public void gamePlayPane() {
		Container c=getContentPane();
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
			p1.add(mapButton[i]);//����ť���ӵ����1
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
		setSize(800, 800);
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
				mapButton[i].setBackground(Color.BLACK);
			}else if(m.terrain[i]==0) {
				//��ɫΪ���и�,0
				mapButton[i].setBackground(Color.WHITE);
			}else if(m.terrain[i]==1) {
				//��ɫΪp1,1
				mapButton[i].setBackground(Color.BLUE);
				//jb[i].setIcon(image);
			}else if(m.terrain[i]==2) {
				//��ɫΪp2,2
				mapButton[i].setBackground(Color.RED);
			}
		}
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
