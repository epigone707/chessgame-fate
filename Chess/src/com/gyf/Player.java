package com.gyf;

import java.util.Random;

public class Player {
	
	private int positionX;//地图最左上角的格子坐标为（1，1），地图为8行5列
	private int positionY;
	public int health;//默认为1
	public int moveNumber;//行动点数
	public int name;//1为p1,2为p2
	public int range;//攻击距离，攻击距离为1时，玩家可攻击到东南西北方向的4个相邻格，为2时可攻击到8个格子
	public int speed;//敏捷补正，补正为+x且色子为y时，获得的总行动点数为x+y
	public int servant;//从者编号
	
	public Player(int plname,int choice) {
		health=1;
		name=plname;//即玩家编号，目前仅有双人模式，故name为1或2
		moveNumber=0;
		servant=choice;
		//设置从者的初始位置
		if(name==1) {
			positionX=1;
			positionY=1;
		}else if(name==2) {
			positionX=20;
			positionY=20;
		}
		else {
			System.out.println("初始位置设置错误");
		}
		//设置从者攻击距离&敏捷补正
		switch (servant){
		case 1:
			range=2;
			speed=0;
			break;
		case 2:case 3:
			range=1;
			speed=0;
			break;
		case 4:
			range=3;
			speed=0;
			break;
		case 5:case 6:
			range=1;
			speed=1;
			break;
		default:
			System.out.println("玩家"+plname+"从者攻击距离设置错误");
		}
		
	}
	
	/*
	 * 获得玩家x坐标
	 */
	public int getPositionX() {
		return positionX;
	}
	
	
	/*
	 * 获得玩家y坐标
	 */
	public int getPositionY() {
		return positionY;
	}
	
	/*
	 * 掷色子
	 */
	public void roll() {
		Random r=new Random();
		int result=r.nextInt(6)+1;//1-6
		System.out.println("玩家"+this.name+"掷色子的结果为"+result);
		moveNumber=result+speed;
	}
	
	/*
	 * 判断当前玩家（nowply）是否能攻击到敌玩家（enemy）
	 */
	public boolean isAttack(Player nowply,Player p1, Player p2, Map m) {
		Player enemy;
		if(nowply.name==1) {
			enemy=p2;
		}else {
			enemy=p1;
		}
		int smallX,bigX,smallY,bigY;
		if(enemy.getPositionX()>nowply.getPositionX()) {
			smallX=nowply.getPositionX();
			bigX=enemy.getPositionX();
		}else {
			bigX=nowply.getPositionX();
			smallX=enemy.getPositionX();
		}
		if(enemy.getPositionY()>nowply.getPositionY()) {
			smallY=nowply.getPositionY();
			bigY=enemy.getPositionY();
		}else {
			bigY=nowply.getPositionY();
			smallY=enemy.getPositionY();
		}
		int deltaX=bigX-smallX;//x坐标差值
		int deltaY=bigY-smallY;//y坐标差值
		if(deltaX==0 && deltaY<=nowply.range) {//两名玩家在同一列，且敌玩家在当前玩家攻击范围内的情况
			for(int i=1;i<deltaY;i++) {
				if(m.terrain[Map.getNum(smallX,smallY+i)]==0) {
					continue;
				}else {
					return false;
				}
			}
			return true;
		}else if(deltaY==0 && deltaX<=nowply.range){//两名玩家在同一行，且敌玩家在当前玩家攻击范围内的情况
			for(int i=1;i<deltaX;i++) {
				if(m.terrain[Map.getNum(smallX+i,smallY)]==0) {
					continue;
				}else {
					return false;
				}
			}
			return true;
		}else {//两名玩家x，y坐标均不相同的情况
			return false;
		}
	}
	
	/*
	 * 判断玩家北方的相邻格子是否为障碍
	 */
	public boolean isNorthObstacle(Map m) {
		int northX=positionX;
		int northY=positionY-1;
		int num=Map.getNum(northX, northY);
		if(positionY>1 && num>=0 && num<400 && m.terrain[num]==0) {
			return false;
		}else {
			return true;
		}
	}
	
	/*
	 * 判断玩家东方的相邻格子是否为障碍
	 */
	public boolean isEastObstacle(Map m) {
		int eastX=positionX+1;
		int eastY=positionY;
		int num=Map.getNum(eastX, eastY);
		if(positionX<20 && num>=0 && num<400 && m.terrain[num]==0) {
			return false;
		}else {
			return true;
		}
	}
	
	/*
	 * 判断玩家南方的相邻格子是否为障碍
	 */
	public boolean isSouthObstacle(Map m) {
		int southX=positionX;
		int southY=positionY+1;
		int num=Map.getNum(southX, southY);
		if(positionY<20 && num>=0 && num<400 && m.terrain[num]==0) {
			return false;
		}else {
			
			return true;
		}
	}
	
	/*
	 * 判断玩家西方的相邻格子是否为障碍
	 */
	public boolean isWestObstacle(Map m) {
		int westX=positionX-1;
		int westY=positionY;
		int num=Map.getNum(westX, westY);
		if(positionX>1 && num>=0 && num<400 && m.terrain[num]==0) {
			return false;
		}else {
			return true;
		}
	}
	
	/*
	 * 玩家移动一格
	 */
	public void step(int direction) {
		if(direction==1) {
			positionY--;//向北
		}else if(direction==2) {
			positionX++;//向东
		}else if(direction==3) {
			positionY++;//向南
		}else if(direction==4) {
			positionX--;//向西
		}
		moveNumber--;//玩家行动点数-1
	}

	/*
	 * 玩家攻击
	 */
	public void attack(Player now,Player p1,Player p2,gameFrame gf) {
		gf.isAttack=false;//重置boolean变量
		if(now.name==1) {
			p2.health--;
			System.out.println("玩家1攻击了玩家2");	
		}else {
			p1.health--;
			System.out.println("玩家2攻击了玩家1");	
		}
	}


}
