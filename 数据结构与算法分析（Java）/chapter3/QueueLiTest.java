//队列的链表实现
public class QueueLiTest{
	public static void main(String[] args){
		QueueLi ql = new QueueLi();
		ql.enQueue("a");
		System.out.println(ql.deQueue());
		ql.deQueue();
		
		ql.enQueue("a");
		ql.enQueue("b");
		System.out.println(ql.deQueue());
		System.out.println(ql.deQueue());
		ql.deQueue();
	}
}

//节点类
class ListNode{
	public ListNode(Object theElement){
		this(theElement,null);
	}

	public ListNode(Object theElement,ListNode n){
		element = theElement;
		n = next;
	}

	Object element;
	ListNode next;
}

//队列类
class QueueLi{
	public QueueLi(){
		makeEmpty();
	}

	public boolean isEmpty(){
		return front.next == null;
	}

	//makeEmpty用于初始化队列
	//注：如果将队列中的数据删除完，再插入新的数据时，也要调用这个方法，为了保证队列插入前，头结点和尾节点为同一节点，这也是我们这种实现方法的关键所在
	public void makeEmpty(){
		back = front = new ListNode(null);
	}

	public Object getFront(){
		if(isEmpty()){
			return null;
		}
		return front.next.element;
	}

	public void enQueue(Object x){
		if(isEmpty()){
			makeEmpty();
		}
		ListNode backItem = new ListNode(x);
		back.next = backItem;
		back = backItem;
	}

	public Object deQueue(){
		if(isEmpty()){
			System.out.println("Queue UnderFlow!");
			return null;
		}
		Object frontItem = front.next.element;
		front.next = front.next.next;
		return frontItem;
	}

	//front表示队列头部，不存储数据
	private ListNode front;
	//back表示队列尾部，存储数据
	private ListNode back;
}