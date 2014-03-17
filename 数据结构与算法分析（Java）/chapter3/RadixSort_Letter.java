//�û��������˼·��Ӣ���ַ�������
public class RadixSort_Letter{
	public static void main(String[] args){
		//����Ҫ���������
		String[] a = {"ac","ee","ef","b","z","f","ep","gaaa","azh","az","r"};
		//���û���������
		sort(a,4);
		//�������������
		for(int i = a.length - 1;i >= 0;i--){
			System.out.print(a[i] + " ");
		}
	}

	///����������
	//a��Ҫ���������
	//m��ʾ����Ԫ�����λ���������������������λ����ߵ�Ԫ��Ϊgaaa����4λ
	public static void sort(String[] a,int m){
		int n = 0;
		//27��ʾÿһλ�ַ��ֳ�27�࣬����1~26��Ӧ'a'~'z'
		//��0λר���������û�и�λ�ַ�������Ԫ�أ����ڱȽϵڶ�λ�ַ�ʱ��b,z,f��û�еڶ�λ�ַ���Ԫ�ؾʹ���temp[0]��
		//���Ӧ�ģ�ac����temp[1]�У�ef����temp[5]��
		String[][] temp = new String[27][a.length];
		int[] order = new int[27];
		while(n < m){
			//��������String���͵�����b��������a�е�ÿ��Ԫ�ص���Ȼ���������b
			//��a[0]="abc"����b[0]="cba"
			//֮��������������Ϊ�˽���������charAt����ʱ���������⣬����̫����û�뵽���õķ���
			String[] b = new String[a.length];
			for(int i = 0;i < a.length;i++){
				if(a[i].length() > 1){
					StringBuffer sb = new StringBuffer(a[i]);
					sb.reverse();
					b[i] = new String(sb);
				}else{
					b[i] = a[i];
				}
			}

			for(int i = 0;i < a.length;i++){
				if(a[i].length() > n){
					int lsd = b[i].charAt(n) - 'a' + 1;
					temp[lsd][order[lsd]] = a[i];
					order[lsd]++;
				}else{
					temp[0][order[0]] = a[i];
					order[0]++;
				}
			}

			int k = 0;
			for(int i = 0;i < 27;i++){
				for(int j = 0;j < order[i];j++){
					a[k] = temp[i][j];
					k++;
				}
				order[i] = 0;
			}

			n++;
		}
	}
}