package com.gyf;


public class Map {
	public int[] terrain=new int[40];
	public final int[] MAP_1={0,-1,0,-1,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,-1,-1,-1,0,0,0,0,
			0,0,0,0,0,0,-1,-1,0,0,0,0,0,0,0};
	public final int[] MAP_2={-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	public int chooseMap;//��ͼѡ��
	
	
	public Map(int chooseMap) {
		this.chooseMap=chooseMap;
		if (chooseMap==1) {
			for(int i=0;i<40;i++) {
				terrain[i]=MAP_1[i];
			}
			
		}else if(chooseMap==2) {
			for(int i=0;i<40;i++) {
				terrain[i]=MAP_2[i];
			}
		}
	}
	
	/*
	 * �ɰ�ť��ŷ���x����
	 */
	public static int getX(int num) {
		int result=((num+1)%5)+1;
		return result;
	}
	
	/*
	 * �ɰ�ť��ŷ���y����
	 */
	public static int getY(int num) {
		int result=(num+1)/5;
		return result;
	}
	
	/*
	 * ��x�����y���귵�ذ�ť���
	 */
	public static int getNum(int x,int y) {
		int num=5*(y-1)+x-1;
		return num;
	}
	

}
