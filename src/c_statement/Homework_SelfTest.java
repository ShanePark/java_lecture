package c_statement;

import java.util.Scanner;

public class Homework_SelfTest {

	public static void main(String[] args) {
		//탄수화물 중독 자가 진단 테스트 프로그램을 만들어주세요.
		
		Scanner sc = new Scanner(System.in);
		String answer=null;
		int sum=0;
		System.out.println("======== 탄수화물 자가 진단 테스트를 시작합니다 ========\n");
		
		System.out.print("Q1.아침을 배불리 먹은 후 점심시간 전에 배가 고프다 (y/n) : ");
		answer = sc.nextLine();
		if(answer.equals("y")){
			sum++;
		}else if(!(answer.equals("n"))){
			System.out.println("y나 n중 하나만 입력해야 합니다.");
		}
		
		System.out.print("Q2.밥, 빵, 과자 등 음식을 먹기 시작하면 끝이 없다 (y/n) : ");
		answer = sc.nextLine();
		if(answer.equals("y")){
			sum++;
		}else if(!(answer.equals("n"))){
			System.out.println("y나 n중 하나만 입력해야 합니다.");
		}
		
		System.out.print("Q3.음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다 (y/n) : ");
		answer = sc.nextLine();
		if(answer.equals("y")){
			sum++;
		}else if(!(answer.equals("n"))){
			System.out.println("y나 n중 하나만 입력해야 합니다.");
		}
		
		System.out.print("Q4.정말 배고프지 않더라도 먹을 때가 있다 (y/n) : ");
		answer = sc.nextLine();
		if(answer.equals("y")){
			sum++;
		}else if(!(answer.equals("n"))){
			System.out.println("y나 n중 하나만 입력해야 합니다.");
		}
		
		System.out.print("Q5.저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다 (y/n) : ");
		answer = sc.nextLine();
		if(answer.equals("y")){
			sum++;
		}else if(!(answer.equals("n"))){
			System.out.println("y나 n중 하나만 입력해야 합니다.");
		}
		
		System.out.print("Q6. 스트레스를 받으면 자꾸 먹고 싶어진다 (y/n) : ");
		answer = sc.nextLine();
		if(answer.equals("y")){
			sum++;
		}else if(!(answer.equals("n"))){
			System.out.println("y나 n중 하나만 입력해야 합니다.");
		}
		
		System.out.print("Q7. 책상이나 식탁 위에 항상 과자, 초콜릿 등이 놓여있다 (y/n) : ");
		answer = sc.nextLine();
		if(answer.equals("y")){
			sum++;
		}else if(!(answer.equals("n"))){
			System.out.println("y나 n중 하나만 입력해야 합니다.");
		}
		
		System.out.print("Q8. 오후 5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안 잡힌다 (y/n) : ");
		answer = sc.nextLine();
		if(answer.equals("y")){
			sum++;
		}else if(!(answer.equals("n"))){
			System.out.println("y나 n중 하나만 입력해야 합니다.");
		}
		
		System.out.print("Q9. 과자, 초콜릿 등 단 음식은 상상만 해도 먹고 싶어진다 (y/n) : ");
		answer = sc.nextLine();
		if(answer.equals("y")){
			sum++;
		}else if(!(answer.equals("n"))){
			System.out.println("y나 n중 하나만 입력해야 합니다.");
		}
		
		System.out.print("Q10. 다이어트를 위해 식이조절을 하는데 3일도 못 간다 (y/n) : ");
		answer = sc.nextLine();
		if(answer.equals("y")){
			sum++;
		}else if(!(answer.equals("n"))){
			System.out.println("y나 n중 하나만 입력해야 합니다.");
		}
		System.out.println("======== 탄수화물 자가 진단 테스트를 종료합니다 ========");
		switch(sum){
		case 10: case 9: case 8: case 7: 
			System.out.println("\n검사결과 점수는 "+sum+"점 입니다. \"주의\" 단계로 전문의 상담이 필요합니다." );
			break;
		case 6: case 5: case 4:
			System.out.println("\n검사결과 점수는 "+sum+"점 입니다. \"위험\" 단계로 탄수화물 섭취 줄이기 위한 식습관 개선이 필요합니다.");
			break;
		case 3 :
			System.out.println("\n검사결과 점수는 "+sum+"점 입니다. \"중독\" 단계로 위험한 수준은 아니지만 관리가 필요합니다.");
			break;
		default:
			System.out.println("\n검사결과 점수는 "+sum+"점 입니다. 문제 없습니다");
			break;
			
		}		
		
	}

}
