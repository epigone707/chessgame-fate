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
	JLabel label = new JLabel(iconbackground);// 把背景图片显示在一个标签里面
	JComboBox<String> jc1 = new JComboBox<>(new MyComboBox());
	JComboBox<String> jc2 = new JComboBox<>(new MyComboBox());
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
		jc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jc1.getSelectedItem()=="卫宫") {
	    			System.out.println("玩家1选择了【卫宫】");
	    			Sound.selected(1);//播放selected语音
	    			p1choice=1;
	    		}
	    		else if(jc1.getSelectedItem()=="阿尔托莉雅") {
	    			System.out.println("玩家1选择了【阿尔托莉雅】");
	    			Sound.selected(2);//播放selected语音
	    			p1choice=2;
	    		}
	    		else if(jc1.getSelectedItem()=="赫拉克勒斯") {
	    			System.out.println("玩家1选择了【赫拉克勒斯】");
	    			Sound.selected(3);//播放selected语音
	    			p1choice=3;
	    		}
	    		else if(jc1.getSelectedItem()=="吉尔伽美什") {
	    			System.out.println("玩家1选择了【吉尔伽美什】");
	    			Sound.selected(4);//播放selected语音
	    			p1choice=4;
	    		}
	    		else if(jc1.getSelectedItem()=="库丘林") {
	    			System.out.println("玩家1选择了【库丘林】");
	    			Sound.selected(5);//播放selected语音
	    			p1choice=5;
	    		}
	    		else if(jc1.getSelectedItem()=="美杜莎") {
	    			System.out.println("玩家1选择了【美杜莎】");
	    			Sound.selected(6);//播放selected语音
	    			p1choice=6;
	    		}
			}
		});
		jc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jc2.getSelectedItem()=="卫宫") {
	    			System.out.println("玩家2选择了【卫宫】");
	    			Sound.selected(1);//播放selected语音
	    			p2choice=1;
	    		}
	    		else if(jc2.getSelectedItem()=="阿尔托莉雅") {
	    			System.out.println("玩家2选择了【阿尔托莉雅】");
	    			Sound.selected(2);//播放selected语音
	    			p2choice=2;
	    		}
	    		else if(jc2.getSelectedItem()=="赫拉克勒斯") {
	    			System.out.println("玩家2选择了【赫拉克勒斯】");
	    			Sound.selected(3);//播放selected语音
	    			p2choice=3;
	    		}
	    		else if(jc2.getSelectedItem()=="吉尔伽美什") {
	    			System.out.println("玩家2选择了【吉尔伽美什】");
	    			Sound.selected(4);//播放selected语音
	    			p2choice=4;
	    		}
	    		else if(jc2.getSelectedItem()=="库丘林") {
	    			System.out.println("玩家2选择了【库丘林】");
	    			Sound.selected(5);//播放selected语音
	    			p2choice=5;
	    		}
	    		else if(jc2.getSelectedItem()=="美杜莎") {
	    			System.out.println("玩家2选择了【美杜莎】");
	    			Sound.selected(6);//播放selected语音
	    			p2choice=6;
	    		}
			}
		});
		servantConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isServantConfirm=true;
			}
		});
		setBounds(400,200,800,500);//参数为x,y,width,height
		setVisible(true);
		setTitle("角色选择");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		c.setLayout(null);
		jl1.setBounds(300, 200, 100, 30);//参数为x,y,width,height
		jc1.setBounds(400, 200, 100, 30);
		jl2.setBounds(300, 250, 100, 30);
		jc2.setBounds(400, 250, 100, 30);
		servantConfirm.setBounds(300, 350, 200, 30);
		c.add(jl1);
		c.add(jc1);
		c.add(jl2);
		c.add(jc2);
		c.add(servantConfirm);
		
		// 把标签的大小位置设置为图片刚好填充整个面板
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
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
		setBounds(400,50,900,700);//参数为x,y,width,height
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		c.setLayout(new GridBagLayout());
		final GridBagConstraints gbc_1=new GridBagConstraints();//面板1=地图
		gbc_1.gridy=0;
		gbc_1.gridx=0;
		gbc_1.weightx=90;
		//gbc_1.fill=GridBagConstraints.BOTH;
		final GridBagConstraints gbc_2=new GridBagConstraints();//面板2=按键区
		gbc_2.gridy=0;
		gbc_2.gridx=1;
		gbc_2.weightx=10;
		gbc_2.insets = new Insets(0, 5, 0, 0);
		gbc_2.fill=GridBagConstraints.BOTH;
		JPanel p1=new JPanel(new GridLayout(8,5,1,1));
		for(int i=0;i<40;i++) {
			mapButton[i]=new JButton(String.valueOf(i));
			mapButton[i].setPreferredSize(new Dimension(100, 100));//按钮的大小
			p1.add(mapButton[i]);//将按钮添加到面板1
		}
		JPanel p2=new JPanel();
		roll=new JButton("roll");
		attack=new JButton("attack!");
		north=new JButton("向北移动");
		east=new JButton("向东移动");
		south=new JButton("向南移动");
		west=new JButton("向西移动");
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
		setTitle("游戏界面");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	
	/*
	 * 刷新游戏界面，在gf内更新当前玩家nowply，在myMap中刷新地图按钮数组
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
		m.terrain[num1]=(p1.name);//在地图按钮数组上更新p1位置
		int x2=p2.getPositionX();
		int y2=p2.getPositionY();
		int num2=5*(y2-1)+x2-1;
		//System.out.println("x2:"+x2+"y2:"+y2+"num2"+num2);
		m.terrain[num2]=(p2.name);//在地图按钮数组上更新p2位置
		nowply=now; //在gf内更新当前玩家
		for(int i=0;i<40;i++) {
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
				setServantIcon(mapButton[i],p2);
				mapButton[i].setBackground(Color.RED);
			}
		}
	}
	
	/*
	 * 设置两名玩家的从者图标
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
		
		//待补充
		
		
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

