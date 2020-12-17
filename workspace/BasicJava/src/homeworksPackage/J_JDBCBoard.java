package homeworksPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			
			
			String sql = "select count(*) from tb_jdbc_board";
			ps  = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			rs.next();
			int totalSize=rs.getInt(1);
			int totalPage = (totalSize-1)/I_Board.PER_PAGE+1;

			Jmethod methods = new Jmethod();

			int page=1;
			while(true){
				methods.printBoard(page);
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
	
	public void printBoard(int page){
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select count(*) from tb_jdbc_board";
		try {
			ps  = J_JDBCBoard.con.prepareStatement(sql);
			rs = ps.executeQuery();	
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.printBar();
		System.out.println(" 번호	제목		작성자	작성일");
		this.printBar();

		System.out.printf("===================================[%d 페이지]==\n",page);
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

	public void read(int n){
//		HashMap<String,String> table = list.get(n-1);
//		this.printBar();
//		System.out.printf("[작성자] %s\t[작성일] %s\n",table.get("writer"),table.get("date"));
//		System.out.printf("[제목] %s\n\n",table.get("title"));
//		System.out.printf("[내용] %s\n",table.get("contents"));
//		this.printBar();
	}

	public void edit(int n,ArrayList<HashMap<String,String>> list){
//		HashMap<String,String> table = list.get(n-1);
//		System.out.print("수정할 제목을 입력해주세요.\n>");		table.put("title",I_Board.sc.nextLine());
//		System.out.print("수정할 내용을 입력해주세요.\n>");		table.put("contents",I_Board.sc.nextLine());
	}

	public void mainMenu(int page,int totalPage){
		System.out.print("(1)조회 (2)등록 ");
		if(page != 1)				System.out.print("(3)이전페이지 ");
		if(page != totalPage)		System.out.print("(4)다음페이지 ");
		System.out.print("(0)종료\n>");
	}

	public void contents(){
//		System.out.print("조회할 글 번호 입력 > ");
//		try{
//			int select = Integer.parseInt(I_Board.sc.nextLine());
//			if(select<=list.size() && select!=0)
//				this.read(select, list);
//			else{
//				System.out.print("해당하는 글 번호가 없습니다.\n");
//				return;
//			}
//			System.out.print("(1)뒤로가기 (2)편집 (3) 글 삭제\n>");
//			switch(I_Board.sc.nextLine()){
//			case "1":												break;
//			case "2":	this.edit(select,list);						break;
//			case "3":	list.remove(select-1);						break;
//			default:	System.out.println("올바르지 않은 입력입니다.");		break;
//			}
//		}catch(NumberFormatException e){
//		}

	}
	void printBar(){
		System.out.println("=============================================");
	}


}

