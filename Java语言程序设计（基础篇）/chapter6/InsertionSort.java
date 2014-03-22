public class InsertionSort{
	public static void main(String[] args){
		int[] num = {2,4,1,8,5,6,3};
		insertionSort(num);
		for(int i : num){
			System.out.print(i + " ");
		}
	}

	public static void insertionSort(int[] num){
		for(int i = 1;i < num.length;i++){
			int temp = num[i];
			int j;
			for(j = i - 1;j >= 0 && num[j] > temp;j--){
					num[j + 1] = num[j];
			}
			num[j + 1] = temp;
		}
	}
}