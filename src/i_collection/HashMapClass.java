package i_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * Object put(Object key, Object value) : 지정된 키와 값을 저장한다.
		 * Object remove(Object key) : 지정된 키로 저장된 값을 제거한다.
		 * Object get(Object key) : 지정된 키의 값(없으면 null)을 반환한다.
		 * Set keySet() : 저장된 모든 키를 Set으로 반환한다.
		 */
		
//		HashMap<String, Object> map = new HashMap<>();
//		
//		map.put("a", 10);
//		map.put("b", "홍길동");
////		map.put("c", new Scanner(System.in));	// map 에는 순서라는 개념이 존재하지 않음
//		
//		System.out.println(map);
//		map.put("b","이순신");//덮어쓴다
//		System.out.println(map);
//		map.remove("a");
//		map.put("a",20);
//		System.out.println(map);
//		
//		Object value = map.get("b");
//		System.out.println(value);
//		
//		int value1 = (Integer)map.get("a");
//		String value2 = (String)map.get("b");
//		
//		Set<String> keys = map.keySet(); // 저장된 모든 키
//		
//		for(String key : keys){
//			System.out.println(key + " : " + map.get(key));
//		}
//		
		// 회원 테이블
		// 아이디, 비밀번호, 이름, 전화번호
		/*
		 * id		password	name	tel
		 * admin	admin123	관리자	010-1234-5678
		 */
		ArrayList<HashMap<String,String>> table = new ArrayList<>();
		HashMap<String,String> user = new HashMap<>();
		user.put("id", "admin");
		user.put("password", "admin123");
		user.put("name","관리자");
		user.put("tel","010-1234-5678");
		table.add(user);
	
		HashMap<String,String> user2 = new HashMap<>();
		user2.put("id", "sehyun");
		user2.put("password", "sehyun123");
		user2.put("name","sehyun");
		user2.put("tel","010-1111-1111");
		table.add(user2);
		
		for(HashMap<String,String> tables : table){
			Set<String> keys = tables.keySet(); 
			for(String key : keys){
				System.out.print(key + " : " + tables.get(key)+"\t");
			}
			System.out.println();
		}

		
	}
	
	
	
}
