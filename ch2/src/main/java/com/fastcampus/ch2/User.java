package com.fastcampus.ch2;

import java.util.Date;

public class User {
	private String name;
	


	private String id;
	private String pwd;
	private String email;
	private Date birth;
	private String sns;

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", pwd=" + pwd + ", email=" + email + ", birth=" + birth + ", sns="
				+ sns + ", getName()=" + getName() + ", getId()=" + getId() + ", getPwd()=" + getPwd() + ", getEmail()="
				+ getEmail() + ", getBirth()=" + getBirth() + ", getSns()=" + getSns() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getSns() {
		return sns;
	}
	public void setSns(String sns) {
		this.sns = sns;
	}

}
