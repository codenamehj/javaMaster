package com.yedam;

public class Enrolment {
	String code;
	String id;
	String enrolDate;
	
	Enrolment(){
		
	}
	
	public Enrolment(String code, String id, String enrolDate) {
		this.code = code;
		this.id = id;
		this.enrolDate = enrolDate;
	}
	
	void showInfo() {
		System.out.println(code + "    " + id + "    " + enrolDate);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEnrolDate() {
		return enrolDate;
	}

	public void setEnrolDate(String enrolDate) {
		this.enrolDate = enrolDate;
	}	
}
