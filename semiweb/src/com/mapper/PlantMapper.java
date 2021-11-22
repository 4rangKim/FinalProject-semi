package com.mapper;

import java.util.ArrayList;

import com.vo.PlantVO;

public interface PlantMapper {
	public void insert(PlantVO v);
	public void delete(String k);
	public void update(PlantVO v);
	public PlantVO select(String k);
	public ArrayList<PlantVO> selectall();
}



