public class MaxSubSum{
	public static void main(String[] args){
		//System.out.println("This application is begining:");
		int[] a = new int[100000000];
		for(int i = 0;i < 10000000;i++){
			a[i * 10 + 0] = -2;
			a[i * 10 + 1] = 3;
			a[i * 10 + 2] = 7;
			a[i * 10 + 3] = 9;
			a[i * 10 + 4] = -5;
			a[i * 10 + 5] = 6;
			a[i * 10 + 6] = 11;
			a[i * 10 + 7] = -10;
			a[i * 10 + 8] = 4;
			a[i * 10 + 9] = 1;
		}
		
		//System.out.println(System.currentTimeMillis());
		//System.out.println(maxSubSum1(a));
		//System.out.println(System.currentTimeMillis());
		//System.out.println(maxSubSum2(a));
		System.out.println(System.currentTimeMillis());
		System.out.println(maxSubSum3(a));
		System.out.println(System.currentTimeMillis());
		System.out.println(maxSubSum4(a));
		System.out.println(System.currentTimeMillis());
	}
	
	///method 1:O(N的三次方)
	public static int maxSubSum1(int[] a){
		int maxSum = 0;
		for(int i = 0;i < a.length;i++){
			for(int j = i;j < a.length;j++){
				int thisSum = 0;
				for(int k = i;k <= j;k++){
					thisSum += a[k];
				}
				if(thisSum > maxSum){
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	
	///method 2:O(N的二次方)
	public static int maxSubSum2(int[] a){
		int maxSum = 0;
		for(int i = 0;i < a.length;i++){
			int thisSum = 0;
			for(int j = i;j < a.length;j++){
				thisSum += a[j];
				if(thisSum > maxSum){
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	
	///method 3:O(NlogN)
	public static int maxSubSum3(int[] a){
		return maxSumRec(a,0,a.length - 1);
	}
	
	public static int maxSumRec(int[] a,int left,int right){
		if(left == right){
			if(a[left] > 0){
				return a[left];
			}else{
				return 0;
			}
		}
		
		int center = (left + right) / 2;
		int maxLeftSum = maxSumRec(a,left,center);
		int maxRightSum = maxSumRec(a,center + 1,right);
		
		int maxLeftBorderSum = 0;
		int leftBorderSum = 0;
		for(int i = center;i >= left;i--){
			leftBorderSum += a[i];
			if(leftBorderSum > maxLeftBorderSum){
				maxLeftBorderSum = leftBorderSum;
			}
		}
		
		int maxRightBorderSum = 0;
		int rightBorderSum = 0;
		for(int i = center + 1;i <= right;i++){
			rightBorderSum += a[i];
			if(rightBorderSum > maxRightBorderSum){
				maxRightBorderSum = rightBorderSum;
			}
		}
		
		return max3(maxLeftSum,maxRightSum,maxLeftBorderSum + maxRightBorderSum);
	}
	
	public static int max3(int a,int b,int c){
		int max;
		if(a > b){
			if(a > c){
				max = a;
			}else{
				max = c;
			}
		}else if(b > c){
			max = b;
		}else{
			max = c;
		}
		return max;
	}
	
	///method 4:O(N)
	public static int maxSubSum4(int[] a){
		int maxSum = 0;
		int thisSum = 0;
		for(int i = 0;i < a.length;i++){
			thisSum += a[i];
			if(thisSum > maxSum){
				maxSum = thisSum;
			}else if(thisSum < 0){
				thisSum = 0;
			}
		}
		return maxSum;
	}
}