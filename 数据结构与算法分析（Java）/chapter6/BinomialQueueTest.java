//�������
public class BinomialQueueTest{
	public static void main(String[] args){
		int numItems = 10000;
		BinomialQueue h1 = new BinomialQueue();
		BinomialQueue h2 = new BinomialQueue();
		int base = 37;
		for(int i = base;i != 0;i = (i + base) % numItems){
			if(i % 2 == 0){
				h2.insert(i);
			}else{
				h1.insert(i);
			}
		}
		h1.merge(h2);
		while((int)h1.findMin() < 100){
			System.out.println(h1.deleteMin() + " ");
		}
	}
}

//������нڵ㣬���������ڵ�
class BinomialNode{
	public BinomialNode(Comparable theElement){
		this(theElement,null,null);
	}

	public BinomialNode(Comparable theElement,BinomialNode lt,BinomialNode nt){
		element = theElement;
		lt = leftChild;
		nextSibling = nt;
	}

	Comparable element;
	//������
	BinomialNode leftChild;
	//�¸��ֵ�
	BinomialNode nextSibling;
}

//�������
class BinomialQueue{
	public BinomialQueue(){
		theTrees = new BinomialNode[MAX_TREES];
		makeEmpty();
	}

	//�ϲ������������
	public void merge(BinomialQueue rhs){
		if(this == rhs){
			return;
		}
		if(currentSize + rhs.currentSize > capacity()){
			System.out.println("Overflow!");
			return;
		}
		//�µĶ�����д�С������������������
		currentSize += rhs.currentSize;
		//carry�Ǻϲ�������й����в����Ķ�����
		//�磺����������ж��и߶�Ϊ2�Ķ����������ϳ�һ�ø߶�Ϊ3�Ķ�����carry������carry������������������и߶�Ϊ3�Ķ������ϲ�����������п��ܲ���һ�ø߶�Ϊ4�Ķ�����carry���Դ�����
		BinomialNode carry = null;
		for(int i = 0,j = 1;j <= currentSize;i++,j *= 2){
			BinomialNode t1 = theTrees[i];
			BinomialNode t2 = rhs.theTrees[i];
			//����������ͨ�������ķ�ʽ���ж��ںϳɸ߶�Ϊj�Ķ�����ʱ��������Ӷ������������if/else���
			//�����һ����������и߶�Ϊj�Ķ�����t1�ǿ������+1
			int whichCase = t1 == null ? 0 : 1;
			//�����һ����������и߶�Ϊj�Ķ�����t2�ǿ������+2
			whichCase += t2 == null ? 0 : 2;
			//������ϴ�ѭ���У����߶�Ϊj-1�Ķ��������кϳɣ�������һ�ø߶�Ϊj�Ķ�����carry�������+4
			whichCase += carry == null ? 0 : 4;
			switch(whichCase){
				//���ǿ��Է��֣�ͨ�����������Խ�ÿ�������ɸѡ�����������õ�1��2��4�������ֺ�����
				case 0: //0����������Ϊ��
				case 1: //1��t1��Ϊ�գ�t2��carryΪ��
					break;
				case 2: //2��t2��Ϊ�գ�t1��carryΪ��
					theTrees[i] = t2;
					rhs.theTrees[i] = null;
					break;
				case 4: //4��carry��Ϊ�գ�t1��t2Ϊ��
					theTrees[i] = carry;
					carry = null;
					break;
				case 3: //3��t1��t2��Ϊ�գ�carryΪ��
					carry = combineTrees(t1,t2);
					theTrees[i] = rhs.theTrees[i] = null;
					break;
				case 5: //5��t1��carry��Ϊ�գ�t2Ϊ��
					carry = combineTrees(t1,carry);
					theTrees[i] = null;
					break;
				case 6: //6��t2��carry��Ϊ�գ�t1Ϊ��
					carry = combineTrees(t2,carry);
					rhs.theTrees[i] = null;
					break;
				case 7: //7��t1��t2��carry����Ϊ��
					theTrees[i] = carry;
					carry = combineTrees(t1,t2);
					rhs.theTrees[i] = null;
					break;
			}
		}
		//���������rhs���
		for(int k = 0;k < rhs.theTrees.length;k++){
			rhs.theTrees[k] = null;
		}
		rhs.currentSize = 0;
	}

	//������ǽ�һ��ֻ��һ���߶�Ϊ0�Ķ������Ķ�����кϲ�����ǰ���������
	public void insert(Comparable x){
		BinomialQueue oneItem = new BinomialQueue();
		oneItem.currentSize = 1;
		oneItem.theTrees[0] = new BinomialNode(x);
		merge(oneItem);
	}

	public Comparable findMin(){
		return isEmpty() ? null : theTrees[findMinIndex()].element;
	}

	public Comparable deleteMin(){
		if(isEmpty()){
			return null;
		}
		int minIndex = findMinIndex();
		Comparable minItem = theTrees[minIndex].element;
		BinomialNode deletedTree = theTrees[minIndex].leftChild;
		//����ʹ�õ���������������õ��Ľ����2��minIndex�η�
		//һ���߶�Ϊm�Ķ�������2��m�η����ڵ㣬һ���߶�Ϊn�Ķ��������ຬ�и߶ȴ�0��n-1��n�ö���������ຬ��2��n�η���1���ڵ�
		BinomialQueue deletedQueue = new BinomialQueue();
		//deletedQueue�Ǳ�ɾ������С�ĸ������ж�����ɵĶ������У����������п϶�������
		//����deletedQueue.currentSize = (1 << minIndex) - 1;
		deletedQueue.currentSize = (1 << minIndex) - 1;
		for(int j = minIndex - 1;j >= 0;j--){
			deletedQueue.theTrees[j] = deletedTree;
			deletedTree = deletedTree.nextSibling;
			deletedQueue.theTrees[j].nextSibling = null;
		}
		theTrees[minIndex] = null;
		//ɾ���Ľڵ�Ϊ1����С�ĸ��ڵ��������ڵ�Ķ�����ɵĶ�����еĽڵ�
		currentSize -= deletedQueue.currentSize + 1;
		//��Ϊ����ֻ��Ҫɾ�����Ǹ���С�ĸ��ڵ㣬���Ի�Ҫ��һ��ɾ������deleteedQueue��ԭ���Ķ�����кϲ�
		merge(deletedQueue);
		return minItem;
	}

	public boolean isEmpty(){
		return currentSize == 0;
	}

	public boolean isFull(){
		return currentSize == capacity();
	}

	public void makeEmpty(){
		currentSize = 0;
		for(int i = 0;i < theTrees.length;i++){
			theTrees[i] = null;
		}
	}

	private static final int MAX_TREES = 14;
	//����currentSize��ʾ���������������а����Ľڵ����������ǰ����Ķ�����������
	private int currentSize;
	private BinomialNode[] theTrees;

	//�ϲ����ö��������ô�ĸ���ΪС�ĸ�������
	private static BinomialNode combineTrees(BinomialNode t1,BinomialNode t2){
		if(t1.element.compareTo(t2.element) > 0){
			return combineTrees(t2,t1);
		}
		t2.nextSibling = t1.leftChild;
		t1.leftChild = t2;
		return t1;
	}

	//
	private int capacity(){
		//����ʹ�õ���������������õ��Ľ����2��theTrees.length�η�
		//һ���߶�Ϊm�Ķ�������2��m�η����ڵ㣬һ���߶�Ϊn�Ķ��������ຬ�и߶ȴ�0��n-1��n�ö�����
		//����һ���߶�Ϊk�Ķ��������ຬ��2��n�η���1���ڵ�
		return (1 << theTrees.length) - 1;
	}

	//����������������еĶ������ĸ����ҵ���С���Ǹ�����������ΪminIndex
	private int findMinIndex(){
		int minIndex;
		int i = 0;
		while(theTrees[i] == null){
			i++;
		}
		for(minIndex = i;i < theTrees.length;i++){
			if(theTrees[i] != null && theTrees[i].element.compareTo(theTrees[minIndex].element) < 0){
				minIndex = i;
			}
		}
		return minIndex;
	}
}