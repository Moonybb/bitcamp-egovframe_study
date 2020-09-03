package com.bit.dept.action;

import com.bit.dept.model.DeptDao;
import com.bit.dept.model.entity.DeptVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class AddAction implements Action, ModelDriven<DeptVo>, Preparable {
	DeptVo bean;

	public void setBean(DeptVo bean) {
		this.bean = bean;
	}
	public DeptVo getBean() {
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		bean=new DeptVo();
	}

	@Override
	public DeptVo getModel() {
		return bean;
	}

	@Override
	public String execute() throws Exception {
		new DeptDao().insertOne(bean);
		return Action.SUCCESS;
	}

}