package homeworksPackage;
import java.util.Scanner;

public class C_Baseball {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n1 = (int)(Math.random()*9)+1;		//  	랜덤으로 서로 다른 세개의 숫자를 만들어		//		
		int n2=0,n3=0;							//   		n1, n2, n3, 에 저장합니다		//
		while(n1 == n2 || n2==0) n2 = (int)(Math.random()*9+1);							//	
		while(n3 == n1 || n3 == n2 || n3==0) n3 = (int)(Math.random()*9+1);				//	 
				
		int strike = 0;   	//////////////////////////////////////////////////////////////
		int ball = 0;     	// 				strike, ball, out의 횟수를 카운트				    //
		int out = 0;      	//				try_n을 통해 총 시도해본 횟수를 기록합니다				//
		int try_n = 0;		//////////////////////////////////////////////////////////////	
		
		System.out.println("야구 게임을 시작합니다. 서로 중복되지 않는 3자리의 숫자를 입력하세요. [종료하려면 0을 입력] ");
		
		game:while(strike<3){								//////////////////////////////
			strike = 0; ball = 0; out = 0; 					//  매게임 볼카운트를 초기화합니다		//
			int guess = 0; int i1=0; int i2=0; int i3=0;	//	사용자의 추측은 guess로 받은후	//
															//   i1 i2 i3에 쪼개어 저장됩니다	//
			do{												//////////////////////////////			
				System.out.print(": > ");						
				guess = Integer.parseInt(sc.nextLine());	////////////////////////////// 
				i1 = guess/100;								//	guess로 받은 세자리 숫자를		//
				i2 = (guess/10)%10;							//		각 자리숫자를 따로 떼 저장	//
				i3 = guess%10;								//	*조건이 맞을때까지 새로 입력받습니다	//
				if(guess>=123 && guess<987){				//////////////////////////////
					if(i1!=i2 && i2!=i3 && i1!=i3 && i1!=0 && i2!=0 && i3!=0)//모든 조건 충족//
						break;
				}
				if(guess==0) break game;					// 0이 입력되면 game루프를 빠져나가 종료 //
				System.out.print("["+guess+"]은(는) 유효하지 않습니다. 0을 포함하지 않은 서로 다른 수로 이루어진 세자리 수를 다시 입력 해 주세요.");
					
			}while(true);
		
			if(i1==n1) strike++;            				//////////////////////////////
			if(i2==n2) strike++;		   					//							//
			if(i3==n3) strike++;							//	숫자와 자릿수가 일치하면 strike	//
			if(i1==n2 || i1==n3) ball++;					// 자릿수가 달라도 어딘가 존재하면 ball	//
			if(i2==n1 || i2==n3) ball++;					//	strike+ball+out=3		//	
			if(i3==n1 || i3==n2) ball++;					//							//	
			out = 3 - strike - ball;						//////////////////////////////

			System.out.print("["+guess+"]"+"에 대한["+ ++try_n+"]회차 야구게임 결과 : "+strike+"strike "+ball+"ball "+out+"out ");
			
		}
		if(strike>=3) System.out.print("!!! 숫자를 맞춰서 ");		// Strike 가 3으로 종료되었을 때만	//
		System.out.print("프로그램을 종료합니다.");					//	숫자를 맞춰서 종료한다는 메시지	//
															// 0을 입력해서 종료했으면 그냥 종료합니다//	
	}

}
