package com.bit.framework.model.entity;

public class DeptVo {
	private int deptno;
	private String dname,loc;
	
	public DeptVo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DeptVo [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}

	public DeptVo(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
}
