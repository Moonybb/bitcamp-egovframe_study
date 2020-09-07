package com.bit.framework.emp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.bit.framework.emp.model.entity.EmpVo;

public class EmpDao extends JdbcDaoSupport{
	
	public EmpDao() {
	}
	
	
//	private String driver="com.mysql.cj.jdbc.Driver";
//	private String url;
//	private String user = "scott";
//	private String password = "tiger";
	
//	public EmpDao(String driver, String url, String user, String password) {
//		this.driver = driver;
//		this.url = url;
//		this.user = user;
//		this.password = password;
//		System.out.println("create DAO...");
//		try {
//			Class.forName(driver);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	public List<EmpVo> selectAll() throws SQLException {
		String sql = "select * from emp";
		List<EmpVo> list = new ArrayList<EmpVo>();
		try (
//				Connection conn = DriverManager.getConnection(url, user, password);
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				) {
			while(rs.next())
				list.add(new EmpVo(
							rs.getInt("sabun"),rs.getString("name"),rs.getString("sub")
							,rs.getTimestamp("nalja"),rs.getInt("pay")
						));
		}
		return list;
	}

	public void insertOne(String name, String sub, int pay) throws SQLException {
		String sql = "insert into emp (name,sub,nalja,pay) values (?,?,now(),?)";
		Object[] params = new Object[] {name, sub, pay};
		getJdbcTemplate().update(sql, params);
		
//		try(
////				Connection conn = DriverManager.getConnection(url, user, password);
//				Connection conn = getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				){
//			pstmt.setString(1, name);
//			pstmt.setString(2, sub);
//			pstmt.setInt(3, pay);
//			pstmt.executeUpdate();
//		}
	}

	public EmpVo selectOne(int parseInt) throws SQLException {
		String sql="select * from emp where sabun=?";
		try(
//				Connection conn=DriverManager.getConnection(url, user, password);
				Connection conn = getConnection();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				){
			pstmt.setInt(1, parseInt);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				return new EmpVo(
						rs.getInt("sabun"),rs.getString("name"),rs.getString("sub")
						,rs.getTimestamp("nalja"),rs.getInt("pay")
						);
		}
		return null;
	}

	public int updateOne(int sabun, String name, String sub, int pay) throws SQLException {
		String sql = "update emp set name=?, sub=?, pay=? where sabun=?";
		try(
//				Connection conn = DriverManager.getConnection(url,user,password);
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setInt(4, sabun);
			pstmt.setString(1, name);
			pstmt.setString(2, sub);
			pstmt.setInt(3, pay);
			return pstmt.executeUpdate();
		
		}
	}
}
