package d_array;

import java.util.Scanner;

public class Homework5_SetComma {

	public static void main(String[] args) {
		// 숫자를 입력받아 입력 받은 숫자에 3자리 마다 콤마(,)를 붙여 출력해주세요.
		// 10000000 -> 10,000,000 
		// 숫자를 입력 받을때는 string type 으로 입력받으세요 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력 해 주세요 : ");
		String str = sc.nextLine();
		StringBuffer str2 = new StringBuffer("");
		
		for(int i=0 ; i<str.length(); i++){     //////////////////////////////////
			if((str.length()-i)%3==0 && i!=0)   // 숫자를 앞부터 뒤까지 읽으면서			//
				str2.append(",");               // 숫자길이-i 가 3으로 나누어 떨어질 떄마다	//
			str2.append(str.charAt(i));         // 쉼표를 찍습니다					//
		}                                       //////////////////////////////////
				
		
		System.out.println(str2);

	}

}
