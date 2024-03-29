package player_Monster;


public class AllText_KOR extends AllText{

	private String[] monsterNames = {"토끼","늑대","고블린"};
	String getMonsterName(int number){
		return monsterNames[number];
	}


	private String[] itemNames = {"[없음]", 
				"",			"",		"", "", "", "", "" ,"", "", "", // 1 ~ 10 : Helmet
		/*11*/	"기본칼",		"",		"" ,"", "", "", "" ,"", "", "", // 11~ 20 : Weapon
		/*21*/	"가죽갑옷",	"",		"" ,"", "", "", "" ,"", "", "", // 21~ 30 : Armor
		/*31*/	"",			"",		"" ,"", "", "", "" ,"", "", "", // 31~ 40 : Shield
		/*41*/	"토끼털장화",	"",		"" ,"", "", "", "" ,"", "", "", // 41~ 50 : Boots
		/*51*/	"기본물약",	"" ,	"", "", "", "" ,"", "", "", ""};// 51~ 60 : Consumables
	
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
		System.out.print("이름을 입력하세요 > ");
	}
	void bye(String name){
		System.out.printf("[%s] 님 이용해 주셔서 감사합니다. 아직 세이브 기능은 제공하지 않습니다.",name);
	}
	void wrong(){
		System.out.print(">잘못된 명령어입니다. 다시 입력해주세요\n>");
	}

	void status(Player player){
		int expPercent = (int)((float)player.exp/player.exp_max*10);
		int hpPercent = (int)((float)player.hp/player.hp_max*10);
		super.printBar(); super.printEnter();
		System.out.print("■   ʕʘ̅͜ʘ̅ʔ          ■ XP ");System.out.printf("%3d/%3d      ",player.exp,player.exp_max);
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
		System.out.print("(0)메뉴로 돌아가기 (1)장비 교체 (2)인벤토리 ");
		if(player.bonusStats>0)
			System.out.printf(" (3)잔여 보너스 스탯 사용");
		super.printEnter(); super.printBar();
		System.out.print(">");
	}

	void welcomePlayer(Player player){
		System.out.println("DDIT에 오신것을 환영합니다 ["+player.name+"] 님. 잠시만 기다려주세요 ");
	}
	void loadingComplete(){
		System.out.println("\n■■■■■■■■■■■■■■■■  로딩이 완료되었습니다     ■■■■■■■■■■■■■■■■■");
	}
	void alreadyFull(){
		System.out.println("[무료] 당신의 체력은 이미 가득 찼습니다.");
	}
	void recover(int price){
		System.out.printf("[-%d gold] 체력을 회복중입니다 ",price);
		for(int i=0; i<5; i++){
			System.out.print(".");
			GameSystem.wait(500);
		}
		System.out.println("체력이 가득 찼습니다!");

	}
	void fieldlist(){
		super.printBar(); super.printEnter();
		System.out.println(  "  💪참여하고자 하는 사냥터를 고르세요 . 숫자를 입력해주세요💪 ");
		System.out.println(  "■■■ (1) 초급자 1 [ 레벨 1 몬스터만 출몰합니다.] ");
		System.out.println(  "■■■ (2) 초급자 2 [ 레벨 1 ~ 2 몬스터가 출몰합니다.]");
		System.out.println(  "■■■ (3) 초급자 3 [ 레벨 2 ~ 3 몬스터가 출몰합니다.]");
		System.out.println(  "■■■ (0) 메뉴로 돌아가기 ");
		super.printEnter();super.printBar();
		System.out.printf(">");
	}
	void levelup(int level){
		System.out.printf(" 레벨업!! 축하합니다 레벨 [%d] 이(가) 되었습니다.\n",level);
	}

	void menu(){
		super.printBar(); super.printEnter(); super.printEnter();
		System.out.println(  "■■■　　　　　　|　　　　　　|　　　　　　|　　　　　　|　　　　　　■■■■");
		System.out.println(  "■■■  캐릭터　  |　　사냥터　|   병원　   |   상점　   |   종료　   ■■■■");
		System.out.println(  "■■■　　(1)　   |   (2)  |   (3)  |   (4)  |   (5)  ■■■■");
		super.printEnter();  super.printEnter();super.printBar(); 
		System.out.print(  "> ");
	}


	void pressAny(){
		System.out.print("계속 하려면 엔터키를 눌러주세요 ..");
		GameSystem.nextLine();
	}

	void playerAttack(Player player, Monster monster,int damage){
		super.fightScreen(player,monster);
		System.out.printf("[%s]이(가) 공격으로 [%s]에게 %d 만큼 데미지를 주어었습니다.\n",player.name,monster.name,damage);
		System.out.printf("%s의 남은 HP : %d\n",monster.name,monster.hp);
	}
	void monsterAttack(Monster monster,Player player,int damage){
		super.fightScreen(player,monster);
		System.out.printf("[%s]이(가) 공격으로 [%s]에게 %d 만큼 데미지를 주어었습니다.\n",monster.name,player.name,damage);
		System.out.printf("%s의 남은 HP : %d\n",player.name,player.hp);
	}

	void fightStart(Player player,Monster monster){
		System.out.printf("야생의 %d레벨  %s을(를) 만났습니다. \n",monster.lv,monster.name);
		System.out.printf("%s 가 [%s]을(를) 향해 달려듭니다. \n",monster.name,player.name);
	}

	void killed(String str){
		System.out.printf("[%s]을 처치하였습니다. ",str);
	}

	void getGold(int gold,int playerGold){
		System.out.printf("[%d] 의 골드를 획득하였습니다. \n",gold,playerGold);
	}
	void expGet(int exp,int expMax,int playerExp){
		System.out.printf("[%d] 의 경험치를 획득하였습니다.(EXP %d/%d) \n",exp,playerExp,expMax);
	}


	void PlayerDie(String player,int gold, int hp, int hpMax,int goldRemain){
		System.out.printf("[%s]이(가) 사망했습니다.\n",player);
		System.out.printf("%d 의 골드를 잃고 부활했습니다. 현재체력 %d/%d 잔여골드 %d.\n",gold,hp,hpMax,goldRemain);
	}

	void notEnoughMoney(int price,int gold){
		System.out.printf(" [%d gold] 가 필요합니다. 잔액이 충분하지 않습니다. [잔액 %d gold] \n",price,gold);
	}

	void noBonusStats(){
		System.out.print("보너스 스탯이 존재하지 않습니다.\n");
	}

	void bonusText(Player player){
		System.out.printf("남은 보너스 스탯의 수 : [%d] 입니다. 올리고 싶은 스탯을 고르세요 HP(1) ATK(2) DEF(3) 이전화면으로(0)\n>",player.bonusStats);
	}
	void hpUp(Player player){
		System.out.printf("체력이 올랐습니다!!! [%d] -> [%d]\n",player.hp_max,player.hp_max+player.BONUSHP);
	}
	void atkUp(Player player){
		System.out.printf("공격력이 올랐습니다!!! [%d] -> [%d]\n",player.atk,player.atk+player.BONUSATK);
	}
	void defUp(Player player){
		System.out.printf("방어력이 올랐습니다!!! [%d] -> [%d]\n",player.def,player.def+player.BONUSDEF);
	}

	void shopMenu(){
		super.printBar();	super.printEnter(); super.printEnter();
		System.out.println(  "■■■    ⛽  떠돌이 상인의 상점에 오신 것을 환영합니다 ⛽                    ■■■■■■■");
		System.out.println(  "■■■    구매     |   판매     |  장비 강화   |   뒤로가기        ■■■■■■■");
		System.out.println(  "■■■    (1)  |   (2)  |   (3)   |    (0)     ■■■■■■■");
		super.printEnter();  super.printEnter();super.printBar();
		System.out.print(  "> ");
	}

	void buyItem(){
		System.out.printf(  "1골드를 내고 [%s]을 사시겠습니까? (예(1), 아니오(2) )\n",itemNames[51]);

	}

	void buySuccess(int price){
		System.out.printf("[%d] gold 를 지불하고 구매에 성공하였습니다.\n",price);

	}

	void inventoryFull(){
		System.out.println("인벤토리가 가득 찼습니다. 버릴 아이템 번호를 선택해주세요 (0 : 습득한 아이템 포기).\n>");
	}

	void itemList(Player player){
		for(int i=0; i<player.inventoryCount ; i++){
			System.out.printf("[%d번 아이템 ] : %s %s  ",i+1,player.inventory[i].getName(),player.inventory[i].statsToString());
			if(player.inventory[i].isEquipped())
				System.out.printf("[장착중]");
			if(player.inventory[i].getAmount() > 1)
				System.out.printf(" (%d개)",player.inventory[i].getAmount());
			System.out.printf("\n");
		}
		System.out.printf("보유중인 아이템은 총 [%d개] 입니다.\n",player.inventoryCount);

	}

	void chooseEquip(){
		System.out.print("착용하고 싶은 장비를 선택해주세요. (0) 돌아가기 (1~5) 아이템 선택 \n>");
	}

	void equips(int equipcode,Item item){
		switch(equipcode){
		case 0:	System.out.printf("　⛑ 헬멧 : ");	break;
		case 1:	System.out.printf("　⚔ 무기 : ");	break;
		case 2:	System.out.printf("　🧥 갑옷 : ");	break;
		case 3:	System.out.printf("　⛨ 방패 : ");	break;
		case 4:	System.out.printf("　👟 부츠 : ");	break;
		default:	// it has to be unreachable but just in case
			break;
		}
		System.out.printf("%s %s\n",itemNames[item.getItemcode()],item.statsToString());
	}

	void selectEquip(){
		System.out.println("            (5) ↑");
		System.out.println("(0)이전 화면으로 (2) ↓  (ENTER)선택");
		super.printBar();
		System.out.print(">");
	}

	void showEquiplist(int equipSelect, Item[] list, Player player){
		super.printBar();
		switch(equipSelect){
		case 0:	System.out.print("⛑HELMET LIST⛑");	break;
		case 1:	System.out.print("⚔SWORD LIST⚔");	break;
		case 2:	System.out.print("🧥ARMOR LIST🧥");	break;
		case 3:	System.out.print("⛨SHIELD LIST⛨");	break;
		case 4:	System.out.print("👟BOOTS LIST👟");	break;
		}
		System.out.printf("     장착중 : %s %s\n",player.equips[equipSelect].getName(),player.equips[equipSelect].statsToString());
		for(int i=0; i<list.length; i++){
			System.out.printf("%d. %s %s\n",i+1,list[i].getName(),list[i].statsToString());
		}
		super.printBar();
	}

	void getItem(Item item){
		System.out.printf("[%s] 을(를) 획득하였습니다! ",item.getName());
	}

	void dumpItem(Item item){
		System.out.printf("%s %s 을 버렸습니다.\n",item.getName(),item.statsToString());
	}
	

}
