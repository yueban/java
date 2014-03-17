//基数排序————网上的代码（有一些小问题）
public class RadixSort_Copy{
	public static void main(String[] args){
		int[] data = {73,22,93,43,55,123,8978,14,28,65,39,81,33,100,567};
		sort(data,10);
		for(int i = 0;i < data.length;i++){
			System.out.print(data[i] + " ");
		}
	}

	public static void sort(int[] a,int d){
		int k = 0;
		int n = 1;
		int m = 1;
		int[][] temp = new int[a.length][a.length];
		int[] order = new int[a.length];
		while(m <= 4){
			for(int i = 0;i < a.length;i++){
				int lsd = ((a[i]/n)%10);
				temp[lsd][order[lsd]] = a[i];
				order[lsd]++;
			}
			for(int i = 0;i < d;i++){
				if(order[i] != 0){
					for(int j = 0;j < order[i];j++){
						a[k] = temp[i][j];
						k++;
					}					
				}
				order[i] = 0;
			}
			n *= 10;
			k = 0;
			m++;
		}
	}
}