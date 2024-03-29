package b_operator;

public class ComparingOperator {

	public static void main(String[] args) {
		/*
		 * 비교연산자
		 * - <,>,<=,>=,==,!=
		 * - 문자열 비교 : equals()
		 * 
		 */

		int x = 10;
		int y = 20;
		boolean b = x < y; // 비교 연산자의 연산 결과는 boolean 이다.
//		System.out.println(b);
		
		b = x <= y - 15; // 산술 연산 후 비교 연산을 수행 한다.
//		System.out.println(b);
		
		String str1 = "abc";
		String str2 = "abc";
		b = str1 == str2; // 문자열의 내용이 아닌 주소를 비교 한 것이다.
//		System.out.println(b);
		
		// String 의 내용을 비교하기 위해서는 equals() 메서드를 사용한다.
//		b = str1.equals(str2);
//		System.out.println(b);
//		b = !str1.equals(str2);
//		System.out.println(b);
		
		// 다음의 문장들을 코드로 작성 해 주세요.
		// 1. x 는 y 보다 작거나 같다.
		// 2. x + 5 와 y 는 같다.
		// 3. y는 홀수이다.
		// 4. "기본형" 과 "참조형" 은 다르다.
		
		System.out.println("x값:"+x+" y값:"+y);
		b = x<=y;
		System.out.println("1. x 는 y 보다 작거나 같다."+b);
		b = x+5 == y;
		System.out.println("2. x + 5 와 y 는 같다."+b);
		b = y%2 == 1;
		System.out.println("3. y는 홀수이다."+b);
		b = !"기본형".equals("참조형");
		System.out.println("4. '기본형' 과 '참조형' 은 다르다."+b);
		
		
	}

}
