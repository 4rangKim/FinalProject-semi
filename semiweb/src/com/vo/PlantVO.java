package com.vo;

import java.util.Date;

public class PlantVO {
	public int id;
	public String name;
	public Date join_date;
	
	// 기본 생성자 
	public PlantVO() {
	}
	
	// 전체 생성자
	public PlantVO(int id, String name, Date join_date) {
		super();
		this.id = id;
		this.name = name;
		this.join_date = join_date;
	}
	
	// insert
	public PlantVO(String name) {
		super();
		this.name = name;
	}
	
	// update
	public PlantVO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	// getter & setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	
	// toString
	@Override
	public String toString() {
		return "PlantVo [id=" + id + ", name=" + name + ", join_date=" + join_date + "]";
	}
}
