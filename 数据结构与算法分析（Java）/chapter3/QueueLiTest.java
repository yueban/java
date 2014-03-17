//���е�����ʵ��
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

//�ڵ���
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

//������
class QueueLi{
	public QueueLi(){
		makeEmpty();
	}

	public boolean isEmpty(){
		return front.next == null;
	}

	//makeEmpty���ڳ�ʼ������
	//ע������������е�����ɾ���꣬�ٲ����µ�����ʱ��ҲҪ�������������Ϊ�˱�֤���в���ǰ��ͷ����β�ڵ�Ϊͬһ�ڵ㣬��Ҳ����������ʵ�ַ����Ĺؼ�����
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

	//front��ʾ����ͷ�������洢����
	private ListNode front;
	//back��ʾ����β�����洢����
	private ListNode back;
}