/* 06_练习课（一） */
public class Test_06{
	public static void main(String args []){
		/* test_01
		//boolean b = true;
		//boolean b = false;
		boolean b = 0;
		System.out.println(b);
		*/
		
		/* test_02
		//字符的两边是单引号，字符串才是双引号
		//char c = 'a';
		char c= '中';
		System.out.println(c);
		*/
		
		/* test_03
		byte b = 0;
		//byte b = 200;
		short s = 0;
		int i = 0;
		long l = 1;
		//float f = 0.2;
		float f = 0.2F;
		double d= 0;
		//i = l;
		//System.out.println(b);
		//数据类型以计算过程中的最大的类型为准:
		//0.5为double，10、4、1为int，所以值类型取double
		//int j = 0.5 * 10 - 4 + 1;
		//b为byte，0为int，所以值类型取int
		//byte k = b + 0;
		//强制转换可能会发生不可预知的错误
		byte k = (byte)(b + 0);
		//下式结果为-56，是因为超出byte范围的数值从byte范围的开头从新计算
		//byte k = (byte)(b + 200);
		System.out.println(k);
		*/
	}
}