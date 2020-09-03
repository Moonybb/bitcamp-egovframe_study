package com.bit.emp.action;

import com.bit.emp.model.EmpDao;
import com.bit.emp.model.entity.EmpVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class AddAction implements Action, ModelDriven<EmpVo>, Preparable{
	EmpVo bean;
	
	public EmpVo getBean() {
		return bean;
	}
	
	public void setBean(EmpVo bean) {
		this.bean = bean;
	}

	@Override
	public void prepare() throws Exception {
		bean = new EmpVo();
	}
	
	@Override
	public EmpVo getModel() {
		return bean;
	}
	
	@Override
	public String execute() throws Exception {
		new EmpDao().insertOne(bean);;
		return Action.SUCCESS;
	}
}
