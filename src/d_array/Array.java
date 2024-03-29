package d_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		/*
		 * 배열
		 * - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 * - 참조형 타입이다.
		 * - 인덱스로 값을 구분한다.
		 * - 길이를 변경 할 수 없다.
		 */

		int[] array; // 배열의 주소를 저장할 공간이 만들어진다.
		array = new int[5]; // 배열이 생성되고 그 주소가 저장된다.
		// 배열 초기화 시 기본값이 저장된다.
		/*
		 * 정수 : 0
		 * 실수 : 0.0
		 * 문자 : ' ' (0)
		 * 논리 : false
		 * 참조형 : null
		 */

		array = new int[]{1,2,3,4,5};

		//		array = {1,2,3,4,5};
		//		이 방법은 선언과 초기화를 동시에 해야한다.

		int[] array2 = {1,2,3,4,5};

		//		System.out.println(array[0]);
		//		System.out.println(array[1]);
		//		System.out.println(array[2]);
		//		System.out.println(array[3]);
		//		System.out.println(array[4]);
		//		
		//		array[0] = 10;
		//		array[1] = 20;
		//		array[2] = 30;
		//		array[3] = 40;
		//		array[4] = 50;
		//		
		//		int sum=0;
		//		for(int i=0; i<array.length; i++)
		//			sum += array[i];
		//		System.out.println("합계: " +sum);

		// 10개의 정수를 저장할 수 있는 배열을 선언 및 초기화 해주세요.
		int[] array_ = new int[10];

		// 배열의 모든 인덱스에 1~100 사이의 랜덤한 값을 저장해주세요.
		for(int i=0; i<array_.length; i++)
			array_[i] = (int)(Math.random()*100) + 1;

		System.out.println(Arrays.toString(array_));

		//배열에 저장된 모든 값의 합계와 평균을 구해주세요.

		int sum=0;

		for(int i=0; i<array_.length; i++)
			sum += array_[i];

		System.out.println("합계는 :"+sum+" 평균은 : "+(float)sum/array_.length);

		// 배열에 저장된 값들 중 최소값과 최대값을 출력해주세요.
		int max=array_[0];
		int min=array_[0];

		for(int i=1; i<array_.length; i++){
			if(max<array_[i])
				max = array_[i];
			if(min>array_[i])
				min = array_[i];
		}
		System.out.println("최대값은 : "+max+" 최소값은 : "+min+"\n");
		
		int[] shuffle = new int[10];
		for(int i=0; i<shuffle.length;i++)
			shuffle[i]=i+1;
		System.out.println(Arrays.toString(shuffle));
		
		for(int i=1; i<100; i++){
			int random = (int)(Math.random()*10);
			int random2 = (int)(Math.random()*10);
			int temp = shuffle[random];
			shuffle[random] = shuffle[random2];
			shuffle[random2] = temp;
		}
		
		System.out.println(Arrays.toString(shuffle));
		
		

	}

}
