package d_array;
import java.util.Arrays;
import java.util.Scanner;

public class Homework2_Sort {

	public static void main(String[] args) {
		//		버블정렬 : 바로 뒤의 숫자와 비교해서 큰 수를 뒤로 보내는 방식
		//		삽입정렬 : 두번째 숫자부터 앞의 숫자들과 비교해서 큰 수는 뒤로 밀고 중간에 삽입하는 방식
		long start = System.currentTimeMillis();                                                         		  
		int[] arr = new int[10];                  //                  		// 
		for(int i=0; i<arr.length; i++)           // 배열 선언 고정 한채로 	    	// 
			arr[i] = (int)(Math.random()*100)+1;  //  석차/선택/버블/삽입 만들어보자	//
		System.out.println(Arrays.toString(arr));


		//		석차 구하기 : 점수를 비교해 작은 점수의 등수를 증가시키는 방식
		int[] rank = new int[arr.length];
		for(int i=0; i<rank.length; i++)
			rank[i] = 1;
		for(int i=0; i<rank.length; i++){
			for(int j=i+1; j<rank.length; j++){ // half the comparison to make it efficient
				if(arr[i]<arr[j])
					rank[i]++;
				else if(arr[i]!=arr[j]) // if their numbers are same, let them have the better same rank
					rank[j]++;

			}
		}
		System.out.println(Arrays.toString(rank));
		
		System.out.print("정렬방식 선택 : (1선택/2버블/3삽입) : ");
		Scanner sc = new Scanner(System.in);
		int sort_method = Integer.parseInt(sc.nextLine());

		switch(sort_method){
		//		선택정렬 : 가장 작은 숫자를 찾아서 앞으로 보내는 방식		

		case 1:
			for(int i=0; i<rank.length-1; i++){
				int min_index=i;
				for(int j=i+1; j<rank.length; j++){
					if(arr[min_index]>arr[j])
						min_index=j;
				}
				int temp = arr[i];
				arr[i] = arr[min_index];
				arr[min_index] = temp;
			}
			System.out.println(Arrays.toString(arr));
			break;






		default :
		}
		long end = System.currentTimeMillis();
		System.out.println("실행시간 : "+(end-start)+"ms");


	}

}
