/* 40_Java当中的数组 */
public class Test_40{
	public static void main(String args []){
		/* test_01
		//数组的静态声明法
		//int arr [] = {5,3,5,7,1,7,2};
		//数组的动态声明法
		int arr [] = new int[10];
		
		for(int i = 0;i < arr.length;i++){
			System.out.println(arr[i]);
		}
		*/
		
		/* test_02*/
		//二维数组的静态声明法
		int arr [][] = {{1},{4,5,6},{8,9}};
		//二维数组的动态声明法
		//int arr [][] = new int[3][6];
		
		for(int i = 0;i < arr.length;i++){
			for(int j = 0;j < arr[i].length;j++){
				System.out.println(arr[i][j]);
			}
		}
	}
}