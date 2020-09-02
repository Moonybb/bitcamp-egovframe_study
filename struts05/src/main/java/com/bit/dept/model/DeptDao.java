package com.bit.dept.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.bit.dept.model.entity.DeptVo;

public class DeptDao {
	Logger log=Logger.getGlobal();
	private String url="jdbc:mysql://localhost:3306/xe?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
	private String user="root";
	private String password="mysql";
	Connection conn;
	
	public DeptDao() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url, user, password);
		log.info(conn.toString());
	}
	
	public List<DeptVo> selectAll() throws SQLException{
		String sql="select * from dept order by deptno desc";
		List<DeptVo> list=new ArrayList<>();
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				DeptVo bean = new DeptVo(
						rs.getInt(1),rs.getString(2),rs.getString(3)
						);
				log.info(bean.toString());
				list.add(bean);
			}
		}finally {
			if(conn!=null)conn.close();
		}
		return list;
	}

}