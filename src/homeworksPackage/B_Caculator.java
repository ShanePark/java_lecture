package homeworksPackage;
import java.util.Scanner;
public class B_Caculator {

	public static void main(String[] args) {
		//두 개의 숫자와 연산자를 입력	 받아 연산 결과를 알려주는 프로그램을 만들어 주세요.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력해주세요 : ");
		int a = Integer.parseInt(sc.nextLine());
		System.out.print("사용하고자 하는 연산자(+,-,*,/,%)를 입력해주세요 : ");
		String Operator = sc.nextLine();
		System.out.print("두번째 숫자를 입력해주세요 : ");
		int b = Integer.parseInt(sc.nextLine());

		System.out.println(a+" "+ Operator +" "+b+" = "+
				(Operator.equals("+") ? a+b :(
						Operator.equals("-") ? a-b :(
								Operator.equals("*") ? (long)a*b :(
										Operator.equals("/") ? Math.round((double)a/b*100)/100.0 :(
												Operator.equals("%") ? a%b : "사용할 수 없는 연산자 사용으로 계산 불가능 합니다."
												)
										)
								)
						)
				)
		);
		
	}

}
