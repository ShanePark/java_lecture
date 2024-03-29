package a_variable; /*클래스의 위치 */

import java.util.Scanner;


public class Variable { /*클래스 : 변수와 메서드로 구성*/

	public static void main(String[] args) { /* 메서드 -  () 가 붙은 것 */
		// 메서드 : 명령문의 집합
		// main 메서드 : 프로그램의 시작과 끝
		// 주석 : 프로그램 코드로 인식하지 않는 문장(주로 코드를 설명하는데 사용한다.)
		
//		한 줄 주석 : ctrl + shift + c
/*		범위 주석 : ctrl + shift + / (해제 : \)
*/	
//	데이터의 형태(데이터 타입)와 이름을 작성하면 변수를 만들 수 있다.
//		데이터타입을 선택할 때는 표현하고자 하는 데이터에 맞는 타입을 선택해주면 된다.
//		변수이름을 정할때는 표현하고자 하는 데이터의 의미와 부합하는 이름을 지어주면 된다.
		/*
		 *기본형 타입
		 * -정수 : byte(1), short(2), *int(4), long(8)
		 * -실수 : float(4), *double(8)
		 * -문자 : char(2)
		 * -논리 : boolean(1)
		 */
		int x; //정수를 저장 할 수 있는 x 라는 이름을 가진 그릇을 만들어라.
//		변수를 만드는 것을 변수 선언이라고 표현한다.
//		double x; // 블럭 {} 안에서 이름이 중복될 수 없다.
		double y;
		
//		=(대입연산자) : 오른쪽의 값을 왼쪽의 변수에 저장
		x = 10; //초기화 : 변수에 처음으로 값을 저장하는 것
		y = 3.14; //변수의 타입에 맞는 값을 저장해야 한다.
		int abc = 30; //일반적으로 선언과 초기화를 한번에 한다.
		long l = 40L; //접비사 L을 붙여야 long 타입이 된다.
		float f = 5.5f; //접미사 f를 붙여야 float 타입이 된다.
		char c = '한'; // 따옴표 안에 반드시 한 글자를 넣어야 한다.
		boolean b = true; // true , false
	
//		8가지 기본형 타입을 사용해서 8개의 변수를 선언 및 초기화 해주세요.
		byte v1 = 1; // -128 ~ 127
		short v2 = 2; // -32768 ~ 32767
		int v3 = 3; // -2147483648 ~ 2147483647
		long v4 = 4L;
		float v5 = 5.5f;
		double v6 = 6.6;
		char v7 = 'c';
		boolean v8 = false;
		
//		변수의 값을 변경하기 위해서는 대입연산자를 사용해 변수에 새로운 값을 대입해주면 된다.
		x = 20; //기존에 저장되어 있는 10이라는 값은 사라지고 20이라는 값이 저장된다.
//		int x= 20; 변수를 만들때만 타입을 붙인다. 변수를 사용하기 위해서는 이름만 있으면 된다.
		y = 5.5;
//		위에서 만든 8개의 변수에 새로운 값을 저장 해 주세요.
		v1 = -1;
		v2 = -2;
		v3 = -3;
		v4 = -4L;
		v5 = -5.5f;
		v6 = -6.6;
		v7 = 'd';
		v8 = true;
		
		// 콘솔 창에 출력
		System.out.println(100);
		// 실행 단축키 : ctrl + F11
		System.out.println(x);
		
		// 위에서 만든 8개의 변수의 값을 출력해주세요.
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		System.out.println(v5);
		System.out.println(v6);
		System.out.println(v7);
		System.out.println(v8);
		
		//문자열
		String str = "문자 여러개.."; // 클래스는 참조형 타입 데이터이다.
		System.out.println(str);
		// 문자열과 다른 타입의 데이터가 결합되면 문자열의 결과를 얻는다.
		System.out.println(str+50);
		System.out.println(10+20+str);
		System.out.println(str+10+20);

		//형변환
		//다른 타입의 값을 저장하기 위해서는 값의 타입을 변경해 주어야 하는데 이를 형변환이라고 한다.
		int small = 10;
		long big = 10L;
		small = (int)big;
		big = small; // 표현범위가 작은쪽에서 큰 쪽으로의 형 변환은 생략이 가능하다.
		
/*		명명규칙
		-영문자 대소문자, 한글, 숫자, 특수문자('_', '$')를 사용할 수 있다.
		-숫자로 시작할 수 없다.
		-예약어는 사용할 수 없다. ( 자바에서 이미 특정한 의미로 사용하고 있는 단어)
		-[낙타식 표기법을 사용한다. (mySampleVariable)]
	    -[클래스명의 첫 글자는 대문자로 한다.(MySampleClass)]*/
	    		
		
		/*
		 * 상수
		 * -값을변경 할 수 없는 그릇
		 * -리터럴(literal)에 의미를 부여하기 위해 사용한다.
		 */
		final int MAX_NUMBER = 10; // 상수는 대문자만 사용해서 이름을 짓는다.
//		MAX_NUMBER = 20; // Compile Error 발생
	    
		//출력
		System.out.print("줄바꿈을 하지 않는다.");
		System.out.print("줄바꿈을 하지 않는다.\n");
		System.out.print("줄바꿈을\t한다.\n");
		System.out.printf("문자열:%s, 숫자:%d", "Hello",10); //출력 포맷을 지정한다
		System.out.println();
		
		//입력
		Scanner sc = new Scanner(System.in); //입력받기 위한 클래스
//		import 단축키 : ctrl + shift + O
		
		/*System.out.print("아무거나 입력해 주세요>");
		String str2 = sc.nextLine();
		System.out.println("입력한값은: "+str2);*/
		
/*		System.out.print("int 입력 >");
		int i = sc.nextInt();
		System.out.print("문자열 입력>");
		String nextLine = sc.nextLine();
		System.out.println(nextLine);
		System.out.println(" 입력 끝!!");
		System.out.println(i);*/
		
/*		System.out.print("int 입력 >");
		int number = Integer.parseInt(sc.nextLine());
		System.out.println(number);*/
		
		// 문제 : 자신의 이름을 저장할 변수를 선언해주세요.
		String myName;
		// 위에서 선언한 변수를 초기화하기 위해 이름을 입력받아 주세요.
		System.out.print("이름을 입력 해 주세요 >");
		myName = sc.nextLine();
		//자신의 나이를 저장 할 변수를 선언 해 주세요.
		int myAge;
		//위에서 선언한 변수를 초기화 하기 위해 나이를 입력 받아 주세요.
		System.out.printf("나이를 입력 해 주세요>");
		myAge = Integer.parseInt(sc.nextLine());
		
		
		System.out.printf("내 이름은 %s 입니다 %d살 입니다..\n",myName,myAge);
		System.out.println("내 이름은 "+myName+" 입니다 "+myAge+"살 입니다..");
		
	// **************       과제          *******************
/* 다음과 같은 프로그램을 작성 해 주세요.
 * 
 * ==========회원가입==============
 * 아이디 >  admin
 * 비밀번호 ( 4자리 숫자) > 1234
 * 이름 > 홍길동
 * 나이 > 30
 * 키 > 185.5
 * =============================
 * 아이디 : admin
 * 비밀번호 : 1234
 * 이름 : 홍길동
 * 나이 : 30세
 * 키 : 185.5cm
 * ==============================
 */
		
	}
}
