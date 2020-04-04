
package com.gyf;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * ��Ч��
 *
 */
public class Sound {
	static final String DIR = "music/";// �����ļ���
	static MusicPlayer bg_1;
	static MusicPlayer bg_2;

	/**
	 * ����speak��Ч
	 */
	static public void speak(int servant) {
		String SERVENT;
		if(servant==1) {
			SERVENT="emiya";
		}else if(servant==2) {
			SERVENT="act";
		}else if(servant==3) {
			SERVENT="hercu";
		}else if(servant==4) {
			SERVENT="gilga";
		}else if(servant==5) {
			SERVENT="cuchu";
		}else{
			SERVENT="medusa";
		}
		Random r=new Random();
		int result=r.nextInt(3);//0,1,2
		if(result==0) {
			play(DIR + SERVENT+"_speak1.wav", false);// ����speak1��Ч
		}else if(result==1) {
			play(DIR + SERVENT+"_speak2.wav", false);// ����speak2��Ч
		}else {
			play(DIR + SERVENT+"_speak3.wav", false);// ����speak3��Ч
		}

	}

	/**
	 * ����selected��Ч
	 */
	static public void selected(int servant) {
		String SERVENT;
		if(servant==1) {
			SERVENT="emiya";
		}else if(servant==2) {
			SERVENT="act";
		}else if(servant==3) {
			SERVENT="hercu";
		}else if(servant==4) {
			SERVENT="gilga";
		}else if(servant==5) {
			SERVENT="cuchu";
		}else{
			SERVENT="medusa";
		}
		play(DIR + SERVENT +"_selected.wav", false);
	}

	/**
	 * ����lose��Ч
	 */
	
	static public void lose(int servant) {
	String SERVENT;
		if(servant==1) {
			SERVENT="emiya";
		}else if(servant==2) {
			SERVENT="act";
		}else if(servant==3) {
			SERVENT="hercu";
		}else if(servant==4) {
			SERVENT="gilga";
		}else if(servant==5) {
			SERVENT="cuchu";
		}else{
			SERVENT="medusa";
		}
		play(DIR + SERVENT +"_lose.wav", false);
	}

	/**
	 * ����noble��Ч
	 */
	static public void noble(int servant) {
		String SERVENT;
		if(servant==1) {
			SERVENT="emiya";
		}else if(servant==2) {
			SERVENT="act";
		}else if(servant==3) {
			SERVENT="hercu";
		}else if(servant==4) {
			SERVENT="gilga";
		}else if(servant==5) {
			SERVENT="cuchu";
		}else{
			SERVENT="medusa";
		}
		play(DIR + SERVENT +"_noble.wav", false);
	}

	/**
	 * ����win��Ч
	 */
	static public void win(int servant) {
		String SERVENT;
		if(servant==1) {
			SERVENT="emiya";
		}else if(servant==2) {
			SERVENT="act";
		}else if(servant==3) {
			SERVENT="hercu";
		}else if(servant==4) {
			SERVENT="gilga";
		}else if(servant==5) {
			SERVENT="cuchu";
		}else{
			SERVENT="medusa";
		}
		play(DIR + SERVENT +"_win.wav", false);
	}



	/**
	 * ���ű�������
	 */
	static public void backgroud_1() {
		try {
			// ����������
			bg_1 = new MusicPlayer(DIR + "background1.wav", true);
			bg_1.play();// ��������ʼ����
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	static public void backgroud_2() {
		try {
			// ����������
			bg_2 = new MusicPlayer(DIR + "background2.wav", true);
			bg_2.play();// ��������ʼ����
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ͨ��Ч���ţ���background�������Ч��������ͨ��Ч��
	 * 
	 * @param file
	 *            �����ļ���������
	 * @param circulate
	 *            �Ƿ�ѭ������
	 */
	private static void play(String file, boolean circulate) {
		try {
			// ����������
			MusicPlayer musplayer = new MusicPlayer(file, circulate);
			musplayer.play();// ��������ʼ����
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
