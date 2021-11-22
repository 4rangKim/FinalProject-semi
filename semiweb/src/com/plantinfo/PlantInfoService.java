package com.plantinfo;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.PlantInfoVO;

@org.springframework.stereotype.Service("plantinfoservice")
public class PlantInfoService implements Service<String, PlantInfoVO> {

	@Resource(name="PlantInfoDao")
	Dao<String,PlantInfoVO> dao;

	@Override
	public void register(PlantInfoVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(PlantInfoVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public PlantInfoVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<PlantInfoVO> get() throws Exception {
		return dao.select();
	}
}
