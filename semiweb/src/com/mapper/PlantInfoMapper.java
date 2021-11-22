package com.mapper;

import java.util.ArrayList;

import com.vo.PlantInfoVO;

public interface PlantInfoMapper {
	public void insert(PlantInfoVO v);
	public void delete(String k);
	public void update(PlantInfoVO v);
	public PlantInfoVO select(String k);
	public ArrayList<PlantInfoVO> selectall();
}



