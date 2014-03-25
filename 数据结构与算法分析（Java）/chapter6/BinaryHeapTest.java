//二叉堆
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
		//上滤过程
		//声明空穴位置为堆的最尾部
		int hole = ++currentSize;
		//找到x应插入的空穴位置
		for(;hole > 1 && x.compareTo(array[hole / 2]) < 0;hole /= 2){
			array[hole] = array[hole / 2];
		}
		//插入x
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

	//下滤
	private void percolateDown(int hole){
		int child;
		//把需要下滤的节点元素存储进tmp，此时该节点为空穴
		Comparable tmp = array[hole];
		//找到堆的最尾部元素应该插入的位置，没下滤一次，就将值更小的儿子节点的值放入父节点，并将该儿子节点设为空穴
		for(;hole * 2 <= currentSize;hole = child){
			child = hole * 2;
			//判断两个儿子哪个更小，从而决定下滤的路线
			if(child != currentSize && array[child + 1].compareTo(array[child]) < 0){
				child++;
			}
			//检查堆尾元素是否适合放入该空穴
			if(array[child].compareTo(tmp) < 0){
				array[hole] = array[child];
			}else{
				break;
			}
		}
		array[hole] = tmp;
	}

	//构建堆的方法，将一颗二叉树变为堆（一颗具有堆序性质的二叉树）
	private void buildHeap(){
		for(int i = currentSize / 2;i > 0;i--){
			percolateDown(i);
		}
	}
}