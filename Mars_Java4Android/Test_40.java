/* 40_Java���е����� */
public class Test_40{
	public static void main(String args []){
		/* test_01
		//����ľ�̬������
		//int arr [] = {5,3,5,7,1,7,2};
		//����Ķ�̬������
		int arr [] = new int[10];
		
		for(int i = 0;i < arr.length;i++){
			System.out.println(arr[i]);
		}
		*/
		
		/* test_02*/
		//��ά����ľ�̬������
		int arr [][] = {{1},{4,5,6},{8,9}};
		//��ά����Ķ�̬������
		//int arr [][] = new int[3][6];
		
		for(int i = 0;i < arr.length;i++){
			for(int j = 0;j < arr[i].length;j++){
				System.out.println(arr[i][j]);
			}
		}
	}
}