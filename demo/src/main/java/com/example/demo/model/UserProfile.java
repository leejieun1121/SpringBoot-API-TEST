package com.example.demo.model;

public class UserProfile {
	//테이블 이름 = 객체 이름,컬럼 이름 = 멤버 변수 이름 
	//멤버 변수들을 private +게터와 세터 
	private String id;
	private String name;
	private String phone;
	private String address;
	
	public UserProfile(String id, String name, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	

}
