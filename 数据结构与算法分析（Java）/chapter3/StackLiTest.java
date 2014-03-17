//¡¥±Ì µœ÷’ª
public class StackLiTest{
	public static void main(String[] args){
		StackLi sl = new StackLi();
		sl.push("123");
		sl.push("aa");
		sl.push("x");
		sl.push(5);
		sl.push("q");
		System.out.println(sl.top());
		sl.pop();
		System.out.println(sl.top());
		System.out.println(sl.topAndPop());
		System.out.println(sl.topAndPop());
		System.out.println(sl.topAndPop());
		System.out.println(sl.topAndPop());
		System.out.println(sl.top());
		sl.pop();
	}
}

class ListNode{
	ListNode(Object theElement){
		this(theElement,null);
	}

	ListNode(Object theElement,ListNode n){
		element = theElement;
		next = n;
	}

	Object element;
	ListNode next;
}

class StackLi{
	public StackLi(){
		topOfStack = null;
	}

	public boolean isFull(){
		return false;
	}

	public boolean isEmpty(){
		return topOfStack == null;
	}

	public void makeEmpty(){
		topOfStack = null;
	}

	public void push(Object x){
		topOfStack = new ListNode(x,topOfStack);
	}

	public Object top(){
		if(isEmpty()){
			return null;
		}
		return topOfStack.element;
	}

	public void pop(){
		if(isEmpty()){
			System.out.println("Stack UnderFlow!");
			return;
		}
		topOfStack = topOfStack.next;
	}

	public Object topAndPop(){
		if(isEmpty()){
			return null;
		}
		Object topItem = topOfStack.element;
		topOfStack = topOfStack.next;
		return topItem;
	}

	private ListNode topOfStack;
}