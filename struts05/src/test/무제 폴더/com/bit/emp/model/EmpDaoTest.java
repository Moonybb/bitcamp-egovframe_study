package com.bit.emp.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.bit.emp.model.entity.EmpVo;

public class EmpDaoTest {

	@Test
	public void testGetConnection() throws Exception {
		
		EmpDao dao = new EmpDao();
		
//		기존 사용 방식
//		System.out.println(dao!=null);

//		Junit 활용 방식
		Connection conn = dao.getConnection();
		Assert.assertNotNull(conn);
	}
	
	@Test
	public void testSelectAll() throws Exception {
		EmpDao dao = new EmpDao();
		Assert.assertSame(5,dao.selectAll().size());
//		if(dao.selectAll().size()!=6)Assert.fail();
	}

	@Test
	public void testSelectOne() throws Exception{
		EmpVo target = new EmpVo(1, "tester1", "test1", null, 1000);
		EmpDao dao = new EmpDao();
		Assert.assertEquals(target, dao.selectOne(target.getSabun()));
	}
}
