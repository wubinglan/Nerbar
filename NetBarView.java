package com.song.se.lesson.ch02.am.netbar;

import java.util.Scanner;

public class NetBarView {

	public static void main(String[] args) {
		INetBar netbar=new NetBarService();
		Scanner in=new Scanner(System.in);
		Person person=new Person();
		person.setIden_no("3535344565");
		int m=0;
		do {
			System.out.println("============= 夜不归宿网吧欢迎您！===========");
			System.out.println("1:上机  2：结账  3：浏览  4：退出（1-4）");
			m=in.nextInt();
			switch (m) {
			case 3:
				netbar.showInfo();
				break;
			case 1:
				System.out.println("请选择房间类型：1：大厅 2：包间（1-2）");
				m=in.nextInt();
				RoomType type= m ==1 ? RoomType.大厅 : RoomType.包间  ;
				netbar.begin(type, person);
				break;
			case 2:
				netbar.pay(person);
				
				break;
			}
		} while (m<=4);

	}

}
