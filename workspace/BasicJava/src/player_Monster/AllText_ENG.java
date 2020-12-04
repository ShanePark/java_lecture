package player_Monster;

public class AllText_ENG {
	
	static void welcome(){
		System.out.print("type your name > ");
	}
	static void wrong(){
		System.out.println("You put the wrong command! Try again.");
	}
	static void status(Player player){
		System.out.println(  "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(  "■ [Lv "+player.lv+" "+player.name+"] EXP "+player.exp+"/"+player.exp_max+" HP "+player.hp+"/"+player.hp_max+" "+player.gold+" gold"+"   ■");
		System.out.println(  "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
	static void welcomePlayer(Player player){
		System.out.println("Welcome to game world ["+player.name+"]. Please wait ");
	}
	static void loadingComplete(){
		System.out.println("\n■■■■■■■■■■■■■ LOADING COMPLETE ■■■■■■■■■■■■■■");
		System.out.println(  "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
	static void alreadyFull(){
		System.out.println("[FREE] Your HP is already full.");
	}
	static void recover(int price){
		System.out.printf("[-%d gold] You spent money to recover...",price);
		System.out.println("Now you are fully recovered!");
	}
	static void fieldlist(){
		System.out.println(  "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(  "■■■CHOOSE A BATTLE FIELD YOU WANT TO JOIN■■■■");
		System.out.println(  "■■■1.EASY 1[  ONLY LV1 MONSTERS IN HERE");
		System.out.println(  "■■■2.EASY 2[MONSTER LEVEL 1~2]");
		System.out.println(  "■■■3.EASY 3[MONSTER LEVEL 2~3]");
		System.out.println(  "■■■4.BACK TO MENU ■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(  "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
	
	static void menu(){
		System.out.print(  "[MENU]  1.STATUS 2.COMBAT 3.RECOVER 4. EXIT\n>");
	}
	static void bye(String name){
		System.out.printf("Thank you for enjoying [%s]. There's NO save file for you. BYE :P",name);
	}

}
