package com.eauto100.app.server.repair.model;

import java.sql.Date;

public class RepairType implements java.io.Serializable{
	private Integer repair_type_id;
	private String repair_type_name;
	private Date create_time;
	private Date update_time;
	public Integer getRepair_type_id() {
		return repair_type_id;
	}
	public void setRepair_type_id(Integer repair_type_id) {
		this.repair_type_id = repair_type_id;
	}
	public String getRepair_type_name() {
		return repair_type_name;
	}
	public void setRepair_type_name(String repair_type_name) {
		this.repair_type_name = repair_type_name;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public RepairType() {
		super();
	}
	
	
}
