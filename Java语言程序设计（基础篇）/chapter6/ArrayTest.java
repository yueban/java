public class ArrayTest{
	public static void main(String[] args){
		double[] d = {5,3.2,6,1,4,3,2,9,8};
		//调用sort方法为数组排序
		java.util.Arrays.sort(d);
		for(double n : d){
			System.out.print(n + " ");
		}
		System.out.println();

		char[] c = {'c','a','1','D'};
		java.util.Arrays.sort(c,0,3);
		for(char n : c){
			System.out.print(n + " ");
		}
		System.out.println();

		java.util.Arrays.fill(c,'x');
		for(char n : c){
			System.out.print(n + " ");
		}
	}
}