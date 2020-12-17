package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	public static void main(String[] args) {
		
		/*
		 * JDBC( Java Database Connectivity)
		 * - 자바와 데이터베이스를 연결해주는 라이브러리
		 * - ojdbc : 오라클 JDBC
		 * 
		 * JDBC 작성 단계
		 * 1. Connection 생성
		 * 2. Statement 생성(쿼리)
		 * 3. Query 실행
		 * 4. ResultSet 에서 결과 추출 (Select인 경우)
		 * 5. ResultSet, Statement, Connection 닫기
		 */
		
		// 데이터 베이스 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PSH";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select * from member";
			ps  = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			
			String sql2 = "select count(*) from ALL_COL_COMMENTS where TABLE_NAME = 'MEMBER'";
			ps2 = con.prepareStatement(sql2);
			rs2 = ps2.executeQuery();
			
			rs2.next();
			int size = rs2.getInt(1);
			while(rs.next()){     
				for(int i=1; i<=size ; i++){
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();  
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
