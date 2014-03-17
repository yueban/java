/* 11_练习（三）_算法优化 */
public class Test_11_better{
	public static void main(String args []){
	/* test_01：求100-200内素数，算法优化*/
	for(int i = 100;i < 201;i++){
		boolean b = true;
		for(int j = 2;j < Math.sqrt(i);j++){
			int k = i % j;
			if(k == 0){
				b = false;
			}
		}
		if(b == true){
			System.out.println(i);
		}
	}

/* test_02：打印任意行数的类似下图的图形：
				   *
				  * *
				 * * *
				* * * *

		int n = 10;
		for(int i = 1;i < n + 1;i++){
			for(int j = 1;j < n - i + 1;j++){
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