/* 07_运算符与表达式 */
public class Test_07{
	public static void main(String args []){
		
		/* test_01
		//int i = 3 / 2;
		//int i = 3 / 2.0;
		double i = 3 / 2.0;
		System.out.println(i);
		*/
		
		/* test_02
			int i = 5;
			//int j = i++ + 5;
			int j = ++i + 5;
			System.out.println(j);
			System.out.println(i);
		*/
		
		/* test_03
		int i = 5;
		//int j = 6;
		int j = 5;
		//boolean b = i > j;
		boolean b = i == j;
		System.out.println(b);
		*/
		
		/* test_04
		boolean a = true;
		boolean b = false;
		boolean c = a & b;
		boolean d = a && b;
		System.out.println(c);
		System.out.println(d);
		
		int i = 5;
		//boolean e = i > 6 & i++ > 7;
		boolean e = i > 6 && i++ > 7;
		System.out.println(e);
		System.out.println(i);
		*/
	}
}
