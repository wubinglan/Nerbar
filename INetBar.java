package com.song.se.lesson.ch02.am.netbar;

import java.util.ArrayList;
import java.util.List;

public interface INetBar {

	 List<Computer> COMPUTERS=new ArrayList<Computer>(200);
	 //上机
	 void begin(RoomType type,Person person);
	 //下机
	 void pay(Person person);
	 //浏览所有机器（的状态）
	 void showInfo();
	 
	 
}
