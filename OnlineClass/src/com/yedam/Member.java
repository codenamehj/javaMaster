package com.yedam;

public class Member {
	private String name, uid, pwd, birth, div;

	
	Member(){
		
	}
	
	public Member(String name, String uid, String pwd, String birth, String div) {
		super();
		this.name = name;
		this.uid = uid;
		this.pwd = pwd;
		this.birth = birth;
		this.div = div;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}
	
}
