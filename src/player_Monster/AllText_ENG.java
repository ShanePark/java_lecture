package player_Monster;

public class AllText_ENG extends AllText{

	private String[] monsterNames = {"Rabbit","Wolf","Goblin"};
	String getMonsterName(int number){
		return monsterNames[number];
	}

	private String[] itemNames = {"[None]", 
				"",				"",		"", "", "", "", "" ,"", "", "", // 1 ~ 10 : Helmet
		/*11*/	"Basic sword",	"",		"" ,"", "", "", "" ,"", "", "", // 11~ 20 : Weapon
		/*21*/	"Leather armor","",		"" ,"", "", "", "" ,"", "", "", // 21~ 30 : Armor
		/*31*/	"",				"",		"" ,"", "", "", "" ,"", "", "", // 31~ 40 : Shield
		/*41*/	"Rabbit shoes",	"",		"" ,"", "", "", "" ,"", "", "", // 41~ 50 : Boots
		/*51*/	"red potion",	"" ,	"", "", "", "" ,"", "", "", ""};// 51~ 60 : Consumables
	String getItemName(int number){
		return itemNames[number];
	}
	int getItemLevel(int number){
		return itemLevels[number];
	}
	private int[] itemLevels = {	0,			0, 			0, 		0, 0, 0, 0, 0, 0, 0, 0,
		/*11*/	1, 			0, 		0, 0, 0, 0, 0, 0, 0, 0,
		/*21*/	1,			0, 		0, 0, 0, 0, 0, 0, 0, 0,
		/*31*/	0, 			0, 		0, 0, 0, 0, 0, 0, 0, 0,
		/*41*/	1, 			0, 		0, 0, 0, 0, 0, 0, 0, 0,
		/*51*/	1, 			0, 		0, 0, 0, 0, 0, 0, 0, 0,};

	void welcome(){
		super.mainScreen();
		System.out.print("Please type your name > ");
	}
	void bye(String name){
		System.out.printf("Thank you for playing [%s]. We don't have saving system yet ",name);
	}
	void wrong(){
		System.out.print(">It's wrong command. Please try again \n>");
	}

	void status(Player player){
		int expPercent = (int)((float)player.exp/player.exp_max*10);
		int hpPercent = (int)((float)player.hp/player.hp_max*10);
		super.printBar(); super.printEnter();
		System.out.print("■　  ʕʘ̅͜ʘ̅ʔ           ■ XP ");System.out.printf("%3d/%3d      ",player.exp,player.exp_max);
		for(int i=0; i<10; i++){
			if(expPercent>i) System.out.print("●");
			else System.out.print("○");
		}
		System.out.print("\n■ =[   ]= ▬ι════ﺤ ■ HP ");System.out.printf("%3d/%3d(+%2d) ",player.hp,player.hp_max,player.hp_bonus);
		for(int i=0; i<10; i++){
			if(hpPercent>i) System.out.print("●");
			else System.out.print("○");
		}

		System.out.printf("\n■  || ||          ■ ATK %3d(+%d)\tDEF%3d(+%d)    \n",player.atk,player.atk_bonus,player.def,player.def_bonus);
		System.out.printf("■ [Lv %d %-8s] gold : %3dg",player.lv,player.name,player.gold);
		if(player.bonusStats>0)
			System.out.printf("\t[ + points : %d ]",player.bonusStats);
		super.printEnter();
		super.printEnter();
		System.out.print("(0)Back to menu (1) Change Equipment (2) Inventory ");
		if(player.bonusStats>0)
			System.out.printf(" (3) Use remain points");
		super.printEnter(); super.printBar();
		System.out.print(">");
	}

	void welcomePlayer(Player player){
		System.out.println("Welcome to DDIT world ["+player.name+"] . Please wait a while ");
	}
	void loadingComplete(){
		System.out.println("\n■■■■■■■■■■■■■■■■  Loading completed     ■■■■■■■■■■■■■■■■■");
	}
	void alreadyFull(){
		System.out.println("[Free] Your HP is already full.");
	}
	void recover(int price){
		System.out.printf("[-%d gold] You are getting recovered ",price);
		for(int i=0; i<5; i++){
			System.out.print(".");
			GameSystem.wait(500);
		}
		System.out.println("Your HP is now full!");

	}
	void fieldlist(){
		super.printBar(); super.printEnter();
		System.out.println(  "  💪 Choose the battle field you'd like to join 💪 ");
		System.out.println(  "■■■ (1) Beginner [ Only Lv1 Monsters here.] ");
		System.out.println(  "■■■ (2) Intermidiate [ Monsters level 1 ~ 2]");
		System.out.println(  "■■■ (3) Hard [ Monsters level 2 ~ 3]");
		System.out.println(  "■■■ (0) Back to menu ");
		super.printEnter();super.printBar();
		System.out.printf(">");
	}
	void levelup(int level){
		System.out.printf(" LEVEL UP!! Congratulations. You are now [LV %d]\n",level);
	}

	void menu(){
		super.printBar(); super.printEnter(); super.printEnter();
		System.out.println(  "■■■　　　　　　|　　　　　　|　　　　　　|　　　　　　|　　　　　 　  ■■■");
		System.out.println(  "■■■  STAT　  |　 Field　|   Hosp |   Shop |   EXIT  ■■■");
		System.out.println(  "■■■　　(1)　   |   (2)  |   (3)  |   (4)  |   (5)   ■■■");
		super.printEnter();  super.printEnter();super.printBar(); 
		System.out.print(  "> ");
	}


	void pressAny(){
		System.out.print("Press enter key to continue ..");
		GameSystem.nextLine();
	}

	void playerAttack(Player player, Monster monster,int damage){
		super.fightScreen(player,monster);
		System.out.printf("[%s] Attacked [%s]. by %d Damage \n",player.name,monster.name,damage);
		System.out.printf("%s now have HP : %d\n",monster.name,monster.hp);
	}
	void monsterAttack(Monster monster,Player player,int damage){
		super.fightScreen(player,monster);
		System.out.printf("[%s] Attacked [%s]. by %d Damage \n",monster.name,player.name,damage);
		System.out.printf("%s now have HP : %d\n",player.name,player.hp);
	}

	void fightStart(Player player,Monster monster){
		System.out.printf(" You encourtered Lv%d %s. \n",monster.lv,monster.name);
		System.out.printf("%s is now coming to attack [%s] !!! \n",monster.name,player.name);
	}

	void killed(String str){
		System.out.printf("[%s] is defeated. ",str);
	}

	void getGold(int gold,int playerGold){
		System.out.printf("You got [%d] gold. \n",gold,playerGold);
	}
	void expGet(int exp,int expMax,int playerExp){
		System.out.printf("You got [%d] EXP.(EXP %d/%d) \n",exp,playerExp,expMax);
	}


	void PlayerDie(String player,int gold, int hp, int hpMax,int goldRemain){
		System.out.printf("[%s] is now dead.\n",player);
		System.out.printf(" You spent %d gold to recover. Your HP is %d/%d remain gold %d.\n",gold,hp,hpMax,goldRemain);
	}

	void notEnoughMoney(int price,int gold){
		System.out.printf(" You need [%d gold]. You don't have enough money. you have [%d gold] \n",price,gold);
	}

	void noBonusStats(){
		System.out.print("You don't have any bonus stats\n");
	}

	void bonusText(Player player){
		System.out.printf("Your remain bonus stats : [%d] . Choose stats you want to increase HP(1) ATK(2) DEF(3) BACK(0)\n>",player.bonusStats);
	}
	void hpUp(Player player){
		System.out.printf("You have extra HP!!! [%d] -> [%d]\n",player.hp_max,player.hp_max+player.BONUSHP);
	}
	void atkUp(Player player){
		System.out.printf("You got extra ATK!!! [%d] -> [%d]\n",player.atk,player.atk+player.BONUSATK);
	}
	void defUp(Player player){
		System.out.printf("You got extra DEF!!! [%d] -> [%d]\n",player.def,player.def+player.BONUSDEF);
	}

	void shopMenu(){
		super.printBar();	super.printEnter(); super.printEnter();
		System.out.println(  "■■■    ⛽  WELCOME TO APPLE STORE DJ ⛽                    ■■■■■■■");
		System.out.println(  "■■■    BUY  |  SELL  | ENCHANT |   BACK     ■■■■■■■");
		System.out.println(  "■■■    (1)  |   (2)  |   (3)   |    (0)     ■■■■■■■");
		super.printEnter();  super.printEnter();super.printBar();
		System.out.print(  "> ");
	}

	void buyItem(){
		System.out.printf(  "Do you wanna buy [%s] by 1 gold? (YES(1), NO(2) )\n",itemNames[51]);

	}

	void buySuccess(int price){
		System.out.printf(" You spent [%d] gold to buy.\n",price);

	}

	void inventoryFull(){
		System.out.println("Your inventory is full choose what you want to dump (0 : give up what you now got).\n>");
	}

	void itemList(Player player){
		for(int i=0; i<player.inventoryCount ; i++){
			System.out.printf("[no %d] : %s %s  ",i+1,player.inventory[i].getName(),player.inventory[i].statsToString());
			if(player.inventory[i].isEquipped())
				System.out.printf("[Equipped]");
			if(player.inventory[i].getAmount() > 1)
				System.out.printf(" (amount : %d)",player.inventory[i].getAmount());
			System.out.printf("\n");
		}
		System.out.printf(" Numbers of your items is [%d]\n",player.inventoryCount);

	}

	void chooseEquip(){
		System.out.print("Choose equipment you want. (0) BACK (1~5) SELECT \n>");
	}

	void equips(int equipcode,Item item){
		switch(equipcode){
		case 0:
			System.out.printf(" Helmet : ");
			break;
		case 1:
			System.out.printf(" Weapon : ");
			break;
		case 2:
			System.out.printf(" Armor  : ");
			break;
		case 3:
			System.out.printf(" Shield : ");
			break;
		case 4:
			System.out.printf(" Boots  : ");
			break;
		default:	// it has to be unreachable but just in case
			break;
		}
		System.out.printf("%s %s\n",itemNames[item.getItemcode()],item.statsToString());
	}

	void selectEquip(){
		System.out.println("        (5) ↑");
		System.out.println("(0)BACK (2) ↓  (ENTER) Choose");
		super.printBar();
		System.out.print(">");
	}

	void showEquiplist(int equipSelect, Item[] list, Player player){
		super.printBar();
		switch(equipSelect){
		case 0:
			System.out.print("⛑HELMET LIST⛑");
			break;
		case 1:
			System.out.print("⚔SWORD LIST⚔");
			break;
		case 2:
			System.out.print("🧥ARMOR LIST🧥");
			break;
		case 3:
			System.out.print("⛨SHIELD LIST⛨");
			break;
		case 4:
			System.out.print("👟BOOTS LIST👟");
			break;
		}
		System.out.printf("     Equipped : %s %s\n",player.equips[equipSelect].getName(),player.equips[equipSelect].statsToString());
		for(int i=0; i<list.length; i++){
			System.out.printf("%d. %s %s\n",i+1,list[i].getName(),list[i].statsToString());
		}
		super.printBar();
	}

	void getItem(Item item){
		System.out.printf("You got [%s] ! ",item.getName());
	}

	void dumpItem(Item item){
		System.out.printf("You dumped %s %s \n",item.getName(),item.statsToString());
	}


}
