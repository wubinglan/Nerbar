package com.song.se.lesson.ch02.am.netbar;

import java.util.Date;
import java.util.Random;

/**
 * 电脑类
 * @author 宋伟宁
 * 2016年2月19日下午3:58:32
 */
public class Computer {

	private int id;//机器号
	private RoomType type;//房间类型
	private State state;//状态
	private Date start_time;//开始时间
	private Date end_time;//结束时间
	private Person person;
	
	private int createId(){
		return new Random().nextInt(200)+1;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RoomType getType() {
		return type;
	}
	public void setType(RoomType type) {
		this.type = type;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	public Computer() {
		this.id=this.createId();
	}

	public Computer(RoomType type, State state, Date start_time,
			Date end_time, Person person) {
		this();
		this.type = type;
		this.state = state;
		this.start_time = start_time;
		this.end_time = end_time;
		this.person = person;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", type=" + type + ", state=" + state
				+ ", start_time=" + start_time + ", end_time=" + end_time
				+ ", person=" + person + "]";
	}
	
	
}
