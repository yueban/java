//���Ŷ�ַ��֮ƽ��̽�ⷨʵ��ɢ��
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
		return QuadraticProbingHashTable.hash(name,tableSize);
	}

	public boolean equals(Object rhs){
		return name.equals(((Employee)rhs).name);
	}

	private String name;
	private double salary;
}

//ʵ�ʴ����ɢ�������еĶ�����ɢ����������״̬
//1) null
//2) ��null��isActiveΪtrue����ʾHashable���󱻴洢��ɢ����
//3) ��null��isActiveΪfalse����ʾHashable������ɢ�����Ǳ�ɾ����״̬
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

//ɢ��
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
		//�����ǰ�Ѵ洢Ԫ�صĸ��������������ܳ��ȵ�һ�룬���Ӱ��findPos��Ч�ʣ�������Ҫ��������
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

	//��ɢ������
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