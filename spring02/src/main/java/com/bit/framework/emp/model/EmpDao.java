package com.bit.framework.emp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.framework.emp.model.entity.EmpVo;

public class EmpDao {

	private String url="jdbc:mysql://localhost:3306/xe?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
	private String user = "scott";
	private String password = "tiger";
	
	public EmpDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<EmpVo> selectAll() throws SQLException {
		String sql = "select * from emp";
		List<EmpVo> list = new ArrayList<EmpVo>();
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
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
}
