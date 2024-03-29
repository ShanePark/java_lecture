package e_oop;

public class Static {
	
	/*
	 * - static을 붙이면 프로그램 실행 시 메모리에 올라간다.
	 * - 객체생성을 하지 않아도 사용할 수 있다.
	 * - static을 붙인 변수는 객체간에 변수의 값을 공유한다.
	 * - static이 붙은 멤버의 명칭 : 클래스 변수, 클래스 메서드
	 * - static이 붙지 않은 멤버의 명칭 : 인스턴스 변수, 인스턴스 메서드
	 */
	
	// 값을 공유하기 위해 static을 붙인다.
	static int var;
	public static void main(String[] args) {
		Human john = new Human();
		Human lucy = new Human();
		
		john.saveMoney(100000);
		lucy.saveMoney(200000);
		john.saveDateMoney(200000);
		lucy.saveDateMoney(100000);
		
		System.out.print("문자열 입력 > ");
		String str = ScanUtil.nextLine();
		System.out.println(str);
		
		System.out.print("숫자 입력 > ");
		int num = ScanUtil.nextInt();
		System.out.println(num);
	}

}

class Human{
	
	int account;
	
	void saveMoney(int money){
		account += money;
		System.out.println("통장 잔고 : "+account);
	}
	
	static int dateAccount;
	
	void saveDateMoney(int money){
		dateAccount += money;
		System.out.println("데이트 통장 잔고 : " + dateAccount);
	}
	
}