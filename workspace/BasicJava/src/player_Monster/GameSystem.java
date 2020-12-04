package player_Monster;

import java.util.Scanner;

public class GameSystem {
	Scanner sc = new Scanner(System.in);
	String input;

	static void menu(){
		AllText.menu();
	}

	void wait(int i){
		long end = System.currentTimeMillis();
		long start = System.currentTimeMillis();
		while((end-start)<i)
			end=System.currentTimeMillis();
	}

	void status(Player player){
		AllText.status(player);
		AllText.pressAny();
	}

	void welcomeMessage(Player player){
		AllText.welcomePlayer(player);
		for(int i=0; i<45; i++){
			this.wait(20);
			System.out.print("■");
		}
		AllText.loadingComplete();
	}

	void battle(Player player){
		BattleField field = new BattleField();
		field : while(true){
			fieldlist();
			System.out.print(">");
			input = sc.nextLine();

			switch(input){
			case "1" : 
				field.field1(player);
				break;
			case "2" : 
				field.field2(player);
				break;
			case "3" : 
				field.field3(player); 
				break;
			case "4" : 
				break field;
			default : 
				AllText.wrong();
				break;
			}
		}

	}

	void fieldlist(){
		AllText.fieldlist();
	}



}
