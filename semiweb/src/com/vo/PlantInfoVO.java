package com.vo;

import java.util.Date;

public class PlantInfoVO {
	public int infoNum;
	public int id;
	public double tem;
	public double humi;
	public double lux;
	public Date time;
	
	// 기본 생성자
	public PlantInfoVO() {
	}

	// insert
	public PlantInfoVO(double tem, double humi, double lux) {
		super();
		this.tem = tem;
		this.humi = humi;
		this.lux = lux;
	}
	// update
	public PlantInfoVO(int infoNum, double tem, double humi, double lux) {
		super();
		this.infoNum = infoNum;
		this.tem = tem;
		this.humi = humi;
		this.lux = lux;
	}
	// selectAll
	public PlantInfoVO(int id) {
		super();
		this.id = id;
	}
	
	// getter & setter
	public int getInfoNum() {
		return infoNum;
	}

	public void setInfoNum(int infoNum) {
		this.infoNum = infoNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTem() {
		return tem;
	}

	public void setTem(double tem) {
		this.tem = tem;
	}

	public double getHumi() {
		return humi;
	}

	public void setHumi(double humi) {
		this.humi = humi;
	}

	public double getLux() {
		return lux;
	}

	public void setLux(double lux) {
		this.lux = lux;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	// toString
	@Override
	public String toString() {
		return "PlantInfoVo [infoNum=" + infoNum + ", id=" + id + ", tem=" + tem + ", humi=" + humi + ", lux=" + lux
				+ ", time=" + time + "]";
	}
}
