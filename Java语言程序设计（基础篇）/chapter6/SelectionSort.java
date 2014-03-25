public class SelectionSort{
	public static void main(String[] args){
		int numItems = 115;
		int base = 37;
		int[] num = new int[numItems];
		for(int i = base,j = 0;i != 0;i = (i + base) % numItems,j++){
			num[j] = i;
			System.out.print(i + " ");
		}
		System.out.println();
		selectionSort(num);
		for(int i : num){
			System.out.print(i + " ");
		}
	}

	public static void selectionSort(int[] num){
		for(int i = 0;i < num.length;i++){
			int minIndex = i;
			int minNum = num[i];
			for(int j = i + 1;j < num.length;j++){
				if(minNum > num[j]){
					minNum = num[j];
					minIndex = j;
				}
			}
			if(minIndex != i){
				num[minIndex] = num[i];
				num[i] = minNum;
			}
		}
	}
}