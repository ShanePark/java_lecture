package player_Monster;
/* 0 : Default (None) 1 ~ 10 : Helmet //11~ 20 : Weapon //21~ 30 : Armor //31~ 40 : Shield //41~ 50 : Boots //51~ 60 : Consumables  */

public class BattleField {
	
	AllText text = null;
	BattleField(){
		switch(GameMain.language){
		case 1:
			text = new AllText_ENG();
			break;
		case 2:
			text = new AllText_KOR();
			break;
		}
	}
			//Monster(monstercode lv    hp    att   amr   exp  money)  // EXP TABLE {0, 10, 20, 45, 90, 200, 500, 800, 2500}
	Monster m0 = new Monster(0,   1,   70,    12,    1,   5,   1);	//rabbit
	Monster m1 = new Monster(1,   2,   130,   18,    3,   9,   2);	//wolf
	Monster m2 = new Monster(2,   3,   250,   35,    10,   30,  5);	//goblin
	Item rabbitShoes = new Item(41,0,35,2);		// Item(int itemcode,int att, int hp, int def)
	
	
	Monster monster;
	
	void field1(Player player){	
		monster = m0;
		battle(player,monster);
		
		if((float)player.hp/player.hp_max>0.1 && !player.haveItem(rabbitShoes) && Math.random()>0.6)	// first item event, rabbitShoes
			player.getItem(rabbitShoes);
	}
	
	void field2(Player player){	
		monster = (int)(Math.random()*2)==1? m0 : m1;
		battle(player,monster);
	}
	
	void field3(Player player){	
		monster = (int)(Math.random()*2+1)==2? m1 : m2;
		battle(player,monster);
	}
	
	void battle(Player player,Monster m){
		final int fight_delay = 1200;
		text.fightScreen(player, m);
		text.fightStart(player,m);
		GameSystem.wait(fight_delay);
		battle : while(true){
			player.attack(m);
			GameSystem.wait(fight_delay);
			if(m.hp <= 0){
				text.fightScreen(player, m);
				text.killed(m.name);
				m.hp=m.hp_max;
				player.getGold(m.money);
				player.getExp(m.exp);
				text.pressAny();
				break battle;
			}
			m.attack(player);
			GameSystem.wait(fight_delay);
			if(player.hp <=0){
				text.fightScreen(player, m);
				player.die();
				m.hp=m.hp_max;
				break;
			}
		}
	}
	

}
