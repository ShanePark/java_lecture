package d_array;

public class StringSpeedTest {

	public static void main(String[] args) {
		String str = "a";	
		long start = System.currentTimeMillis();
		
		
//		for(int i=0; i< 200000; i++){
//			str += "a";
//		}

		StringBuffer sb = new StringBuffer("a");	
		for(int i=0; i< 100000000; i++){
			sb.append("a");
		}
		
		
		long end = System.currentTimeMillis();
		System.out.println(end-start+"ms");
		
		
	}

}
