package com.eauto100.app.server.repair.service.impl;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.eauto100.app.server.framework.database.BaseSupport;
import com.eauto100.app.server.repair.service.IRepairService;


@Service("repairService")
public class RepairService extends BaseSupport<T> implements IRepairService {
	
	@Override
	public List getList() {
		String sql ="select * from app_repair_type";
		List list =  this.daoSupport.queryForList(sql);
		return list;
	}
}
