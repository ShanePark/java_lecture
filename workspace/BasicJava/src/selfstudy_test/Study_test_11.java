package selfstudy_test;


public class Study_test_11 {
	public static void main(String[] args) {
		C c = new C();
		c.method();
	}

}
class A{
	int x =1;
}
class B extends A{
	int x =2;
}
class C extends B{
	int x =3;
	void method(){
		System.out.println(this.x);
		System.out.println(super.x);
	}
}