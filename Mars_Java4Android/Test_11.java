/* 11_��ϰ�Σ����� */
public class Test_11{
	public static void main(String args []){
		/* test_01:��ӡ100-200֮�����е�����
		1����ӡ100-200֮�����������
		2��forѭ���У�ÿ��ѭ��ִ��һ�Σ����ж�ѭ��������ֵ�Ƿ�Ϊ����������ǣ��ͽ�ѭ�������ĵ�ǰֵ��ӡ����
		a)����ж�n�Ƿ�Ϊ������������2��n���������������3��n���Դ����ƣ������2��n-1���޷�����n����ô��Ϊ����
		
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
		
		/* test_02����ӡ������ͼ�Σ�
					   *
					  * *
					 * * *
					* * * *
		1����forѭ����ӡ���С�*��
		2����ӡ���У�ÿ���ĸ���* ��
		3����ӡ���У���n����n����* ��
		4����ӡ���У���n����n����* ������n��֮ǰ��ӡ4-n���� ��
		
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