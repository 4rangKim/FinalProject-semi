package com.plant;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.PlantMapper;
import com.vo.PlantVO;

@Repository("PlantDao")
public class PlantDao implements Dao<String, PlantVO> {
	
	@Autowired
	PlantMapper pm;

	@Override
	public void insert(PlantVO obj) throws Exception {
		pm.insert(obj);
	}

	@Override
	public void delete(String k) throws Exception {
		pm.delete(k);
	}

	@Override
	public void update(PlantVO v) throws Exception {
		pm.update(v);
	}

	@Override
	public PlantVO select(String k) throws Exception {
		return pm.select(k);
	}

	@Override
	public ArrayList<PlantVO> select() throws Exception {
		return pm.selectall();
	}
	
	
}
