//������
public class LinkedListTest{
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		list.insert(12,list.zeroth());
		list.insert(17,list.find(12));
		list.insert(11,list.find(12));
		list.insert(1,list.find(17));
		list.insert(9,list.findPrevious(1));
		printList(list);
		list.remove(12);
		printList(list);
		list.swapNext(11);
		printList(list);
		System.out.println(list.first().retrieve());
	}

	public static void printList(LinkedList theList){
		System.out.println("---------------List Start---------------");
		if(theList.isEmpty()){
			System.out.println("Empty list");
		}else{
			LinkedListItr itr = theList.first();
			while(!itr.isPastEnd()){
				System.out.print(itr.retrieve() + " ");
				itr.advance();
			}
		}
		System.out.println("\n---------------List End---------------\n");
	}
}

//����ڵ���
//element��ʾ�ýڵ�洢��Ԫ��
//next��ʾ�ýڵ����һ���ڵ㣬ͨ��next�����ǰ�ÿһ��Ԫ��ͨ�������������������ԽС�����
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

//����ö���࣬���ڼ����ڵ㣬��Ϊ�ڵ�ֻ����洢���ݺ�ָ����һ���ڵ㣬������Ҫһ������ɨ��ڵ�
//���Բ鿴��ǰ�ڵ㣨current�����鿴��ǰ�ڵ�Ԫ�أ�retrieve����ɨ����һ���ڵ㣨advance�����Ƿ�ɨ��������������isPastEnd��
class LinkedListItr{
	LinkedListItr(LinkedList theList,ListNode theNode){
		list = theList;
		current = theNode;
	}

	public boolean isPastEnd(){
		return current == null;
	}

	public Object retrieve(){
		return isPastEnd()?null:current.element;
	}

	public void advance(){
		if(!isPastEnd()){
			current = current.next;
		}
	}

	LinkedList list;
	ListNode current;
}

//�����࣬��һ����0���ڵ�Ϊ�գ�������־ͷ���
class LinkedList{
	public LinkedList(){
		header = new ListNode(null);
	}

	public boolean isEmpty(){
		return header.next == null;
	}

	public void makeEmpty(){
		header.next = null;
	}

	public LinkedListItr zeroth(){
		return new LinkedListItr(this,header);
	}

	public LinkedListItr first(){
		return new LinkedListItr(this,header.next);
	}

	public LinkedListItr find(Object x){
		ListNode itr = header.next;
		while(itr != null && !itr.element.equals(x)){
			itr = itr.next;
		}
		return new LinkedListItr(this,itr);
	}

	public void remove(Object x){
		LinkedListItr p = findPrevious(x);
		if(p.current.next != null){
			p.current.next = p.current.next.next;
		}
	}

	public LinkedListItr findPrevious(Object x){
		ListNode itr = header;
		while(itr.next != null && !itr.next.element.equals(x)){
			itr = itr.next;
		}
		return new LinkedListItr(this,itr);
	}

	public void insert(Object x,LinkedListItr p){
		System.out.println(p.list == this);
		if(p.list == this && p != null && p.current != null){
			p.current.next = new ListNode(x,p.current.next);
		}
	}

	//��x���ڽڵ�����֮��Ľڵ㽻��λ��
	public void swapNext(Object x){
		ListNode pNode = findPrevious(x).current;
		ListNode xNode = pNode.next;
		ListNode yNode = xNode.next;
		pNode.next = yNode;
		xNode.next = yNode.next;
		yNode.next = xNode;
	}

	private ListNode header;
}