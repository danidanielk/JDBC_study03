package com.kim.db.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaniDBManager {

	
	public static Connection connect() throws SQLException{
		String addr = "jdbc:oracle:thin:@192.168.123.100:1521:xe";
		return DriverManager.getConnection(addr, "danidani", "1");
	}
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();				//C U D 때는 필요없고 R (select) 때만 필요
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
