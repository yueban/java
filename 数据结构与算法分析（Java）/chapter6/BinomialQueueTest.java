//二项队列
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

//二项队列节点，即二项树节点
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
	//左子树
	BinomialNode leftChild;
	//下个兄弟
	BinomialNode nextSibling;
}

//二项队列
class BinomialQueue{
	public BinomialQueue(){
		theTrees = new BinomialNode[MAX_TREES];
		makeEmpty();
	}

	//合并两个二项队列
	public void merge(BinomialQueue rhs){
		if(this == rhs){
			return;
		}
		if(currentSize + rhs.currentSize > capacity()){
			System.out.println("Overflow!");
			return;
		}
		//新的二项队列大小等于两个二项队列相加
		currentSize += rhs.currentSize;
		//carry是合并二项队列过程中产生的二项树
		//如：两个二项队列都有高度为2的二项树，则会合成一棵高度为3的二项树carry，并将carry继续与两个二项队列中高度为3的二项树合并，这个过程中可能产生一棵高度为4的二项树carry，以此类推
		BinomialNode carry = null;
		for(int i = 0,j = 1;j <= currentSize;i++,j *= 2){
			BinomialNode t1 = theTrees[i];
			BinomialNode t2 = rhs.theTrees[i];
			//这里很巧妙的通过计数的方式来判断在合成高度为j的二项树时的情况，从而避免大量套用if/else语句
			//如果第一个二项队列中高度为j的二项树t1非空则计数+1
			int whichCase = t1 == null ? 0 : 1;
			//如果第一个二项队列中高度为j的二项树t2非空则计数+2
			whichCase += t2 == null ? 0 : 2;
			//如果在上次循环中（将高度为j-1的二项树进行合成）产生了一棵高度为j的二项树carry，则计数+4
			whichCase += carry == null ? 0 : 4;
			switch(whichCase){
				//我们可以发现，通过计数，可以将每种情况都筛选出来，计数用的1，2，4三个数字很巧妙
				case 0: //0：三棵树都为空
				case 1: //1：t1不为空，t2，carry为空
					break;
				case 2: //2：t2不为空，t1，carry为空
					theTrees[i] = t2;
					rhs.theTrees[i] = null;
					break;
				case 4: //4：carry不为空，t1，t2为空
					theTrees[i] = carry;
					carry = null;
					break;
				case 3: //3：t1，t2不为空，carry为空
					carry = combineTrees(t1,t2);
					theTrees[i] = rhs.theTrees[i] = null;
					break;
				case 5: //5：t1，carry不为空，t2为空
					carry = combineTrees(t1,carry);
					theTrees[i] = null;
					break;
				case 6: //6：t2，carry不为空，t1为空
					carry = combineTrees(t2,carry);
					rhs.theTrees[i] = null;
					break;
				case 7: //7：t1，t2，carry都不为空
					theTrees[i] = carry;
					carry = combineTrees(t1,t2);
					rhs.theTrees[i] = null;
					break;
			}
		}
		//将二项队列rhs清空
		for(int k = 0;k < rhs.theTrees.length;k++){
			rhs.theTrees[k] = null;
		}
		rhs.currentSize = 0;
	}

	//插入就是将一个只有一个高度为0的二项树的二项队列合并到当前二项队列上
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
		//这里使用的是左移运算符，得到的结果是2的minIndex次方
		//一个高度为m的二项树有2的m次方个节点，一个高度为n的二项队列最多含有高度从0到n-1共n棵二项树，最多含有2的n次方减1个节点
		BinomialQueue deletedQueue = new BinomialQueue();
		//deletedQueue是被删除的最小的根的所有儿子组成的二项序列，这个二项队列肯定是满的
		//所以deletedQueue.currentSize = (1 << minIndex) - 1;
		deletedQueue.currentSize = (1 << minIndex) - 1;
		for(int j = minIndex - 1;j >= 0;j--){
			deletedQueue.theTrees[j] = deletedTree;
			deletedTree = deletedTree.nextSibling;
			deletedQueue.theTrees[j].nextSibling = null;
		}
		theTrees[minIndex] = null;
		//删除的节点为1个最小的根节点和这个根节点的儿子组成的二项队列的节点
		currentSize -= deletedQueue.currentSize + 1;
		//因为我们只是要删除掉那个最小的根节点，所以还要把一起删除掉的deleteedQueue和原来的二项队列合并
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
	//这里currentSize表示的是整个二项序列包含的节点数，而不是包含的二项树的数量
	private int currentSize;
	private BinomialNode[] theTrees;

	//合并两棵二项树：让大的根成为小的根的子树
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
		//这里使用的是左移运算符，得到的结果是2的theTrees.length次方
		//一个高度为m的二项树有2的m次方个节点，一个高度为n的二项队列最多含有高度从0到n-1共n棵二项树
		//所以一个高度为k的二项队列最多含有2的n次方减1个节点
		return (1 << theTrees.length) - 1;
	}

	//遍历二项队列中所有的二项树的根，找到最小的那个的索引，即为minIndex
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