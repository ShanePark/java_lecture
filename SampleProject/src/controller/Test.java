package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import util.ScanUtil;



public class Test {

	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		String sql = "select * from restaurants where cousine=?";
		System.out.print("검색할 음식 스타일 > ");
		String cousines=ScanUtil.nextLine();
		List<Object> p = new ArrayList<>();
		p.add(cousines);
		List<Map<String, Object>> result = jdbc.selectList(sql,p);
		System.out.println("================================================================");
		for(int i=0; i<result.size(); i++){
			String resName = result.get(i).get("RES_NAME").toString();
			String cousine = result.get(i).get("COUSINE").toString();
			String add = result.get(i).get("ADD1").toString();
			String distance = result.get(i).get("DISTANCE").toString();
			String time = "";
			if(result.get(i).get("OPEN_TIME")==null) time="영업시간정보없음";
			else time = result.get(i).get("OPEN_TIME").toString()+"~"+result.get(i).get("CLOSE_TIME").toString();
			System.out.printf("이름:%s 요리:%s 주소:%s 거리:%sm %s\n",resName,cousine,add,distance,time);
		}
		System.out.println("================================================================");

	}

}
