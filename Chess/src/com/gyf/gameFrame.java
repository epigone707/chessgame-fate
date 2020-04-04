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
	JLabel label = new JLabel(icon_background);// 把背景图片显示在一个标签里面
	public int p1choice=1;
	public int p2choice=2;




	/*
	 * 构造方法
	 */
	public gameFrame() {
		Sound.backgroud_1();// 播放背景音乐1
		gameSetPane();//进入从者选择界面
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
		gamePlayPane();//进入游戏界面
		Sound.bg_1.stop();//停止播放背景音乐1
		Sound.backgroud_2();//播放背景音乐2
	}


	/*
	 * 从者选择界面
	 */
	public void gameSetPane() {
		Container c=getContentPane();
		JLabel jl1 = new JLabel("玩家1请选择从者:");
		JLabel jl2 = new JLabel("玩家2请选择从者:");
		servantConfirm=new JButton("确认从者选择");
		JComboBox<String> jc1 = new JComboBox<>(new MyComboBox());
		JComboBox<String> jc2 = new JComboBox<>(new MyComboBox());
		jc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jc1.getSelectedItem()=="卫宫") {
					p1choice=1;
				}
				else if(jc1.getSelectedItem()=="阿尔托莉雅") {
					p1choice=2;
				}
				else if(jc1.getSelectedItem()=="赫拉克勒斯") {
					p1choice=3;
				}
				else if(jc1.getSelectedItem()=="吉尔伽美什") {
					p1choice=4;
				}
				else if(jc1.getSelectedItem()=="库丘林") {
					p1choice=5;
				}
				else{
					p1choice=6;
				}
				System.out.println("玩家1选择了【"+jc1.getSelectedItem()+"】");
				Sound.selected(p1choice);//播放selected语音
			}
		});
		jc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jc2.getSelectedItem()=="卫宫") {
					p2choice=1;
				}
				else if(jc2.getSelectedItem()=="阿尔托莉雅") {
					p2choice=2;
				}
				else if(jc2.getSelectedItem()=="赫拉克勒斯") {
					p2choice=3;
				}
				else if(jc2.getSelectedItem()=="吉尔伽美什") {
					p2choice=4;
				}
				else if(jc2.getSelectedItem()=="库丘林") {
					p2choice=5;
				}
				else{
					p2choice=6;
				}
				System.out.println("玩家2选择了【"+jc2.getSelectedItem()+"】");
				Sound.selected(p2choice);//播放selected语音
			}
		});
		servantConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isServantConfirm=true;
			}
		});
		setBounds(400,200,800,500);//设置窗体位置，参数为x,y,width,height
		setVisible(true);
		setTitle("角色选择");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//使用绝对布局
		c.setLayout(null);
		//设置组件的位置，参数为x,y,width,height
		jl1.setBounds(300, 200, 100, 30);
		jc1.setBounds(400, 200, 100, 30);
		jl2.setBounds(300, 250, 100, 30);
		jc2.setBounds(400, 250, 100, 30);
		servantConfirm.setBounds(300, 350, 200, 30);
		//添加组件
		c.add(jl1);
		c.add(jc1);
		c.add(jl2);
		c.add(jc2);
		c.add(servantConfirm);
		//把标签的大小位置设置为图片刚好填充整个面板
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		//把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		JPanel imagePanel = (JPanel) this.getContentPane();
		//使内容窗格透明
		imagePanel.setOpaque(false);
		// 把背景图片添加到分层窗格的最底层作为背景
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

	}

	/*
	 * 游戏界面
	 */
	public void gamePlayPane() {
		Container c=getContentPane();
		setBounds(400,50,1100,700);//设置窗体位置，参数为x,y,width,height
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		JPanel p1=new JPanel(new GridLayout(20,20,0,0));//面板1=地图区
		JPanel p2=new JPanel(new GridLayout(2,3,0,0));//面板2=按键区
		c.setLayout(null);
		//设置面板位置，参数为x,y,width,height
		p1.setBounds(30,30,700,600);
		p2.setBounds(800,500,150,100);
		for(int i=0;i<400;i++) {
			mapButton[i]=new JButton();
			p1.add(mapButton[i]);//将按钮添加到面板1
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
		setTitle("游戏界面");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}


	private Image getImage(Icon icon_roll2) {
		// TODO 自动生成的方法存根
		return null;
	}


	/*
	 * 刷新游戏界面，在gf内更新当前玩家nowply，在myMap中刷新地图按钮数组
	 */
	public void refrFrame(Player now,Player p1, Player p2, Map m) {
		for(int i=0;i<400;i++) {
			m.terrain[i]=m.MAP_1[i];
		}
		int x1=p1.getPositionX();
		int y1=p1.getPositionY();
		int num1=Map.getNum(x1, y1);//获得按钮编号
		m.terrain[num1]=(p1.name);//在地图按钮数组上更新p1位置
		int x2=p2.getPositionX();
		int y2=p2.getPositionY();
		int num2=Map.getNum(x2, y2);//获得按钮编号
		m.terrain[num2]=(p2.name);//在地图按钮数组上更新p2位置
		for(int i=0;i<400;i++) {
			if(m.terrain[i]==-1) {
				//黑色为障碍格,-1
				mapButton[i].setIcon(null);
				mapButton[i].setBackground(Color.BLACK);
			}else if(m.terrain[i]==0) {
				//白色为可行格,0
				mapButton[i].setIcon(null);
				mapButton[i].setBackground(Color.WHITE);
			}else if(m.terrain[i]==1) {
				//蓝色为p1,1
				mapButton[i].setBackground(Color.BLUE);
				setServantIcon(mapButton[i],p1);
			}else if(m.terrain[i]==2) {
				//红色为p2,2
				mapButton[i].setBackground(Color.RED);
				setServantIcon(mapButton[i],p2);
			}
		}
		//等待添加：当前玩家now的方格会拥有额外标识
	}

	/*
	 * 设置两名玩家的从者图标
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

		//待补充


	}
	
	/*
	 * 调整图标大小
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
	String[] test = { "卫宫", "阿尔托莉雅","赫拉克勒斯", "吉尔伽美什","库丘林","美杜莎" };

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

