package player_Monster;
import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		Player player1 = new Player();
		GameSystem game = new GameSystem();
		
		game.welcomeMessage(player1);
		Scanner sc = new Scanner(System.in);
		while(true){
			GameSystem.menu();
			String input = sc.nextLine();
			
			switch(input){
			case "1": 
				game.status(player1);
				break;
			case "2": 
				game.battle(player1);
				break;
			case "3": 
				player1.recover();
				break;
			case "4":
				AllText.bye(player1.name);
				System.exit(0);
			default:
				AllText.wrong();
				break;
			}
		}

	}


}
