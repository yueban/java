//�����
public class BinaryHeapTest{
	public static void main(String[] args){
		BinaryHeap bh = new BinaryHeap();
		bh.insert(42);
		bh.insert(13);
		bh.insert(21);
		bh.insert(56);
		bh.insert(176);
		bh.insert(2);
		bh.insert(9);
		bh.insert(64);
		System.out.println(bh.deleteMin());
		System.out.println(bh.findMin());
		bh.insert(bh.deleteMin());
		System.out.println(bh.findMin());
	}
}

class BinaryHeap{
	public BinaryHeap(){
		this(DEFAULT_CAPACITY);
	}

	public BinaryHeap(int capacity){
		currentSize = 0;
		array = new Comparable[capacity + 1];
	}

	public void insert(Comparable x){
		if(isFull()){
			System.out.println("Heap Overflow!");
			return;
		}
		//���˹���
		//������Ѩλ��Ϊ�ѵ���β��
		int hole = ++currentSize;
		//�ҵ�xӦ����Ŀ�Ѩλ��
		for(;hole > 1 && x.compareTo(array[hole / 2]) < 0;hole /= 2){
			array[hole] = array[hole / 2];
		}
		//����x
		array[hole] = x;
	}

	public Comparable findMin(){
		return isEmpty() ? null : array[1];
	}

	public Comparable deleteMin(){
		if(isEmpty()){
			return null;
		}
		Comparable minItem = findMin();
		array[1] = array[currentSize--];
		percolateDown(1);
		return minItem;
	}

	public boolean isFull(){
		return currentSize == array.length - 1;
	}

	public boolean isEmpty(){
		return currentSize == 0;
	}

	public void makeEmpty(){
		currentSize = 0;
	}

	private static final int DEFAULT_CAPACITY = 100;
	private int currentSize;
	private Comparable[] array;

	//����
	private void percolateDown(int hole){
		int child;
		//����Ҫ���˵Ľڵ�Ԫ�ش洢��tmp����ʱ�ýڵ�Ϊ��Ѩ
		Comparable tmp = array[hole];
		//�ҵ��ѵ���β��Ԫ��Ӧ�ò����λ�ã�û����һ�Σ��ͽ�ֵ��С�Ķ��ӽڵ��ֵ���븸�ڵ㣬�����ö��ӽڵ���Ϊ��Ѩ
		for(;hole * 2 <= currentSize;hole = child){
			child = hole * 2;
			//�ж����������ĸ���С���Ӷ��������˵�·��
			if(child != currentSize && array[child + 1].compareTo(array[child]) < 0){
				child++;
			}
			//����βԪ���Ƿ��ʺϷ���ÿ�Ѩ
			if(array[child].compareTo(tmp) < 0){
				array[hole] = array[child];
			}else{
				break;
			}
		}
		array[hole] = tmp;
	}

	//�����ѵķ�������һ�Ŷ�������Ϊ�ѣ�һ�ž��ж������ʵĶ�������
	private void buildHeap(){
		for(int i = currentSize / 2;i > 0;i--){
			percolateDown(i);
		}
	}
}