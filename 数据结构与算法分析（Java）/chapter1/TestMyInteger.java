public class TestMyInteger{
	public static void main(String[] args){
		MyInteger[] m = { new MyInteger(4), new MyInteger(2), new MyInteger(1), new MyInteger(3), new MyInteger(5)};
		
		MyInteger a = findMax(m);
		
		System.out.println("Max Number is:" + a.intValue());
	}
	
	public static MyInteger findMax(MyInteger[] m){
		MyInteger maxValue = m[0];
		
		for(int i = 1;i < m.length;i++){
			if(maxValue.compareTo(m[i]) < 0){
				maxValue = m[i];
			}
		}
		return maxValue;
	}
}

class MyInteger implements Comparable{
	public MyInteger(int x){
		value = x;
	}
	
	public int intValue(){
		return value;
	}
	
	public int compareTo(Object rhs){
		return value < ((MyInteger)rhs).intValue() ?  -1 : value == ((MyInteger)rhs).intValue() ? 0 : 1;
	}

	private int value;
}