package com.plant;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.PlantVO;

@org.springframework.stereotype.Service("plantservice")
public class PlantService implements Service<String, PlantVO> {

	@Resource(name="PlantDao")
	Dao<String,PlantVO> dao;
	
	@Override
	public void register(PlantVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
		
	}

	@Override
	public void modify(PlantVO v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public PlantVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<PlantVO> get() throws Exception {
		return dao.select();
	}

}
