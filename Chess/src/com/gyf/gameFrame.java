package com.gyf;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;



public class gameFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1626493072817436258L;
	public JPanel panel_1,panel_2;
	public JButton[] mapButton=new JButton[400];
	public JButton roll;
	public JButton attack;
	public JButton north;
	public JButton east;
	public JButton south;
	public JButton west;
	public JButton servantConfirm;
	public boolean isRoll=false;
	public boolean isAttack=false;
	public boolean isNorth=false;
	public boolean isEast=false;
	public boolean isSouth=false;
	public boolean isWest=false;
	public boolean isServantConfirm=false;
	public static Icon icon_act1 = new ImageIcon("image/act1.png");
	public static Icon icon_background = new ImageIcon("image/background.png");
	JLabel label = new JLabel(icon_background);// �ѱ���ͼƬ��ʾ��һ����ǩ����
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
		JComboBox<String> jc1 = new JComboBox<>(new MyComboBox());
		JComboBox<String> jc2 = new JComboBox<>(new MyComboBox());
		jc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jc1.getSelectedItem()=="����") {
					p1choice=1;
				}
				else if(jc1.getSelectedItem()=="����������") {
					p1choice=2;
				}
				else if(jc1.getSelectedItem()=="��������˹") {
					p1choice=3;
				}
				else if(jc1.getSelectedItem()=="����٤��ʲ") {
					p1choice=4;
				}
				else if(jc1.getSelectedItem()=="������") {
					p1choice=5;
				}
				else{
					p1choice=6;
				}
				System.out.println("���1ѡ���ˡ�"+jc1.getSelectedItem()+"��");
				Sound.selected(p1choice);//����selected����
			}
		});
		jc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jc2.getSelectedItem()=="����") {
					p2choice=1;
				}
				else if(jc2.getSelectedItem()=="����������") {
					p2choice=2;
				}
				else if(jc2.getSelectedItem()=="��������˹") {
					p2choice=3;
				}
				else if(jc2.getSelectedItem()=="����٤��ʲ") {
					p2choice=4;
				}
				else if(jc2.getSelectedItem()=="������") {
					p2choice=5;
				}
				else{
					p2choice=6;
				}
				System.out.println("���2ѡ���ˡ�"+jc2.getSelectedItem()+"��");
				Sound.selected(p2choice);//����selected����
			}
		});
		servantConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isServantConfirm=true;
			}
		});
		setBounds(400,200,800,500);//���ô���λ�ã�����Ϊx,y,width,height
		setVisible(true);
		setTitle("��ɫѡ��");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//ʹ�þ��Բ���
		c.setLayout(null);
		//���������λ�ã�����Ϊx,y,width,height
		jl1.setBounds(300, 200, 100, 30);
		jc1.setBounds(400, 200, 100, 30);
		jl2.setBounds(300, 250, 100, 30);
		jc2.setBounds(400, 250, 100, 30);
		servantConfirm.setBounds(300, 350, 200, 30);
		//������
		c.add(jl1);
		c.add(jc1);
		c.add(jl2);
		c.add(jc2);
		c.add(servantConfirm);
		//�ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		//�����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
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
		setBounds(400,50,1100,700);//���ô���λ�ã�����Ϊx,y,width,height
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		JPanel p1=new JPanel(new GridLayout(20,20,0,0));//���1=��ͼ��
		JPanel p2=new JPanel(new GridLayout(2,3,0,0));//���2=������
		c.setLayout(null);
		//�������λ�ã�����Ϊx,y,width,height
		p1.setBounds(30,30,700,600);
		p2.setBounds(800,500,150,100);
		for(int i=0;i<400;i++) {
			mapButton[i]=new JButton();
			p1.add(mapButton[i]);//����ť��ӵ����1
		}
		roll=new JButton();
		attack=new JButton();
		north=new JButton("W");
		east=new JButton("D");
		south=new JButton("S");
		west=new JButton("A");
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
		roll.setIcon(resizeIcon(new ImageIcon("image/roll.png")));
		attack.setIcon(resizeIcon(new ImageIcon("image/attack.png")));
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
		c.add(p1);
		c.add(p2);
		setTitle("��Ϸ����");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}


	private Image getImage(Icon icon_roll2) {
		// TODO �Զ����ɵķ������
		return null;
	}


	/*
	 * ˢ����Ϸ���棬��gf�ڸ��µ�ǰ���nowply����myMap��ˢ�µ�ͼ��ť����
	 */
	public void refrFrame(Player now,Player p1, Player p2, Map m) {
		for(int i=0;i<400;i++) {
			m.terrain[i]=m.MAP_1[i];
		}
		int x1=p1.getPositionX();
		int y1=p1.getPositionY();
		int num1=Map.getNum(x1, y1);//��ð�ť���
		m.terrain[num1]=(p1.name);//�ڵ�ͼ��ť�����ϸ���p1λ��
		int x2=p2.getPositionX();
		int y2=p2.getPositionY();
		int num2=Map.getNum(x2, y2);//��ð�ť���
		m.terrain[num2]=(p2.name);//�ڵ�ͼ��ť�����ϸ���p2λ��
		for(int i=0;i<400;i++) {
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
				mapButton[i].setBackground(Color.RED);
				setServantIcon(mapButton[i],p2);
			}
		}
		//�ȴ���ӣ���ǰ���now�ķ����ӵ�ж����ʶ
	}

	/*
	 * ����������ҵĴ���ͼ��
	 */
	private void setServantIcon(JButton a,Player pla) {
		if(pla.servant==1) {

		}else if(pla.servant==2) {
			a.setIcon(icon_act1);
		}else if(pla.servant==3) {

		}else if(pla.servant==4) {

		}else if(pla.servant==5) {

		}else if(pla.servant==6) {

		}

		//������


	}
	
	/*
	 * ����ͼ���С
	 */
	private ImageIcon resizeIcon(ImageIcon icon) {
		Image img = icon.getImage(); 
		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB); 
		Graphics g = bi.createGraphics(); 
		g.drawImage(img, 10, 10, 60, 60, null); 
		ImageIcon newicon = new ImageIcon(bi);
		return newicon;
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

