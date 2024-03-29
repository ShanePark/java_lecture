package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class Homework1_Array {

	public static void main(String[] args) {
		// 1 ~ 10 사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.
		// 문제 : 위 문제의 최소값(1), 최대값(10), 발생 횟수(500)을 입력 받아 각 숫자가 생성된 횟수를 출력해주세요.
		
		int min, max, size;							 // 최소값(x), 최대값(y), 발생횟수(z)
		Scanner sc = new Scanner(System.in);
		System.out.print("x~y 사이의 숫자를 z번 발생시키겠습니다. x:");
		min = Integer.parseInt(sc.nextLine());
		System.out.print("x~y 사이의 숫자를 z번 발생시키겠습니다. y:");
		max = Integer.parseInt(sc.nextLine());
		System.out.print("x~y 사이의 숫자를 z번 발생시키겠습니다. z:");
		size = Integer.parseInt(sc.nextLine());
		System.out.print("["+min+"~"+max+" 사이의 숫자를 "+size+"번 발생시켰습니다.]\n");
		
		int[] array = new int[size];				// 값들이 저장되는 array 의 크기는 size (z)
		int[] array_count = new int[max-min+1];		// 랜덤값들의 총 case는 max-min+1 개 (x-y+1)
		
		for(int i=0; i<array.length; i++){
			array[i] = (int)((Math.random())*(max-min+1))+min; // it was most difficult part to code
			array_count[array[i]-min]++;	// 배열 번호는 0 ~ (max-min) 이지만 생성된 값은 min ~ max 이므로. 
		}
		
		System.out.println(Arrays.toString(array));								/////////////
		for(int i=min, j=1; i<=max; i++,j++ ){											// Out put //
			System.out.printf(" [%3d] 총 발생 횟수 : %3d회",i,array_count[i-min]);	/////////////
			if(j==5){
				System.out.print("\n");
				j=0;
			}else System.out.print(",");
		}
		int sum=0;                                 		//	array_count		//
		for(int i=0; i<array_count.length; i++)    		//		총합 	갯수		//
			sum += array_count[i];                 		//		맞는지 확인용	//
		System.out.printf("\n총 발생 횟수의 합 [%d]",sum);		//		테스팅 코드		//
	
	}

}
