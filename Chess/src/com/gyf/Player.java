package com.gyf;

import java.util.Random;

public class Player {
	
	private int positionX;//��ͼ�����Ͻǵĸ�������Ϊ��1��1������ͼΪ8��5��
	private int positionY;
	public int health;//Ĭ��Ϊ1
	public int moveNumber;//�ж�����
	public int name;//1Ϊp1,2Ϊp2
	public int range;//�������룬��������Ϊ1ʱ����ҿɹ������������������4�����ڸ�Ϊ2ʱ�ɹ�����8������
	public int speed;//���ݲ���������Ϊ+x��ɫ��Ϊyʱ����õ����ж�����Ϊx+y
	public int servant;//���߱��
	
	public Player(int plname,int choice) {
		health=1;
		name=plname;//����ұ�ţ�Ŀǰ����˫��ģʽ����nameΪ1��2
		moveNumber=0;
		servant=choice;
		//���ô��ߵĳ�ʼλ��
		if(name==1) {
			positionX=1;
			positionY=1;
		}else if(name==2) {
			positionX=20;
			positionY=20;
		}
		else {
			System.out.println("��ʼλ�����ô���");
		}
		//���ô��߹�������&���ݲ���
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
			System.out.println("���"+plname+"���߹����������ô���");
		}
		
	}
	
	/*
	 * ������x����
	 */
	public int getPositionX() {
		return positionX;
	}
	
	
	/*
	 * ������y����
	 */
	public int getPositionY() {
		return positionY;
	}
	
	/*
	 * ��ɫ��
	 */
	public void roll() {
		Random r=new Random();
		int result=r.nextInt(6)+1;//1-6
		System.out.println("���"+this.name+"��ɫ�ӵĽ��Ϊ"+result);
		moveNumber=result+speed;
	}
	
	/*
	 * �жϵ�ǰ��ң�nowply���Ƿ��ܹ���������ң�enemy��
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
		int deltaX=bigX-smallX;//x�����ֵ
		int deltaY=bigY-smallY;//y�����ֵ
		if(deltaX==0 && deltaY<=nowply.range) {//���������ͬһ�У��ҵ�����ڵ�ǰ��ҹ�����Χ�ڵ����
			for(int i=1;i<deltaY;i++) {
				if(m.terrain[Map.getNum(smallX,smallY+i)]==0) {
					continue;
				}else {
					return false;
				}
			}
			return true;
		}else if(deltaY==0 && deltaX<=nowply.range){//���������ͬһ�У��ҵ�����ڵ�ǰ��ҹ�����Χ�ڵ����
			for(int i=1;i<deltaX;i++) {
				if(m.terrain[Map.getNum(smallX+i,smallY)]==0) {
					continue;
				}else {
					return false;
				}
			}
			return true;
		}else {//�������x��y���������ͬ�����
			return false;
		}
	}
	
	/*
	 * �ж���ұ��������ڸ����Ƿ�Ϊ�ϰ�
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
	 * �ж���Ҷ��������ڸ����Ƿ�Ϊ�ϰ�
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
	 * �ж�����Ϸ������ڸ����Ƿ�Ϊ�ϰ�
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
	 * �ж�������������ڸ����Ƿ�Ϊ�ϰ�
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
	 * ����ƶ�һ��
	 */
	public void step(int direction) {
		if(direction==1) {
			positionY--;//��
		}else if(direction==2) {
			positionX++;//��
		}else if(direction==3) {
			positionY++;//����
		}else if(direction==4) {
			positionX--;//����
		}
		moveNumber--;//����ж�����-1
	}

	/*
	 * ��ҹ���
	 */
	public void attack(Player now,Player p1,Player p2,gameFrame gf) {
		gf.isAttack=false;//����boolean����
		if(now.name==1) {
			p2.health--;
			System.out.println("���1���������2");	
		}else {
			p1.health--;
			System.out.println("���2���������1");	
		}
	}


}
