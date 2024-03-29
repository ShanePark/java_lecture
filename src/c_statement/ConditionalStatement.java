package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		/*
		 * 조건문
		 * - if문
		 * - switch문
		 * 
		 * if문
		 * - if(조건식){} : 조건식의 결과가 true이면 블럭안의 문장을 수행 한다.
		 * - else if(조건식){} : 다수의 조건이 필요할 때 if 뒤에 추가한다.
		 * - else{} : 결과가 true인 조건식이 하나도 없는 경우를 위해 추가한다.
		 */
		
		int a=1;
		if (a==1){
//			System.out.println("조건식의 연산결과가 true이면 수행된다.");
		}
		if(a==0){
			System.out.println("조건식의 결과가 false 이면 수행되지 않는다.");
		}
		
//		if(a==1){
//			System.out.println("a가 1인 경우에 하고 싶은 것");
//		}else if(a==2){
//			System.out.println("a가 2인 경우에 하고 싶은 것.");
//		}else if(a==3){
//			System.out.println("a가 3인 경우에 하고 싶은 것.");
//		}else{
//			System.out.println("이외의 경우에 하고 싶은 것");
//		}
//		
//		if(a < 10){
//			System.out.println("a가 10보다 작다");
//		}else if(a < 20){
//			System.out.println("a가 20보다 작다.");
//		}
		
		//시험 점수가 60점 이상이면 합격 그렇지 않으면 불합격
		int score = 50;
//		if(score>=60){
//			System.out.println("합격");
//		}else{
//			System.out.println("불합격");
//		}
//		
		//성적에 등급을 부여하는 프로그램을 만들어 보자.
		Scanner sc = new Scanner(System.in);
/*		System.out.print("시험 성적을 입력 해 주세요 : ");
		score = Integer.parseInt(sc.nextLine());
		
		String grade = null;
		if(score>=90){
			grade = "A";
			if(score>=97){
				grade += "+";
			}else if(score<=93){
				grade += "-";
			}
		}else if(score>=80){
			grade = "B";
			if(score>=87){
				grade += "+";
			}else if(score<=83){
				grade += "-";
			}
		}else if(score>=70){
			grade = "C";
			if(score>=77){
				grade += "+";
			}else if(score<=73){
				grade += "-";
			}
		}else if(score>=60){
			grade = "D";
			if(score>=67){
				grade += "+";
			}else if(score<=63){
				grade += "-";
			}
		}else{
			grade = "F";
		}
		System.out.println(score+"점에 해당하는 등급은 "+grade+"입니다.");*/
		
		
		/*
		 * Switch 문
		 * - Switch(int/String){case 1: break;}
		 * - 조건식의 결과는 정수와 문자열만(JDK1.7 부터 문자열 혀용) 허용한다.
		 * - 조건식과 일치하는 case문 이후의 문장을 수행한다.
		 */
		
		a=1;
		
/*		switch(a){
		case 1: 
			System.out.println("a가 1인 경우에 하고 싶은 것");
			break;
		case 2:
			System.out.println("a가 2인 경우에 하고 싶은 것.");
			break;
		case 3:
			System.out.println("a가 3인 경우에 하고 싶은 것");
			break;	
		default:
			System.out.println("의외의 경우에 하고 싶은 것");
		}
		
		String b = "a";
		
		switch(b){
		case "a":
			System.out.println("b가 \"a\"인 경우에 하고 싶은 것");
			break;
		case "b":
			System.out.println("b가 \"b\"인 경우에 하고 싶은 것");
			break;
		default:
			System.out.println("의외의 경우에 하고 싶은 것");
			break;
		}*/
		
		//주어진 월에 해당하는 계절을 출력 해 봅시다.
/*		int month;
		String season = null;
		System.out.print("월을 입력하세요 : ");
		month = Integer.parseInt(sc.nextLine());
		
		switch(month){
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
		default :
			season = "존재하지 않는 월";
			break;
		}
		System.out.println(month+"월은 "+season+"입니다.");*/
		
		
		score = 90;
		String grade = null;
		
		switch(score/10){
		case 10:
		case 9: grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "C"; break;
		case 6: grade = "D"; break;
		default : grade = "F"; break;
		}
//		System.out.println(score+"점에 대한 등급은 "+grade+" 입니다.");
		
		// 숫자를 입력 받아 그 숫자가 0인지 0이 아닌지 출력해주세요.
//		System.out.print("숫자를 입력 해 주세요 : ");
//		int check = Integer.parseInt(sc.nextLine());
//		
//		switch(check){
//		case 0:
//			System.out.println("0이 맞습니다.");
//			break;
//		default :
//			System.out.println("0이 아닙니다.");
//			break;
//		}
		
		// 숫자를 입력 받아 그 숫자가 홀수인지 짝수인지 출력 해 주세요.
		
//		switch(check%2){
//		case 1:
//			System.out.println("홀수 입니다."); 			break;
//		default:
//			System.out.println("짝수 입니다."); 			break;
//		}
		
		// 정수 3개를 입력 받아 총점, 평균, 등급을 출력해주세요.
//		System.out.print("첫번째 점수를 입력해주세요: ");
//		int n1 = Integer.parseInt(sc.nextLine());
//		System.out.print("두번째 점수를 입력해주세요: ");
//		int n2 = Integer.parseInt(sc.nextLine());
//		System.out.print("세번째 점수를 입력해주세요: ");
//		int n3 = Integer.parseInt(sc.nextLine());
//
//		switch((n1+n2+n3)/30){
//		case 10: 
//		case 9: 
//			grade = "A"; break;
//		case 8:
//			grade = "B"; break;
//		case 7:
//			grade = "C"; break;
//		case 6:
//			grade = "D"; break;
//		default :
//			grade = "F"; break;
//		}
//		
//		System.out.println("총점: "+(n1+n2+n3)+" 평균: "+Math.round((n1+n2+n3)/3.0*10)/10.0+" 등급 : "+grade+" 입니다.");
//				
		
		// 1~100 사이의 랜덤한 숫자를 3개 발생시키고 오름차순으로 출력해주세요.
		int n1 = (int)(Math.random()*100) +1;
		int n2 = (int)(Math.random()*100) +1;
		int n3 = (int)(Math.random()*100) +1;
		
//		if(n1<n2){
//			if(n1<n3){
//				System.out.print(n1+" ");
//				if(n2<n3){
//					System.out.print(n2+" "+n3);
//				}
//				else System.out.print(n3+" "+n2);
//			}
//			else{
//				System.out.print(n3+" ");
//				if(n1<n2){
//					System.out.print(n1+" "+n2);
//				}
//				else System.out.print(n2+" "+n1);
//				}
//			}
//		else if(n2<n3){
//			System.out.print(n2+" ");
//			if(n1>n3){
//				System.out.print(n3+" "+n1);
//			}
//			else System.out.print(n1+" "+n3);
//		}
//		else{
//			System.out.print(n3+" ");
//			if(n1<n2) System.out.print(n1+" "+n2);
//			else System.out.print(n2+" "+n1);
//			}
		
		int temp;
		if(n1>n2){
			temp=n1;
			n1=n2;
			n2=temp;
		}
		if(n1>n3){
			temp=n1;
			n1=n3;
			n3=temp;
		}
		if(n2>n3){
			temp=n2;
			n2=n3;
			n3=temp;
		}
		System.out.println(n1+" "+n2+" "+n3);
		
	}

}
