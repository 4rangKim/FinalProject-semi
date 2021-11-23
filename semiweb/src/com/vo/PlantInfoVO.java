package com.vo;

import java.util.Date;

public class PlantInfoVO {
	public int infoNum;
	public int id;
	public int tem;
	public int humi;
	public int lux;
	public Date time;
	
	// 
	public PlantInfoVO() {
	}
	
	

	// insert
	public PlantInfoVO(int tem, int humi, int lux) {
		super();
		this.tem = tem;
		this.humi = humi;
		this.lux = lux;
	}
	// update
	public PlantInfoVO(int infoNum, int tem, int humi, int lux) {
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

	public int getTem() {
		return tem;
	}

	public void setTem(int tem) {
		this.tem = tem;
	}

	public int getHumi() {
		return humi;
	}

	public void setHumi(int humi) {
		this.humi = humi;
	}

	public int getLux() {
		return lux;
	}

	public void setLux(int lux) {
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
