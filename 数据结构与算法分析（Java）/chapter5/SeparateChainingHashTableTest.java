//分离链接法实现散列
public class SeparateChainingHashTableTest{
	public static void main(String[] args){
		SeparateChainingHashTable scht = new SeparateChainingHashTable();
		Employee e1 = new Employee("zhanglun",123);
		scht.insert(e1);
		scht.insert(new Employee("wujinlang",2.1));
		scht.insert(new Employee("yuranzi",32));
		scht.insert(new Employee("fanbaizhou",232.1));
		scht.insert(new Employee("ruishuhui",3332.1));
		scht.insert(new Employee("puzhiyuan",32.21));
		scht.insert(new Employee("xieqiongkun",352.1));
		scht.insert(new Employee("wuzhiliang",327.1));
		scht.insert(new Employee("kahjsdfk",32.231));
		scht.insert(new Employee("mzxgm",32.199));
		scht.insert(new Employee("mqoxwqm",326.1));
		scht.insert(new Employee("xmowe",362.1));
		scht.insert(new Employee("cxfxerx",632.1));
		scht.insert(new Employee("qweuoqwe",532.1));
		scht.insert(new Employee("gsdhfjakl",432.1));
		scht.insert(new Employee("ecuim",7732.1));
		scht.insert(new Employee("pohmo",9032.1));
		scht.insert(new Employee("wxedcr",320.1));
		System.out.println(((Employee)scht.find(e1)).getSalary());
	}
}

//Hashable接口
interface Hashable{
	int hash(int tableSize);
}

//实现了Hashable接口的Employee类，该类中私有成员name用来计算其存储在散列表中的下标（hash值）
class Employee implements Hashable{
	public Employee(String _name,double _salary){
		name = _name;
		salary = _salary;
	}

	public double getSalary(){
		return salary;
	}

	public int hash(int tableSize){
		return SeparateChainingHashTable.hash(name,tableSize);
	}

	public boolean equals(Object rhs){
		return name.equals(((Employee)rhs).name);
	}

	private String name;
	private double salary;
}

//散列表类
class SeparateChainingHashTable{
	public SeparateChainingHashTable(){
		this(DEFAULT_TABLE_SIZE);
	}

	//为了取余效果更好，这里计算出大于给定列表长度size的最小素数作为新的列表长度，并初始化列表数组
	public SeparateChainingHashTable(int size){
		theLists = new LinkedList[nextPrime(size)];
		for(int i = 0;i < theLists.length;i++){
			theLists[i] = new LinkedList();
		}
	}

	//插入方法，通过hash方法算出该元素所在列表的下标，然后将其插入该列表最前端
	public void insert(Hashable x){
		LinkedList whichList = theLists[x.hash(theLists.length)];
		LinkedListItr itr = whichList.find(x);
		if(itr.isPastEnd()){
			whichList.insert(x,whichList.zeroth());
		}
	}

	//删除方法，通过hash方法算出该元素所在列表的下标，然后将其从该列表删除
	public void remove(Hashable x){
		theLists[x.hash(theLists.length)].remove(x);
	}

	//查找方法，通过hash方法算出该元素所在列表的下标，然后从该列表中找出该元素并将其返回
	public Hashable find(Hashable x){
		return (Hashable)theLists[x.hash(theLists.length)].find(x).retrieve();
	}

	public void makeEmpty(){
		for(int i = 0;i < theLists.length;i++){
			theLists[i].makeEmpty();
		}
	}

	//核心方法，通过固定的计算公式计算出key和tableSize所确定的值，只要name和tableSize不变，返回值就不变
	//我们用该元素的hash值作为其所在列表数组的下标，这样，我们在做插入、查找等工作的时候，只需要计算一次hash值即可确定该元素所在列表
	//只需将该元素所在列表遍历一次即可，而不需要将所有的元素都遍历一遍
	public static int hash(String key,int tableSize){
		int hashVal = 0;
		for(int i = 0;i < key.length();i++){
			hashVal = 37 * hashVal + key.charAt(i);
		}
		hashVal %= tableSize;
		while(hashVal < 0){
			hashVal += tableSize;
		}
		return hashVal;
	}

	private static final int DEFAULT_TABLE_SIZE = 101;
	private LinkedList[] theLists;

	//计算大于n的最小素数
	private static int nextPrime(int n){
		if(n % 2 == 0){
			n++;
		}
		while(!isPrime(n)){
			n += 2;
		}
		return n;
	}

	//判断是否为素数
	private static boolean isPrime(int n){
		if(n == 1){
			return false;
		}
		if(n == 2 || n == 3){
			return true;
		}
		for(int i = 3;i * i <= n;i += 2){
			if(n % i == 0){
				return false;
			}
		}
		return true;
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

//链表迭代类，用于检索节点，因为节点只负责存储数据和指向下一个节点，所以需要一个类来扫描节点
//具有查看当前节点元素（retrieve()）和扫描下一个节点的方法（advance()）
class LinkedListItr{
	LinkedListItr(ListNode theNode){
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
		return new LinkedListItr(header);
	}

	public LinkedListItr first(){
		return new LinkedListItr(header.next);
	}

	public LinkedListItr find(Object x){
		ListNode itr = header.next;
		while(itr != null && !itr.element.equals(x)){
			itr = itr.next;
		}
		return new LinkedListItr(itr);
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
		return new LinkedListItr(itr);
	}

	public void insert(Object x,LinkedListItr p){
		if(p != null && p.current != null){
			p.current.next = new ListNode(x,p.current.next);
		}
	}

	private ListNode header;
}