public class BinarySearch{
	public static void main(String[] args){
		int[] num = {2,4,7,10,11,45,50,59,60,66,69,70,79};
		System.out.println(binarySearch(num,10));
	}

	public static int binarySearch(int[] num,int key){
		int low = 0;
		int high = num.length;
		while(low <= high){
			int mid = (low + high) / 2;
			if(num[mid] > key){
				high = mid - 1;
			}else if(num[mid] < key){
				low = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
}