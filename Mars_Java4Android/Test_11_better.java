/* 11_��ϰ������_�㷨�Ż� */
public class Test_11_better{
	public static void main(String args []){
	/* test_01����100-200���������㷨�Ż�*/
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

/* test_02����ӡ����������������ͼ��ͼ�Σ�
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