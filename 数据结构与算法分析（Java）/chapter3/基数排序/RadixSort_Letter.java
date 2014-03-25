//用基数排序的思路给英文字符串排序
public class RadixSort_Letter{
	public static void main(String[] args){
		//声明要排序的数组
		String[] a = {"ac","ee","ef","b","z","f","ep","gaaa","azh","az","r"};
		//调用基数排序函数
		sort(a,4);
		//输出排序后的数组
		for(int i = a.length - 1;i >= 0;i--){
			System.out.print(a[i] + " ");
		}
	}

	///基数排序函数
	//a是要排序的数组
	//m表示数组元素最高位数，如我们排序的数组中位数最高的元素为gaaa，有4位
	public static void sort(String[] a,int m){
		int n = 0;
		//27表示每一位字符分成27类，其中1~26对应'a'~'z'
		//第0位专门用来存放没有高位字符的数组元素，如在比较第二位字符时，b,z,f等没有第二位字符的元素就存在temp[0]中
		//相对应的，ac存在temp[1]中，ef存在temp[5]中
		String[][] temp = new String[27][a.length];
		int[] order = new int[27];
		while(n < m){
			//这里声明String类型的数组b，将数组a中的每个元素倒序，然后放入数组b
			//如a[0]="abc"，则b[0]="cba"
			//之所以这样做，是为了解决下面调用charAt方法时索引的问题，脑子太笨，没想到更好的方法
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