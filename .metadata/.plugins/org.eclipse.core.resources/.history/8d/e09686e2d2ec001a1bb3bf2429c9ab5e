package com.bit.emp.model.entity;

public class EmpVO {
	int sabun;
	String name;
	
	public EmpVO(){
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sabun;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpVO other = (EmpVO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sabun != other.sabun)
			return false;
		return true;
	}
	public EmpVO(int sabun, String name) {
		super();
		this.sabun = sabun;
		this.name = name;
	}
	@Override
	public String toString() {
		return "EmpVo [sabun=" + sabun + ", name=" + name + "]";
	}
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
