package com.bit.emp.action;

import com.bit.emp.model.EmpDao;
import com.bit.emp.model.entity.EmpVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class DeleteAction implements Action, Preparable, ModelDriven<EmpVo>{
	EmpVo bean;
	
	public void setBean(EmpVo bean) {
		this.bean = bean;
	}
	
	public EmpVo getBean() {
		return bean;
	}
	
	@Override
	public String execute() throws Exception {
		new EmpDao().deleteOne(bean.getSabun());
		return Action.SUCCESS;
	}

	@Override
	public EmpVo getModel() {
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		bean = new EmpVo();
	}

	
}
