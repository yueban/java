//单链表
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

//链表节点类
//element表示该节点存储的元素
//next表示该节点的下一个节点，通过next很像是吧每一个元素通过锁链链接起来，所以叫“链表”
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

//链表枚举类，用于检索节点，因为节点只负责存储数据和指向下一个节点，所以需要一个类来扫描节点
//可以查看当前节点（current）、查看当前节点元素（retrieve）、扫描下一个节点（advance）、是否扫描完了整个链表（isPastEnd）
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

//链表类，第一个（0）节点为空，用作标志头结点
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

	//将x所在节点与它之后的节点交换位置
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