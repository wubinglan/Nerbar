package com.song.se.lesson.ch02.am.netbar;

import java.util.Date;
import java.util.Iterator;

public class NetBarService implements INetBar {
	static {
		COMPUTERS.add(new Computer(RoomType.大厅, State.空闲, null, null, null));
		COMPUTERS.add(new Computer(RoomType.大厅, State.空闲, null, null, null));
		COMPUTERS.add(new Computer(RoomType.大厅, State.空闲, null, null, null));
		COMPUTERS.add(new Computer(RoomType.包间, State.空闲, null, null, null));
		COMPUTERS.add(new Computer(RoomType.包间, State.空闲, null, null, null));
	}

	@Override
	public void begin(RoomType type, Person person) {
		// 上机
		/**
		 * 1:用户选择房间类型 2：更加房间类型选择空闲的机器进行分配（需要判断是否有空闲） 3：分配到电脑： 3.1修改状态为占用 3.2开始计时
		 * 3.2绑定客户（信息）
		 * 
		 */
		boolean flag = false;
		Computer computer = null;
		// 迭代集合
		for (Iterator<Computer> it = INetBar.COMPUTERS.iterator(); it.hasNext();) {
			computer = it.next();//
			// 判断房间类型
			if (type == computer.getType() && computer.getState() == State.空闲) {
				flag = true;// 有可用的机器
				break;
			}
		}
		if (flag) {// 条件满足
			computer.setState(State.占用);// 修改状态
			computer.setPerson(person);// 绑定客户
			computer.setStart_time(new Date());// 系统时间
		} else {
			System.out.println("对不起，" + type + "暂时没有空闲的机器");
		}

	}

	@Override
	public void pay(Person person) {
		/**
		 * 结账：1：根据身份证找到使用的机器（迭代） 2：设置结束时间（系统时间） 3：计算时长：结束时间-开始时间 4：得到费率（根据房间类型）
		 * 4.1修改使用的电脑状态为空闲 4.2解除绑定 4.3清空开始时间
		 * 
		 * 
		 */
		double money = 0;
		long time = 0;
		for (Iterator<Computer> it = COMPUTERS.iterator(); it.hasNext();) {
			Computer c = it.next();
			if (c.getPerson() != null) {
				if (person.getIden_no().equals(c.getPerson().getIden_no())) {
					RoomType type = c.getType();// 得到房间类型
					long start = c.getStart_time().getTime();// 得到开始时间
					long end = new Date().getTime();// 得到结束时间
					// 计算时长
					time = (end - start)/1000;// 得到毫秒值

					// 计算费用
					switch (type) {
					case 大厅:
						money = 3 * time;
						break;
					case 包间:
						money = 5 * time;
						break;
					}
					c.setPerson(null);
					person.setComputer(null);// 解除绑定
					c.setState(State.空闲);// 修改状态为空闲
					c.setStart_time(null);// 清空开始时间

				}
			}
		}

		System.out.println("本次上网用时：" + time + "您消费￥" + money+"元");
	}

	@Override
	public void showInfo() {
		// 浏览所有：迭代
		for (Computer c : COMPUTERS) {
			System.out.println(c);
		}

	}

}
