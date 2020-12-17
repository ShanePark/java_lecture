package homeworksPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 *  오라클 데이터베이스에 게시판 테이블을 생성 하고, 게시판 프로그램을 만들어주세요.
 *  테이블 : TB_JDBC_BOARD
 *  컬럼 : BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE
 */
public class J_JDBCBoard {
	static int PER_PAGE = 4;	// numbers of contents on a page
	static Scanner sc = new Scanner(System.in);
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "PSH";
	static String password = "java";
	static Connection con = null;


	public static void main(String[] args) {
		Jmethod methods = new Jmethod();
		int page=1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, password);

			while(true){
				int totalSize = methods.getTotalSize();
				int totalPage = (totalSize-1)/I_Board.PER_PAGE+1;

				methods.printBoard(page,totalPage,totalSize);
				methods.mainMenu(page,totalPage);

				switch(I_Board.sc.nextLine()){
				case "1":
					methods.contents();
					break;
				case "2":
					int temp = totalPage;
					methods.register();
					if(totalPage != temp)	// if total page numbers is changed, page--
						page--;
					break;
				case "3":
					if(page != 1)
						page--;
					break;
				case "4":
					if(page!= totalPage)
						page++;
					break;
				case "0":
					System.out.println("[프로그램 종료 완료]");
					System.exit(0);
				default :
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요\n>");
					break;
				}

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


class Jmethod{

	public int getTotalSize(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from tb_jdbc_board";
		try {
			ps  = J_JDBCBoard.con.prepareStatement(sql);
			rs = ps.executeQuery();	
			rs.next();

			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	public void printBoard(int page, int totalPage,int totalSize){
		PreparedStatement ps = null;
		ResultSet rs = null;
		this.printBar();
		System.out.println(" 번호	제목		작성자	작성일");
		printBar();

		String sql = "select * from tb_jdbc_board where board_no between ? and ? order by board_no desc";
		try {
			ps = J_JDBCBoard.con.prepareStatement(sql);
			int startPost = totalSize-page*I_Board.PER_PAGE+1;
			if(page == totalPage){
				startPost = 1;
			}
			ps.setInt(1, startPost);
			ps.setInt(2, startPost+I_Board.PER_PAGE-1);

			rs = ps.executeQuery();	
			SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");

			while(rs.next()){
				int board_no = rs.getInt("board_no");		
				String title = rs.getString("title");		
				String user_id = rs.getString("user_id");		
				String reg_date = format1.format(rs.getDate("reg_date"));
				System.out.printf("%d\t%-10s\t%s\t%s\n", board_no,title,user_id,reg_date);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(totalPage==1){
			for(int i=getTotalSize(); i<J_JDBCBoard.PER_PAGE; i++ )
				System.out.println();
		}
		System.out.printf("===================================[%d 페이지]==\n",page);
	}

	public void contents(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.print("조회할 글 번호 입력 > ");
		int select = Integer.parseInt(I_Board.sc.nextLine());
		this.printBar();
		System.out.println(" 번호	제목		작성자	작성일");
		printBar();

		String sql = "select * from tb_jdbc_board where board_no = ?";
		try {
			ps = J_JDBCBoard.con.prepareStatement(sql);
			ps.setInt(1, select);
			rs = ps.executeQuery();	
			rs.next();
			SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
			String reg_date = format1.format(rs.getDate("reg_date"));

			System.out.printf("[작성자] %s\t[작성일] %s\n",rs.getString("user_id"),reg_date);
			System.out.printf("[제목] %s\n\n",rs.getString("title"));
			System.out.printf("[내용] %s\n",rs.getString("content"));
			this.printBar();
			System.out.print("(1)뒤로가기 (2)편집 (3) 글 삭제\n>");
			
			switch(J_JDBCBoard.sc.nextLine()){
			case "1":
				break;
			case "2":
				editPost(rs.getInt("board_no"));
				break;
			case "3":
				deletePost(rs.getInt("board_no"));
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			System.out.print("해당하는 글 번호가 없습니다.\n");
		}
	}
	
	public void editPost(int board_no){
		System.out.print("수정할 제목을 입력해주세요.\n>");
		
		System.out.print("수정할 내용을 입력해주세요.\n>");		
	}
	public void deletePost(int board_no){
		PreparedStatement ps = null;
		String sql = "delete from tb_jdbc_board where board_no = ?";
		try {
			ps = J_JDBCBoard.con.prepareStatement(sql);
			ps.setInt(1, board_no);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void register(){
		//		HashMap<String,String> post = new HashMap<>();
		//		System.out.print("작성할 글 제목을 써주세요 : ");			post.put("title",I_Board.sc.nextLine());
		//		System.out.print("작성할 글 내용을 써주세요 : ");			post.put("contents",I_Board.sc.nextLine());
		//		System.out.print("작성자 이름을 써주세요 : ");			post.put("writer",I_Board.sc.nextLine());
		//		System.out.print("작성 일자를 써주세요(MM/DD) : ");		post.put("date",I_Board.sc.nextLine());
		//		list.add(post);
		//		System.out.printf("[%s]을(를) 성공적으로 등록했습니다. 계속 하려면 [Enter]키를 눌러주세요..",post.get("title"));	I_Board.sc.nextLine();
	}


	public void mainMenu(int page,int totalPage){
		System.out.print("(1)조회 (2)등록 ");
		if(page != 1)				System.out.print("(3)이전페이지 ");
		if(page != totalPage)		System.out.print("(4)다음페이지 ");
		System.out.print("(0)종료\n>");
	}


	void printBar(){
		System.out.println("=============================================");
	}


}

