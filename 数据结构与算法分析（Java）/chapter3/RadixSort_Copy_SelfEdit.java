//�������򡪡����������ϵĴ��������Ż�
public class RadixSort_Copy_SelfEdit{
	public static void main(String[] args){
		//����Ҫ���������
		int[] data = {73,22,93,867494,43,55,123,8978,10000,14,28,65,39,81,33,100,567};
		//���û���������
		sort(data,10);
		//�������������
		for(int i = 0;i < data.length;i++){
			System.out.print(data[i] + " ");
		}
	}

	///����������
	//a��ʾҪ���������
	//d��ʾÿһλ���ֵķ�Χ��������10����������0~9һ��10�������
	public static void sort(int[] a,int d){
		//n������ʾ��ǰ������ǵڼ�λ
		int n = 1;
		//hasNum������ʾ�������Ƿ�������һ�����ִ��ڵ�nλ
		boolean hasNum = false;
		//��ά����temp�������浱ǰ���������
		//��һάd��ʾһ����d��Ͱ
		//�ڶ�άa.length��ʾÿ��Ͱ�����ܴ��a.length������
		int[][] temp = new int[d][a.length];
		int[] order = new int[d];
		while(true){
			//�ж��Ƿ�����Ԫ�ؾ��ޱȸ���λ����Ϊ��һ��һ��Ҫ������һ�Σ�������n!=1���ж�
			if(n != 1 && !hasNum){
				break;
			}
			hasNum = false;
			//����Ҫ��������飬�������temp������
			for(int i = 0;i < a.length;i++){
				int x = a[i]/(n*10);
				if(x != 0){
					hasNum = true;
				}
				int lsd = (x%10);
				temp[lsd][order[lsd]] = a[i];
				order[lsd]++;
			}
			//k����������õ�temp�������data����
			int k = 0;
			for(int i = 0;i < d;i++){
				if(order[i] != 0){
					for(int j = 0;j < order[i];j++){
						a[k] = temp[i][j];
						k++;
					}					
				}
				order[i] = 0;
			}
			n++;
		}
	}
}