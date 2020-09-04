package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.model.entity.DeptVo;

public class DeptDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/xe?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
	String user="scott";
	String password="tiger";
	
	public List<DeptVo> selectAll() throws ClassNotFoundException, SQLException{
		String sql="select * from dept";
		List<DeptVo> list=new ArrayList<>();
		Class.forName(driver);
		try(
				Connection conn=DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				){
			while(rs.next())
				list.add(new DeptVo(
						rs.getInt(1),rs.getString(2),rs.getString(3)
						));
		}
		
		return list;
	}
}
