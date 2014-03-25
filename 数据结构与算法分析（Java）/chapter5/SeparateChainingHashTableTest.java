//�������ӷ�ʵ��ɢ��
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

//Hashable�ӿ�
interface Hashable{
	int hash(int tableSize);
}

//ʵ����Hashable�ӿڵ�Employee�࣬������˽�г�Աname����������洢��ɢ�б��е��±꣨hashֵ��
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

//ɢ�б���
class SeparateChainingHashTable{
	public SeparateChainingHashTable(){
		this(DEFAULT_TABLE_SIZE);
	}

	//Ϊ��ȡ��Ч�����ã������������ڸ����б���size����С������Ϊ�µ��б��ȣ�����ʼ���б�����
	public SeparateChainingHashTable(int size){
		theLists = new LinkedList[nextPrime(size)];
		for(int i = 0;i < theLists.length;i++){
			theLists[i] = new LinkedList();
		}
	}

	//���뷽����ͨ��hash���������Ԫ�������б���±꣬Ȼ���������б���ǰ��
	public void insert(Hashable x){
		LinkedList whichList = theLists[x.hash(theLists.length)];
		LinkedListItr itr = whichList.find(x);
		if(itr.isPastEnd()){
			whichList.insert(x,whichList.zeroth());
		}
	}

	//ɾ��������ͨ��hash���������Ԫ�������б���±꣬Ȼ����Ӹ��б�ɾ��
	public void remove(Hashable x){
		theLists[x.hash(theLists.length)].remove(x);
	}

	//���ҷ�����ͨ��hash���������Ԫ�������б���±꣬Ȼ��Ӹ��б����ҳ���Ԫ�ز����䷵��
	public Hashable find(Hashable x){
		return (Hashable)theLists[x.hash(theLists.length)].find(x).retrieve();
	}

	public void makeEmpty(){
		for(int i = 0;i < theLists.length;i++){
			theLists[i].makeEmpty();
		}
	}

	//���ķ�����ͨ���̶��ļ��㹫ʽ�����key��tableSize��ȷ����ֵ��ֻҪname��tableSize���䣬����ֵ�Ͳ���
	//�����ø�Ԫ�ص�hashֵ��Ϊ�������б�������±꣬�����������������롢���ҵȹ�����ʱ��ֻ��Ҫ����һ��hashֵ����ȷ����Ԫ�������б�
	//ֻ�轫��Ԫ�������б����һ�μ��ɣ�������Ҫ�����е�Ԫ�ض�����һ��
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

	//�������n����С����
	private static int nextPrime(int n){
		if(n % 2 == 0){
			n++;
		}
		while(!isPrime(n)){
			n += 2;
		}
		return n;
	}

	//�ж��Ƿ�Ϊ����
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

//��������࣬���ڼ����ڵ㣬��Ϊ�ڵ�ֻ����洢���ݺ�ָ����һ���ڵ㣬������Ҫһ������ɨ��ڵ�
//���в鿴��ǰ�ڵ�Ԫ�أ�retrieve()����ɨ����һ���ڵ�ķ�����advance()��
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