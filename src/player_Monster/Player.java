package player_Monster;

public class Player{
	int lv;
	int exp_max;
	int exp = 0;
	int hp_max, hp_bonus=0;
	int hp;
	int gold;
	int atk = 30, atk_bonus = 0;
	int def = 0, def_bonus = 0;
	int bonusStats = 3;
	final int BONUSHP = 20, LVUPHP = 20;
	final int BONUSATK = 4, LVUPATK = 4;
	final int BONUSDEF = 2, LVUPDEF = 2;
	String name;
	Item defaultItem = new Item(0,0,0,0);	// DEFAULT ITEM WHICH IS [NONE]
	Item[] equips = {defaultItem,defaultItem,defaultItem,defaultItem,defaultItem}; // { Helmet, Weapon, Armor, Shield, Boots}
	Item[] inventory = new Item[10];
	int inventoryCount=0;
	int[] exp_table = {0, 10, 20, 45, 90, 200, 500, 800, 2500};
	AllText text = null;

	Player(){
		this(1,80,10);	// Player Constructor (START LEVEL, START HP, START GOLD)
		text.welcome();
		this.name = GameSystem.nextLine();
	}
	Player(int lv, int hp, int gold){
		switch(GameMain.language){
		case 1:
			text = new AllText_ENG();
			break;
		case 2:
			text = new AllText_KOR();
			break;
		}
		this.lv = lv;
		this.exp_max = exp_table[lv];
		this.hp_max = hp;
		this.hp = hp;
		this.gold = gold;
		
		final int startItem1 = 11,startItem2=21;		// Getting free start item
		inventory[0] = new Item(startItem1,8,0,0);		// start item is a basic sword Item(int itemcode,int att, int hp, int def)	
		inventory[1] = new Item(startItem2,0,0,4);		// start armor
		inventoryCount += 2;							// It's not equipped yet but still in inventory
	}

	void getExp(int exp){
		this.exp += exp;
		text.expGet(exp,this.exp_max,this.exp);
		while( exp_max <= this.exp){
			this.exp -= exp_max;
			lvup();
		}
	}

	void lvup(){
		lv++;
		exp_max = exp_table[lv];
		hp_max += LVUPHP;
		atk += LVUPATK;
		def += LVUPDEF;
		hp = hp_max;
		bonusStats += lv/10+1;	// BONUS STAT WILL START FROM 1, INCREASE EVERY 10 LEVELS
		text.levelup(lv);
	}

	void getGold(int gold){
		this.gold+=gold;
		text.getGold(gold,this.gold);
	}
	void recover(){
		int recoverPrice = lv/10+1;	// RECOVER PRICE WILL START FROM 1, INCREASE EVERY 10 LEVELS
		if(this.hp == this.hp_max){
			text.alreadyFull();
		}else if(gold >= recoverPrice){
			this.gold -= recoverPrice;
			this.hp = this.hp_max;
			text.recover(recoverPrice);
		}
		else
			text.notEnoughMoney(recoverPrice,gold);
		text.pressAny();
	}

	void attack(Monster m){
		int damage = atk + atk_bonus - m.def;
		damage = damage <= 0 ? 1: damage;
		m.hp = m.hp < damage ? m.hp - m.hp : m.hp - damage;
		text.playerAttack(this,m,damage);
		
	}

	void die(){
		int goldMinus = lv;
		if(gold> goldMinus) gold -= goldMinus;
		else gold = 0;
		text.PlayerDie(name,goldMinus,hp_max/10,hp_max,gold);
		hp = hp_max/10;
		text.pressAny();
	}

	void hpUp(){
		if(bonusStats>0){
			text.hpUp(this);
			hp_max += BONUSHP;
			hp+= BONUSHP;	// recover as much as bonus HP is
			bonusStats --;
		}
	}
	void atkUp(){
		if(bonusStats>0){
			text.atkUp(this);
			atk += BONUSATK;
			bonusStats --;
		}

	}
	void defUp(){
		if(bonusStats>0){
			text.defUp(this);
			def += BONUSDEF;
			bonusStats --;
		}
	}

	void buyItem(int itemcode, int price){
		text.buyItem();
		switch(GameSystem.nextLine()){
		case "1":
			if(gold<price){
				text.notEnoughMoney(price, gold);
				return;
			}
			gold -= price;
			this.newItem(itemcode);
			text.buySuccess(price);
			break;
		case "2":
			break;
		default:
			text.wrong();
			break;
		}
	}
	void newItem(int itemcode){
		int i;
		for(i=0; i<inventory.length; i++){
			if(inventory[i] == null)
				break;
		}
		if(inventory[i] != null){
			text.inventoryFull();
			return;
		}else{
			if(i!=0){	// check duplicated items only when player have any item
				for(int j=0; j<inventoryCount; j++){
					if(inventory[j].getItemcode()==itemcode){
						inventory[j]
								.setAmount(inventory[j].getAmount() + 1);
						return;
					}
				}
			}

			inventory[i] = new Item(itemcode,0,0,0); //(int itemcode,int att, int hp, int def)
			inventoryCount++;
			inventory[i].setAmount(inventory[i].getAmount() + 1);
		}
	}

	void itemList(){
		text.itemList(this);
		for(int i=0; i<inventory.length-inventoryCount-2;i++)
			text.printEnter();
		text.pressAny();
	}


	void equiplist(){
		int equipSelect = 0;
		equipSelect : while(true){
			text.printBar();
			for(int i=0; i<5; i++){
				if(equipSelect ==i) System.out.print("■"); else System.out.print("□");	// SELECT EQIUP VISUAL SYSTEM
				text.equips(i,equips[i]);
			}
			text.selectEquip();
			String input = GameSystem.nextLine();
			switch(input){
			case "0" : 
				break equipSelect;
			case "2" :
				if(0<= equipSelect && equipSelect <=3)
					equipSelect++;
				else equipSelect = 0;
				break;
			case "5" :
				if(1<= equipSelect && equipSelect <=4)
					equipSelect--;
				else equipSelect = 4;
				break;
			case "" :
				changeEquip(equipSelect);
				break;
			default :
				text.wrong();
			}
		}
	}
	
	void changeEquip(int equipSelect){
		int showlists = 5;	// WILL ONLY SHOW [5] ITEMS WHICH ARE ABLE TO EQUIP ON 'EQUIPSELECT' PART
		Item[] equipList = new Item[showlists];
		int count=0;
		int[] rememberInventory = new int[showlists];
		for(int i=0; i<inventoryCount; i++){
			if((inventory[i].getItemcode()-1)/10==equipSelect && !inventory[i].isEquipped()){
				equipList[count] = inventory[i];
				rememberInventory[count] = i;
				count++;
				if(count >= showlists)
					break;
			}		
		}
		for(int i=count; i<showlists; i++)
			equipList[i] = defaultItem;	
		text.showEquiplist(equipSelect, equipList, this);
		text.chooseEquip();
		
		String input = GameSystem.nextLine();
		switch(input){
		case "0": break;
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
			int inputInt = Integer.parseInt(input)-1; 	// use input to find equipment
			if(equipList[inputInt] == defaultItem)		// if you select default item to equip
				equipItem(equipSelect,defaultItem);		// it does
			else equipItem(equipSelect, equipList[inputInt]);	//else it equip item you choose
			break;
		default :
			text.wrong();
			text.pressAny();
		}
		
	}
	
	void equipItem(int part, Item item){ 	/* 0HELMET / 1SWORD / 2ARMOR / 3SHIELD / 4BOOTS */
		if(equips[part] != defaultItem){		// ONLY WHEN [PART] IS EQUIPPED 
			equips[part].setEquipped(false);
			hp_bonus -= item.getHp();                 //
			hp_max -= item.getHp();                   //
			if(hp>item.getHp())                       // take equipment off
				hp-=item.getHp();                     //
			atk_bonus -= item.getAtt();               //
			def_bonus -= item.getDef();               //
		}                                        //
		if(item != defaultItem){
			item.setEquipped(true);
			hp_bonus += item.getHp();
			hp_max += item.getHp();
			hp += item.getHp();
			atk_bonus += item.getAtt();
			def_bonus += item.getDef();
		}
		equips[part] = item;
		
	}
	
	void getItem(Item item){ 
		text.getItem(item);
		text.pressAny();
		int i;
		if(inventoryCount == inventory.length){	// when you picked up an item but inventory is already full
			text.itemList(this);
			text.inventoryFull();
			fullInventory(item);
			return;
		}
		for(i=0; i<inventory.length; i++){	//if inventory is not full
			if(inventory[i]==null){
				break;
			}
		}
		inventory[i] = item;
		inventoryCount++;	  
	}
	
	void fullInventory(Item item){
		String input = GameSystem.nextLine();
		switch(input){
		case "0": break;
		case "1":case "2":case "3":case "4":case "5":
		case "6":case "7":case "8":case "9":case "10":
			int inputInt = Integer.parseInt(input)-1;	// Arrays are from 0, item numbers are from 1
			text.dumpItem(inventory[inputInt]);
			inventory[inputInt]=item;
			break;
		default : 
			text.wrong();
			fullInventory(item);
		}
	}
	
	boolean haveItem(Item item){
		for(int i=0; i<inventoryCount; i++){
			if(inventory[i].getItemcode() == item.getItemcode())
				return true;
		}
		return false;
	}
	
	
	void sellItem(){ // need to be filled

	}
	

}



