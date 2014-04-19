public class GenericSort{
	public static void main(String[] args){
		Integer[] intArray = {new Integer(2),new Integer(4),new Integer(3)};
		Double[] doubleArray = {new Double(3.4),new Double(-2.2),new Double(5.2)};
		Character[] charArray = {new Character('a'),new Character('A'),new Character('0')};
		String[] stringArray = {"pzl","zl","yrz"};

		sort(intArray);
		sort(doubleArray);
		sort(charArray);
		sort(stringArray);

		printList(intArray);
		printList(doubleArray);
		printList(charArray);
		printList(stringArray);
	}

	public static void sort(Comparable[] list){
		for(int i = 0;i < list.length;i++){
			Comparable currentMin = list[i];
			int currentMinIndex = i;
			for(int j = i + 1;j < list.length;j++){
				if(currentMin.compareTo(list[j]) > 0){
					currentMin = list[j];
					currentMinIndex = j;
				}
			}

			if(currentMinIndex != i){
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}

	public static void printList(Object[] list){
		for(int i = 0;i < list.length;i++){
			System.out.println(list[i] + " ");
		}
		System.out.println();
	}
}