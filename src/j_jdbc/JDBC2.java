package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PSH";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "insert into emp values(?,?,?,?,?,?,?,)";
			ps  = con.prepareStatement(sql);
			
			ps.setString(1, "7369");
			ps.setInt(2, 7369);
			ps.setString(3, "7369");
			ps.setString(4, "7369");
			ps.setString(5, "7369");
			ps.setString(6, "7369");
			ps.setString(7, "7369");
			ps.setString(8, "7369");
			
			
			int result = ps.executeUpdate();
			
//			ResultSetMetaData md = rs.getMetaData(); // 메타데이터 : 데이터에 대한 데이터
			
//			int columnCount = md.getColumnCount();
			
			while(rs.next()){
				System.out.println("영향받은 행의 수" + result);
			}
			
			                                                                           
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null) try{ rs.close(); } catch(Exception e){}
			if(ps != null) try{ ps.close(); } catch(Exception e){}
			if(con != null) try{ con.close(); } catch(Exception e){}
		}

	}

}
