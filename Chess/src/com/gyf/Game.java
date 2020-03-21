package com.gyf;


public class Game {
	
	public Player p1;
	public Player p2;
	public Player nowply;//��ǰ���
	public Map myMap;//��ǰ��ͼ
	public gameFrame gf;
	int roundNum=1;//�ѽ��еĴ�غ���
	
	public Game() {
		gf=new gameFrame();
		p1=new Player(1,gf.p1choice);
		p2=new Player(2,gf.p2choice);
		myMap=new Map(1);//��ǰ��ͼ����Ϊ��ͼ1
		nowply=p1;//��ǰ���ΪP1���
		
		gf.refrFrame(nowply,p1,p2,myMap);//ˢ�µ�ͼ���
	}

	/*
	 * ��Ϸ��ʼ����Ϸ������ȫ������
	 */
	public void start() {
		while(true) {
			if(nowply==p1) {
				gf.refrFrame(nowply,p1,p2,myMap);//ˢ�µ�ͼ���
				System.out.println("��"+roundNum+"�ֻغϿ�ʼ");
				playerTurn(nowply);//��ʼ��ǰ��ҵ�С�غ�
				nowply=p2;//��ǰ�����Ϊp1
				gf.refrFrame(nowply,p1,p2,myMap);
			}else if(nowply==p2){
				playerTurn(nowply);//��ʼ��ǰ��ҵ�С�غ�
				nowply=p1;//��ǰ�����Ϊp1
				gf.refrFrame(nowply,p1,p2,myMap);
				System.out.println("��"+roundNum+"�ֻغϽ���");
				System.out.println("=====================");
				roundNum++;//��غ�����һ
			}else {
				System.out.println("bug1");
			}
			//p1.health--;//Ϊ������ѭ�������ԣ�
			if(isOver()) {
				break;
			}else {
				continue;
			}
		}
		if(p1.health==0) {
			Sound.win(p2.servant);//����win����
			System.out.println("gameover��"+"���2���ʤ����");
		}else {
			Sound.win(p1.servant);//����win����
			System.out.println("gameover��"+"���1���ʤ����");
		}
	}
	
	/*
	 * ��ҵ�С�غ�
	 */
	public void playerTurn(Player pl) {
		//System.out.println("X:"+p1.getPositionX()+"Y:"+p1.getPositionY());
		System.out.println("���"+pl.name+"��С�غϿ�ʼ");//��ʼ��ǰ��ҵ�С�غ�
		Sound.speak(pl.servant);//����speak����
		gf.roll.setEnabled(true);//��roll��ť����Ϊ��ѡ
		
		//�ȴ���Ұ���roll��ť
		while(true) {
			if(gf.isRoll==true) {
				pl.roll();//��ɫ��
				gf.isRoll=false;//����boolean����
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gf.roll.setEnabled(false);//��roll��ť����Ϊ����ѡ
		
		//�ȴ���Ұ����ĸ��ƶ���ť
		while(pl.moveNumber>0) {
			//System.out.println("X:"+p1.getPositionX()+"Y:"+p1.getPositionY());
			System.out.println("���"+pl.name+"���ж�����Ϊ"+pl.moveNumber);
			//�ж���Ҷ����ϱ����ĸ����ڷ����Ƿ�Ϊ���и񣬽���Ӧ���ƶ���ť����Ϊ��ѡ
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
			//�ȴ���Ұ����ƶ���ť
			while(true) {
				if(gf.isNorth) {
					pl.step(1);//���ƶ�һ��
					gf.isNorth=false;//����boolean����
					break;
				}else if(gf.isEast) {
					pl.step(2);//���ƶ�һ��
					gf.isEast=false;//����boolean����
					break;
				}else if(gf.isSouth) {
					pl.step(3);//�����ƶ�һ��
					gf.isSouth=false;//����boolean����
					break;
				}else if(gf.isWest) {
					pl.step(4);//�����ƶ�һ��
					gf.isWest=false;//����boolean����
					break;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			gf.refrFrame(nowply,p1,p2,myMap);
			//�����ƶ���ť����Ϊ����ѡ
			gf.north.setEnabled(false);
			gf.east.setEnabled(false);
			gf.south.setEnabled(false);
			gf.west.setEnabled(false);
		}
		//�ж�����Ϊ0����ǰ��ҽ����ƶ��׶�
		//��ǰ��ҽ��빥���׶Σ�������Թ����Ļ���
		if(pl.isAttack(nowply, p1, p2, myMap)) {//�жϵ�ǰ����Ƿ���Թ������з����
			gf.attack.setEnabled(true);//��������ť����Ϊ��ѡ
			//�ȴ���Ұ��¹�����ť
			while(true) {
				if(gf.isAttack) {
					pl.attack(nowply,p1,p2,gf);//��ǰ��ҷ�������
					break;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			gf.attack.setEnabled(false);//��roll��ť����Ϊ����ѡ
		}

		
		
	}
	
	
	/*
	 * �ж���Ϸ�Ƿ����
	 */
	public boolean isOver() {
		if((p1.health==0)||(p2.health==0)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	

}
