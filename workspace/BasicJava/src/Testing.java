import java.util.Arrays;


public class Testing {
	static int a = 1;

	public static void main(String[] args) {
		
		Test test = new Test();
		System.out.println(Testing.a);
		a++;
		System.out.println(test.test());
		System.out.println(Testing.a);

	}



}

class Test{
	int test(){
		Testing.a ++;
		return Testing.a;
	}

}






