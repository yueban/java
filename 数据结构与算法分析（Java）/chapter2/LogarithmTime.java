public class LogarithmTime{
	public static void main(String[] args){
		/*�Էֲ���
		int[] a = new int[100000000];
		for(int i = 0;i < 100000000;i++){
			a[i] = i + 1;
		}
		System.out.println(System.currentTimeMillis());
		System.out.println(binarySearch(a,-1));
		System.out.println(System.currentTimeMillis());
		*/
		
		/*ŷ������㷨
		System.out.println(gcd(1989,1590));
		*/

		/*������
		long x = 2;
		long n = 50;
		long i = 0,j = 0,k = 1000000;
		System.out.println(System.currentTimeMillis());
		while(i < k){
			pow(x,n);
			i++;
		}
		System.out.println(System.currentTimeMillis());
		while(j < k){
			Math.pow(x,n);
			j++;
		}
		System.out.println(System.currentTimeMillis());
		*/

		/*���ѡȡ����С��N�Ļ������������صĸ���*/
		System.out.println("time--->" + System.currentTimeMillis());
		System.out.println(probRelPrime(10000));
		System.out.println("time--->" + System.currentTimeMillis());
	}
	
	//�Էֲ���
	public static int binarySearch(int[] a,int x){
		int low = 0,high = a.length - 1;
		
		while(low <= high){
			int mid = (low + high) / 2;
			if(a[mid] < x){
				low = mid + 1;
			}else if(a[mid] > x){
				high = mid - 1;
			}else{
				return mid;
			}
		}
		return -1;//-1:NUM_NOT_FOUND
	}

	//ŷ������㷨
	public static int gcd(int m,int n){
		while(n != 0){
			int rem = m % n;
			m = n;
			n = rem;
		}
		return m;
	}

	//������
	public static double pow(long x,long n){
		return n == 0?1:n == 1?x:isEven(n)?pow(x * x,n / 2):pow(x * x,n / 2) * x;
	}

	public static boolean isEven(long n){
		return n % 2 == 0?true:false;
	}

	//���ѡȡ����С��N�Ļ������������صĸ���
	public static double probRelPrime(int N){
		int rel = 0,tot = 0;
		for(int i = 1;i < N;i++){
			for(int j = 1;j < N;j++){
				tot++;
				if(gcd(i,j) == 1){
					rel++;
				}
			}
		}
		return (double)rel/tot;
	}
}