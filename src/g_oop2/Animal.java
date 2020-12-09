package g_oop2;

public abstract class Animal {
	
	void run(){
		System.out.println("달려간다~~");
	}
	abstract void sound();
	
	public static void main(String[] args) {
		
		new Dog().sound();
		new Dog().run();
		new Cat().sound();
		new Cat().run();
		new Baby().sound();
		new Baby().run();
		
	}
}

class Dog extends Animal{
	void sound(){
		System.out.println("월월");
	}
}

class Cat extends Animal{
	void sound(){
		System.out.println("야옹");
	}
}

class Baby extends Animal{
	void sound(){
		System.out.println("응애");
	}
}