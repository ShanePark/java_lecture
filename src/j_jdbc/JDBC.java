package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		
		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		String sql = "select * from member where mem_id = 'a001'";			//
		Map<String, Object> map = jdbc.SelectOne(sql);             		 	//  method 1 test
		System.out.println("test1 "+map);                                   //
		
		sql = "select * from member where mem_id = ?";					//
		List<Object> param = new ArrayList<>();							//
		param.add("a001");												//
		Map<String, Object> map2 = jdbc.SelectOne(sql, param);          //  method 2 test
		System.out.println("test2 "+map2);                              //
		
		sql = "select * from member";                                     //
		List<Map<String, Object>> list2 = jdbc.selectList(sql);		      // method 3 test
		System.out.println("test3 "+list2);                               //
		
		sql = "select * from member where mem_id = ?";                    //
		List<Object> param2 = new ArrayList<>();                           //
		param2.add("a001");                                                //	method 4 test
		List<Map<String, Object>> list = jdbc.selectList(sql, param2);     //
		System.out.println("test4 "+list);                                  //
		
		sql = "update tb_jdbc_board set title='수정완료' where board_no = 7";
		System.out.println("test 5 "+ jdbc.update(sql));					// method 5 test
		                                                                  
		sql = "update tb_jdbc_board set title='수정완료2' where board_no = ?";   //
		List<Object> param3 = new ArrayList<>();                             //
		param3.add(7);                                                       //	method 6 test
		System.out.println("test 6 "+ jdbc.update(sql,param3));              //

		
		// 데이터 베이스 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PSH";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		
//		try {
//			con = DriverManager.getConnection(url, user, password);
//			
//			sql = "select * from member";
//			ps  = con.prepareStatement(sql);
//			rs = ps.executeQuery();	
//			
//			String sql2 = "select count(*) from ALL_COL_COMMENTS where TABLE_NAME = 'MEMBER'";
//			ps2 = con.prepareStatement(sql2);
//			rs2 = ps2.executeQuery();
//			
//			rs2.next();
//			int size = rs2.getInt(1);
//			while(rs.next()){     
//				for(int i=1; i<=size ; i++){
//					System.out.print(rs.getString(i)+"\t");
//				}
//				System.out.println();  
//			}                                                                          	       
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally{
//			if(rs != null) try{ rs.close(); } catch(Exception e){}
//			if(ps != null) try{ ps.close(); } catch(Exception e){}
//			if(con != null) try{ con.close(); } catch(Exception e){}
//		}

	}
}
