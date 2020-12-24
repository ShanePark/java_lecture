package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import util.ScanUtil;



public class Test {

	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		String sql = "select * from restaurants where res_id=?";
		System.out.print("검색할 레스토랑 id > ");
		String nick=ScanUtil.nextLine();
		List<Object> p = new ArrayList<>();
		p.add(nick);
		Map<String, Object> result = jdbc.SelectOne(sql,p);
		System.out.printf("매장명:%s /%s/ %s/ 거리 %sm (%s~%s) ",result.get("RES_NAME"),result.get("COUSINE"),result.get("ADD1"),result.get("DISTANCE"),result.get("OPEN_TIME"),result.get("CLOSE_TIME"));

	}

}