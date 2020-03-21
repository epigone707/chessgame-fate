package com.gyf;


public class Game {
	
	public Player p1;
	public Player p2;
	public Player nowply;//当前玩家
	public Map myMap;//当前地图
	public gameFrame gf;
	int roundNum=1;//已进行的大回合数
	
	public Game() {
		gf=new gameFrame();
		p1=new Player(1,gf.p1choice);
		p2=new Player(2,gf.p2choice);
		myMap=new Map(1);//当前地图设置为地图1
		nowply=p1;//当前玩家为P1玩家
		
		gf.refrFrame(nowply,p1,p2,myMap);//刷新地图面板
	}

	/*
	 * 游戏开始到游戏结束的全部流程
	 */
	public void start() {
		while(true) {
			if(nowply==p1) {
				gf.refrFrame(nowply,p1,p2,myMap);//刷新地图面板
				System.out.println("第"+roundNum+"轮回合开始");
				playerTurn(nowply);//开始当前玩家的小回合
				nowply=p2;//当前玩家设为p1
				gf.refrFrame(nowply,p1,p2,myMap);
			}else if(nowply==p2){
				playerTurn(nowply);//开始当前玩家的小回合
				nowply=p1;//当前玩家设为p1
				gf.refrFrame(nowply,p1,p2,myMap);
				System.out.println("第"+roundNum+"轮回合结束");
				System.out.println("=====================");
				roundNum++;//大回合数加一
			}else {
				System.out.println("bug1");
			}
			//p1.health--;//为了跳出循环（测试）
			if(isOver()) {
				break;
			}else {
				continue;
			}
		}
		if(p1.health==0) {
			Sound.win(p2.servant);//播放win语音
			System.out.println("gameover！"+"玩家2获得胜利！");
		}else {
			Sound.win(p1.servant);//播放win语音
			System.out.println("gameover！"+"玩家1获得胜利！");
		}
	}
	
	/*
	 * 玩家的小回合
	 */
	public void playerTurn(Player pl) {
		//System.out.println("X:"+p1.getPositionX()+"Y:"+p1.getPositionY());
		System.out.println("玩家"+pl.name+"的小回合开始");//开始当前玩家的小回合
		Sound.speak(pl.servant);//播放speak语音
		gf.roll.setEnabled(true);//将roll按钮设置为可选
		
		//等待玩家按下roll按钮
		while(true) {
			if(gf.isRoll==true) {
				pl.roll();//掷色子
				gf.isRoll=false;//重置boolean变量
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gf.roll.setEnabled(false);//将roll按钮设置为不可选
		
		//等待玩家按下四个移动按钮
		while(pl.moveNumber>0) {
			//System.out.println("X:"+p1.getPositionX()+"Y:"+p1.getPositionY());
			System.out.println("玩家"+pl.name+"的行动点数为"+pl.moveNumber);
			//判断玩家东西南北的四个相邻方格是否为可行格，将对应的移动按钮设置为可选
			if(pl.isNorthObstacle(myMap)==false) {
				gf.north.setEnabled(true);
			}
			if(pl.isEastObstacle(myMap)==false) {
				gf.east.setEnabled(true);
			}
			if(pl.isSouthObstacle(myMap)==false) {
				gf.south.setEnabled(true);
			}
			if(pl.isWestObstacle(myMap)==false) {
				gf.west.setEnabled(true);
			}
			//System.out.println("X:"+p1.getPositionX()+"Y:"+p1.getPositionY());
			//等待玩家按下移动按钮
			while(true) {
				if(gf.isNorth) {
					pl.step(1);//向北移动一格
					gf.isNorth=false;//重置boolean变量
					break;
				}else if(gf.isEast) {
					pl.step(2);//向东移动一格
					gf.isEast=false;//重置boolean变量
					break;
				}else if(gf.isSouth) {
					pl.step(3);//向南移动一格
					gf.isSouth=false;//重置boolean变量
					break;
				}else if(gf.isWest) {
					pl.step(4);//向西移动一格
					gf.isWest=false;//重置boolean变量
					break;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			gf.refrFrame(nowply,p1,p2,myMap);
			//所有移动按钮设置为不可选
			gf.north.setEnabled(false);
			gf.east.setEnabled(false);
			gf.south.setEnabled(false);
			gf.west.setEnabled(false);
		}
		//行动点数为0，当前玩家结束移动阶段
		//当前玩家进入攻击阶段（如果可以攻击的话）
		if(pl.isAttack(nowply, p1, p2, myMap)) {//判断当前玩家是否可以攻击到敌方玩家
			gf.attack.setEnabled(true);//将攻击按钮设置为可选
			//等待玩家按下攻击按钮
			while(true) {
				if(gf.isAttack) {
					pl.attack(nowply,p1,p2,gf);//当前玩家发动攻击
					break;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			gf.attack.setEnabled(false);//将roll按钮设置为不可选
		}

		
		
	}
	
	
	/*
	 * 判断游戏是否结束
	 */
	public boolean isOver() {
		if((p1.health==0)||(p2.health==0)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	

}
