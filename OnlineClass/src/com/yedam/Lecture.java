package com.yedam;


public class Lecture {
	String code;
	String title;
	String teacher;
	String startDate;
	int maxNum;
	int price;
	
	Lecture(){
		
	}
		
	public Lecture(String code, String title) {
		this.code = code;
		this.title = title;
	}

	public Lecture(String code, String title, String teacher, String startDate, int maxNum, int price) {
		
		this.code = code;
		this.title = title;
		this.teacher = teacher;
		this.startDate = startDate;
		this.maxNum = maxNum;
		this.price = price;
	}
	
	void showInfo(){
		System.out.println(code + "\t" + title + "\t" + teacher + "\t" + startDate + "\t" + maxNum + "\t" + price + "원");
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
}


