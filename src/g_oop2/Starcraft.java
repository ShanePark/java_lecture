package g_oop2;

public class Starcraft {
	public static void main(String[] args) {
		Marine marine = new Marine();
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		SCV scv = new SCV();

		dropship.hp-= 5;
		scv.repair(tank);
		scv.repair(dropship);
		//scv.repair(marine);
	}

}

class Unit{
	int hp;
	final int MAX_HP;

	Unit(int hp){
		MAX_HP = hp;
		this.hp = MAX_HP;
	}
}

class Marine extends Unit{
	Marine(){
		super(40);
	}
}

class Tank extends Unit implements Repairable{
	Tank(){
		super(150);
	}
}

class Dropship extends Unit implements Repairable{
	Dropship(){
		super(125);
	}
}

class SCV extends Unit implements Repairable{
	SCV(){
		super(60);
	}

	void repair(Repairable r){
		if(r instanceof Unit){
			Unit u = (Unit)r;
			boolean repaired = false;

			while(u.hp < u.MAX_HP){
				repaired = true;
				u.hp++;
				System.out.printf("%s 체력 HP+1 %s / %s\n",u.getClass(),u.hp,u.MAX_HP);
				long start = System.currentTimeMillis();

				while(true){
					long end = System.currentTimeMillis();
					if(end-start >1000) break;
				}
			}
			if(u.hp==u.MAX_HP && repaired)
				System.out.println("수리완료");
		}
	}
	
//	void repair(Unit u){
//		System.out.printf("%s는 수리불가\n",u.getClass());
//	}
	
}

interface Repairable{

}



