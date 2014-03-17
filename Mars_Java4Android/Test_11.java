/* 11_练习课（三） */
public class Test_11{
	public static void main(String args []){
		/* test_01:打印100-200之间所有的素数
		1、打印100-200之间的所有整数
		2、for循环中，每当循环执行一次，就判断循环变量的值是否为素数，如果是，就将循环变量的当前值打印出来
		a)如果判断n是否为素数，首先用2除n，如果除不尽再用3除n，以此类推，如果从2到n-1都无法整除n，那么就为素数
		
		for(int i = 100;i < 201;i++){
			//System.out.println(i);
			boolean b = false;
			for(int j = 2;j < i - 1;j++){
				int k = i % j;
				if(k == 0){
					b = true;
				}
			}
			if(b == false){
				System.out.println(i);
			}
		}
		*/
		
		/* test_02：打印除如下图形：
					   *
					  * *
					 * * *
					* * * *
		1、用for循环打印四行“*”
		2、打印四行，每行四个“* ”
		3、打印四行，第n行有n个“* ”
		4、打印四行，第n行有n个“* ”，第n行之前打印4-n个“ ”
		
		for(int i = 1;i < 5;i++){
			for(int j = 1;j < 5 - i;j++){
				System.out.print(" ");
			}
			for(int k = 1;k < i + 1;k++){
				System.out.print("* ");
			}
			System.out.println("");
		}
		*/
	}
}