
package com.gyf;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * 音效类
 *
 */
public class Sound {
	static final String DIR = "music/";// 音乐文件夹
	static MusicPlayer bg_1;
	static MusicPlayer bg_2;

	/**
	 * 播放speak音效
	 */
	static public void speak(int servant) {
		if(servant==1) {

		}else if(servant==2) {
			Random r=new Random();
			int result=r.nextInt(3);//0,1,2
			if(result==0) {
				play(DIR + "actspeak1.wav", false);// 播放一次speak音效
			}else if(result==1) {
				play(DIR + "actspeak2.wav", false);// 播放一次speak音效
			}else {
				play(DIR + "actspeak3.wav", false);// 播放一次speak音效
			}
		}else if(servant==3) {

		}else if(servant==4) {

		}else if(servant==5) {

		}else if(servant==6) {

		}

	}

	/**
	 * 播放selected音效
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
	 * 播放hurted音效，暂不启用
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
	 * 播放noble音效
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
	 * 播放win音效
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
	 * 播放背景音乐
	 */
	static public void backgroud_1() {
		try {
			// 创建播放器
			bg_1 = new MusicPlayer(DIR + "background1.wav", true);
			bg_1.play();// 播放器开始播放
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	static public void backgroud_2() {
		try {
			// 创建播放器
			bg_2 = new MusicPlayer(DIR + "background2.wav", true);
			bg_2.play();// 播放器开始播放
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 普通音效播放（除background以外的音效都属于普通音效）
	 * 
	 * @param file
	 *            音乐文件完整名称
	 * @param circulate
	 *            是否循环播放
	 */
	private static void play(String file, boolean circulate) {
		try {
			// 创建播放器
			MusicPlayer musplayer = new MusicPlayer(file, circulate);
			musplayer.play();// 播放器开始播放
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
