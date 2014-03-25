//开放定址法之平方探测法实现散列
public class QuadraticProbingHashTableTest{
	public static void main(String[] args){
		QuadraticProbingHashTable qpht = new QuadraticProbingHashTable();
		Employee e1 = new Employee("zhanglun",123);
		qpht.insert(e1);
		qpht.insert(new Employee("wujinlang",2.1));
		qpht.insert(new Employee("yuranzi",32));
		qpht.insert(new Employee("fanbaizhou",232.1));
		qpht.insert(new Employee("ruishuhui",3332.1));
		qpht.insert(new Employee("puzhiyuan",32.21));
		qpht.insert(new Employee("xieqiongkun",352.1));
		qpht.insert(new Employee("wuzhiliang",327.1));
		qpht.insert(new Employee("kahjsdfk",32.231));
		qpht.insert(new Employee("mzxgm",32.199));
		qpht.insert(new Employee("mqoxwqm",326.1));
		qpht.insert(new Employee("xmowe",362.1));
		qpht.insert(new Employee("cxfxerx",632.1));
		qpht.insert(new Employee("qweuoqwe",532.1));
		qpht.insert(new Employee("gsdhfjakl",432.1));
		qpht.insert(new Employee("ecuim",7732.1));
		qpht.insert(new Employee("pohmo",9032.1));
		qpht.insert(new Employee("wxedcr",320.1));
		System.out.println(((Employee)qpht.find(e1)).getSalary());
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
		return QuadraticProbingHashTable.hash(name,tableSize);
	}

	public boolean equals(Object rhs){
		return name.equals(((Employee)rhs).name);
	}

	private String name;
	private double salary;
}

//实际存放在散列数组中的对象，在散列中有三种状态
//1) null
//2) 非null，isActive为true，表示Hashable对象被存储在散列中
//3) 非null，isActive为false，表示Hashable对象在散列中是被删除的状态
class HashEntry{
	public HashEntry(Hashable e){
		this(e,true);
	}

	public HashEntry(Hashable e,boolean i){
		element = e;
		isActive = i;
	}

	Hashable element;
	boolean isActive;
}

//散列
class QuadraticProbingHashTable{
	public QuadraticProbingHashTable(){
		this(DEFAULT_TABLE_SIZE);
	}

	public QuadraticProbingHashTable(int size){
		allocateArray(size);
		makeEmpty();
	}

	public void makeEmpty(){
		currentSize = 0;
		for(int i = 0;i < array.length;i++){
			array[i] = null;
		}
	}

	public Hashable find(Hashable x){
		int currentPos = findPos(x);
		return isActive(currentPos)?array[currentPos].element:null;
	}

	public void insert(Hashable x){
		int currentPos = findPos(x);
		if(isActive(currentPos)){
			return;
		}
		array[currentPos] = new HashEntry(x,true);
		//如果当前已存储元素的个数超过了数组总长度的一半，则会影响findPos的效率，我们需要将其扩容
		if(++currentSize > array.length / 2){
			rehash();
		}
	}

	public void remove(Hashable x){
		int currentPos = findPos(x);
		if(isActive(currentPos)){
			array[currentPos].isActive = false;
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

	public static final int DEFAULT_TABLE_SIZE = 11;

	protected HashEntry[] array;
	private int currentSize;

	private void allocateArray(int arraySize){
		array = new HashEntry[arraySize];
	}

	private boolean isActive(int currentPos){
		return array[currentPos] != null && array[currentPos].isActive;
	}

	private int findPos(Hashable x){
		int collisionNum = 0;
		int currentPos = x.hash(array.length);
		while(array[currentPos] != null && !array[currentPos].element.equals(x)){
			currentPos += 2 * ++collisionNum - 1;
			if(currentPos > array.length){
				currentPos -= array.length;
			}
		}
		return currentPos;
	}

	//将散列扩容
	private void rehash(){
		HashEntry[] oldArray = array;
		allocateArray(nextPrime(2 * oldArray.length));
		currentSize = 0;
		for(int i = 0;i < oldArray.length;i++){
			if(oldArray[i] != null && oldArray[i].isActive){
				insert(oldArray[i].element);
			}
		}
	}

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