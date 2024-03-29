package homeworksPackage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class J_BoardWithUtil {
	static final int PER_PAGE = 4;	// numbers of contents on a page
	static Scanner sc = new Scanner(System.in);
	static JDBCUtil jdbc = JDBCUtil.getInstance();

	public static void main(String[] args) {
		Method methods = new Method();
		int page=1;
		
		while(true){
			int totalSize = methods.getTotalSize();
			int totalPage = (totalSize-1)/J_BoardWithUtil.PER_PAGE+1;
			methods.printBoard(page, totalSize, totalPage);

			switch(I_Board.sc.nextLine()){
			case "1":
				int temp = totalPage;
				methods.contents();
				totalSize = methods.getTotalSize();
				totalPage = (totalSize-1)/J_BoardWithUtil.PER_PAGE+1;		
				if(totalPage != temp && page != 1)	// if total page number is changed, page--
					page--;
				break;
			case "2":
				methods.register();
				break;
			case "3":
				if(page != 1) page--;
				break;
			case "4":
				if(page!= totalPage) page++;
				break;
			case "0":
				System.out.println("[프로그램 종료 완료]");
				System.exit(0);
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요\n>");
				break;
			}
		}
	}
}

class Method{
	
	public void register(){	
		HashMap<String,String> post = new HashMap<>();
		String sql = "insert into TB_JDBC_BOARD values(?,?,?,?,sysdate)";
		List<Object> parameters = new ArrayList<>(); 
		parameters.add(newNum());
		System.out.print("작성할 글 제목을 써주세요 : ");			post.put("title",I_Board.sc.nextLine());	parameters.add(post.get("title"));
		System.out.print("작성할 글 내용을 써주세요 : ");			post.put("contents",I_Board.sc.nextLine());	parameters.add(post.get("contents"));
		System.out.print("작성자 이름을 써주세요 : ");			post.put("writer",I_Board.sc.nextLine());	parameters.add(post.get("writer"));
		
		J_BoardWithUtil.jdbc.update(sql,parameters); 
		System.out.printf("[%s]을(를) 성공적으로 등록했습니다. 계속 하려면 [Enter]키를 눌러주세요..",post.get("title"));	I_Board.sc.nextLine();
	}
	
	public int newNum(){	
		String sql = "select nvl(max(board_no),0)+1 as new from tb_jdbc_board";
		Map<String, Object> map = J_BoardWithUtil.jdbc.SelectOne(sql);     
		
		return ((BigDecimal)map.get("NEW")).intValue();
	}
	
	public void editPost(int board_no){
		System.out.print("수정할 제목을 입력해주세요.\n>");
		String sql = "update tb_jdbc_board set title=? where board_no = ?";
		String str = J_JDBCBoard.sc.nextLine();
		
		List<Object> parameters = new ArrayList<>();                             
		parameters.add(str);             
		parameters.add(board_no);
		J_BoardWithUtil.jdbc.update(sql,parameters);

		System.out.print("수정할 내용을 입력해주세요.\n>");	
		sql = "update tb_jdbc_board set content=? where board_no = ?";
		str = J_JDBCBoard.sc.nextLine();
		
		List<Object> parameters2 = new ArrayList<>();                             
		parameters2.add(str);             
		parameters2.add(board_no);
		J_BoardWithUtil.jdbc.update(sql,parameters2);  
	}
	
	public void contents(){
		System.out.print("조회할 글 번호 입력 > ");
		int select = Integer.parseInt(I_Board.sc.nextLine());

		String sql = "select * from tb_jdbc_board where board_no = ?";
		List<Object> parameters = new ArrayList<>();							
		parameters.add(select);												
		Map<String, Object> table = J_BoardWithUtil.jdbc.SelectOne(sql, parameters);          

		try{
			String reg_date = table.get("REG_DATE").toString().substring(0,19);
			printBar();
			System.out.printf("[작성자] %s\t[작성일] %s\n",table.get("USER_ID"),reg_date);
			System.out.printf("[제목] %s\n\n",table.get("TITLE"));
			System.out.printf("[내용] %s\n",table.get("CONTENT"));
			printBar();
			System.out.print("(1)뒤로가기 (2)편집 (3) 글 삭제\n>");
			int boardNumber=Integer.parseInt(table.get("BOARD_NO").toString());
			switch(J_JDBCBoard.sc.nextLine()){
			case "1":								break;
			case "2":	editPost(boardNumber);		break;
			case "3":	deletePost(boardNumber);	break;
			default:								break;
			}
		}catch (Exception e){
			System.out.println("에러! 입력한 번호에 해당 하는 글이 없음.");
		}
	}
	
	
	public void deletePost(int board_no){
		String sql = "delete from tb_jdbc_board where board_no = ?";
		List<Object> parameters = new ArrayList<>();                             
		parameters.add(board_no);   
		J_BoardWithUtil.jdbc.update(sql,parameters);
	}
	
	public void printBoard(int page, int totalSize, int totalPage){
		printBar();
		System.out.println(" 번호	제목		작성자	작성일");
		printBar();
		int startPost = totalSize-page*J_BoardWithUtil.PER_PAGE+1;
		if(page == totalPage) startPost = 1;

		String sql = "select a.* "
					 + "from (select rownum rn, tb_jdbc_board.* "
					 		 + "from tb_jdbc_board "
					 	  +"order by board_no) a "
				    + "where a.rn between ? and ? "
			   	 + "order by a.rn desc";

		List<Object> parameters = new ArrayList<>();                           
		parameters.add(startPost);
		parameters.add(startPost+J_BoardWithUtil.PER_PAGE-1);
		List<Map<String, Object>> list = J_BoardWithUtil.jdbc.selectList(sql, parameters);    

		int lists=0;	// variable to count the number of contents on the page
		for(int i=0; i<list.size(); i++){
			Map<String,Object> table = list.get(i);
			int board_no = ((BigDecimal)table.get("BOARD_NO")).intValue();
			String title = table.get("TITLE").toString();
			String user_id = table.get("USER_ID").toString();
			String reg_date = (table.get("REG_DATE").toString()).substring(0, 10);
			
			System.out.printf("%2d\t",board_no);
			System.out.printf("%-14s\t",title);
			System.out.print(user_id+"\t"+reg_date+"\n");
			lists++;
		}
		for(int i=lists;i<J_BoardWithUtil.PER_PAGE;i++)	 	// line up
			System.out.println();					// 
		System.out.printf("=================================[%d/%d 페이지]==\n",page,totalPage);
		System.out.print("(1)조회 (2)등록 ");
		if(page != 1)				System.out.print("(3)이전페이지 ");
		if(page != totalPage)		System.out.print("(4)다음페이지 ");
		System.out.print("(0)종료\n>");
	}

	public int getTotalSize(){
		String sql = "select count(*) from tb_jdbc_board";
		Map<String, Object> map = J_BoardWithUtil.jdbc.SelectOne(sql);
		int size = ((BigDecimal)map.get("COUNT(*)")).intValue();
		return size;
	}

	void printBar(){System.out.println("=============================================");}

}
