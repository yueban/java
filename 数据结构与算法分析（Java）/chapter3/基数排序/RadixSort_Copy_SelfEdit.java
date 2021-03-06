//基数排序————对网上的代码做出优化
public class RadixSort_Copy_SelfEdit{
	public static void main(String[] args){
		//声明要排序的数组
		int[] data = {73,22,93,867494,43,55,123,8978,10000,14,28,65,39,81,33,100,567};
		//调用基数排序函数
		sort(data,10);
		//输出排序后的数组
		for(int i = 0;i < data.length;i++){
			System.out.print(data[i] + " ");
		}
	}

	///基数排序函数
	//a表示要排序的数组
	//d表示每一位数字的范围（这里是10进制数，有0~9一共10种情况）
	public static void sort(int[] a,int d){
		//n用来表示当前排序的是第几位
		int n = 1;
		//hasNum用来表示数组中是否有至少一个数字存在第n位
		boolean hasNum = false;
		//二维数组temp用来保存当前排序的数字
		//第一维d表示一共有d个桶
		//第二维a.length表示每个桶最多可能存放a.length个数字
		int[][] temp = new int[d][a.length];
		int[] order = new int[d];
		while(true){
			//判断是否所有元素均无比更高位，因为第一遍一定要先排序一次，所以有n!=1的判断
			if(n != 1 && !hasNum){
				break;
			}
			hasNum = false;
			//遍历要排序的数组，将其存入temp数组中
			for(int i = 0;i < a.length;i++){
				int x = a[i]/(n*10);
				if(x != 0){
					hasNum = true;
				}
				int lsd = (x%10);
				temp[lsd][order[lsd]] = a[i];
				order[lsd]++;
			}
			//k用来将排序好的temp数组存入data数组
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