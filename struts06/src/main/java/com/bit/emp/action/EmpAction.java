package com.bit.emp.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bit.emp.model.entity.EmpVo;
import com.opensymphony.xwork2.ModelDriven;

public class EmpAction implements ModelDriven<EmpVo>{
	EmpVo bean = new EmpVo();
	List<EmpVo> list = new ArrayList<EmpVo>();
	
	public EmpAction() {
		System.out.println("Action 객체 생성");
	}
	
	public void setBean(EmpVo bean) {
		this.bean = bean;
	}
	public EmpVo getBean() {
		return bean;
	}
	
	public void setList(List<EmpVo> list) {
		this.list = list;
	}
	
	public List<EmpVo> getList() {
		return list;
	}
	
	public String addList() {
		list.add(bean);
		return "success";
	}
	
	public String empList() {
//		list = new ArrayList<EmpVo>();
//		list.add(new EmpVo(1,"user1", "test1", new Timestamp(System.currentTimeMillis()),1000));
//		list.add(new EmpVo(2,"user2", "test2", new Timestamp(System.currentTimeMillis()),1000));
//		list.add(new EmpVo(3,"user3", "test3", new Timestamp(System.currentTimeMillis()),1000));
//		list.add(new EmpVo(4,"user4", "test4", new Timestamp(System.currentTimeMillis()),1000));
//		list.add(new EmpVo(5,"user5", "test5", new Timestamp(System.currentTimeMillis()),1000));
		return "success";
	}
	@Override
	public EmpVo getModel() {
		return bean;
	}
}
