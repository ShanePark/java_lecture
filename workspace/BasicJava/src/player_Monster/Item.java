package player_Monster;
/*       0 : Default (None)
 *  1 ~ 10 : Helmet
 *  11~ 20 : Weapon
 *  21~ 30 : Armor
 *  31~ 40 : Shield
 *  41~ 50 : Boots
 *  51~ 60 : Consumables
 * 
 */

public class Item {
	
	String name;
	int itemcode;
	int attack,hp,armor;
	int requiredLevel;
	int amount;
	
	Item(String name, int itemcode, int requiredLevel){
		this.name = name;
		this.itemcode = itemcode;
		this.requiredLevel = requiredLevel;
		
	}

}
