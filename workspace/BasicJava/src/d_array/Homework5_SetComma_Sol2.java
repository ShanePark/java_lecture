package d_array;

import java.util.Scanner;

public class Homework5_SetComma_Sol2 {

	public static void main(String[] args) {
		// 숫자를 입력받아 입력 받은 숫자에 3자리 마다 콤마(,)를 붙여 출력해주세요.
		// 10000000 -> 10,000,000 
		// 숫자를 입력 받을때는 string type 으로 입력받으세요 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("get number : ");
		String str =  sc.nextLine();
		
		for(int i=0; i<str.length(); i++){
			if(i!=0 && (str.length()-i)%3==0)
				System.out.print(",");
			System.out.print(str.charAt(i));
		}

	}

}
