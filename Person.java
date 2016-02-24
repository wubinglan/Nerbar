package com.song.se.lesson.ch02.am.netbar;

/**
 * 顾客
 * @author 宋伟宁
 * 2016年2月19日下午4:01:40
 */
public class Person {

	private String iden_no;//身份证
    private Computer computer;
	public String getIden_no() {
		return iden_no;
	}

	public void setIden_no(String iden_no) {
		this.iden_no = iden_no;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	@Override
	public String toString() {
		return "身份证："+this.iden_no;
	}
	
	
}
