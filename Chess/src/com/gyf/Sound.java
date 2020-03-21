
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
		if(servant==1) {

		}else if(servant==2) {
			Random r=new Random();
			int result=r.nextInt(3);//0,1,2
			if(result==0) {
				play(DIR + "actspeak1.wav", false);// ����һ��speak��Ч
			}else if(result==1) {
				play(DIR + "actspeak2.wav", false);// ����һ��speak��Ч
			}else {
				play(DIR + "actspeak3.wav", false);// ����һ��speak��Ч
			}
		}else if(servant==3) {

		}else if(servant==4) {

		}else if(servant==5) {

		}else if(servant==6) {

		}

	}

	/**
	 * ����selected��Ч
	 */
	static public void selected(int servant) {
		if(servant==1) {

		}else if(servant==2) {
			play(DIR + "actselected.wav", false);
		}else if(servant==3) {

		}else if(servant==4) {

		}else if(servant==5) {

		}else if(servant==6) {

		}
	}

	/**
	 * ����hurted��Ч���ݲ�����
	 */
	/*
	static public void hurted(int servant) {
		if(servant==1) {

		}else if(servant==2) {
			play(DIR + "hurted.wav", false);
		}else if(servant==3) {

		}else if(servant==4) {

		}else if(servant==5) {

		}else if(servant==6) {

		}
	}
	*/

	/**
	 * ����noble��Ч
	 */
	static public void noble(int servant) {
		if(servant==1) {

		}else if(servant==2) {
			play(DIR + "actnoble.wav", false);

		}else if(servant==3) {

		}else if(servant==4) {

		}else if(servant==5) {

		}else if(servant==6) {

		}
	}

	/**
	 * ����win��Ч
	 */
	static public void win(int servant) {
		if(servant==1) {

		}else if(servant==2) {
			play(DIR + "actwin.wav", false);

		}else if(servant==3) {

		}else if(servant==4) {

		}else if(servant==5) {

		}else if(servant==6) {

		}
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
