//数组实现栈
public class StackArTest{
	public static void main(String[] args){
		StackAr sa = new StackAr(5);
		sa.pop();
		sa.push("g");
		sa.push("t");
		sa.push(45);
		sa.push("d");
		System.out.println(sa.topAndPop());
		System.out.println(sa.top());
		sa.push("33");
		sa.push("s");
		sa.push("f");
	}
}

class StackAr{
	public StackAr(){
		this(DEFAULT_CAOACITY);
	}

	public StackAr(int capacity){
		topOfStack = -1;
		theArray = new Object[capacity];
	}

	public boolean isEmpty(){
		return topOfStack == -1;
	}

	public boolean isFull(){
		return topOfStack == theArray.length - 1;
	}

	public void push(Object x){
		if(isFull()){
			System.out.println("Stack OverFlow!");
			return;
		}
		theArray[++topOfStack] = x;
	}

	public Object top(){
		return isEmpty()?null:theArray[topOfStack];
	}

	public void pop(){
		if(isEmpty()){
			System.out.println("Stack UnderFlow!");
			return;
		}
		theArray[topOfStack--] = null;
	}

	public Object topAndPop(){
		if(isEmpty()){
			return null;
		}
		Object topItem = theArray[topOfStack];
		theArray[topOfStack--] = null;
		return topItem;
	}

	private Object[] theArray;
	private int topOfStack;

	static final int DEFAULT_CAOACITY = 10;
}