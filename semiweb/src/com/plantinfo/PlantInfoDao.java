package com.plantinfo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.PlantInfoMapper;
import com.vo.PlantInfoVO;

@Repository("PlantInfoDao")
public class PlantInfoDao implements Dao<String, PlantInfoVO> {
	
	@Autowired
	PlantInfoMapper pim;

	@Override
	public void insert(PlantInfoVO obj) throws Exception {
		pim.insert(obj);
	}

	@Override
	public void delete(String k) throws Exception {
		pim.delete(k);
	}

	@Override
	public void update(PlantInfoVO v) throws Exception {
		pim.update(v);
	}

	@Override
	public PlantInfoVO select(String k) throws Exception {
		return pim.select(k);
	}

	@Override
	public ArrayList<PlantInfoVO> select() throws Exception {
		return pim.selectall();
	}
	
	
}
