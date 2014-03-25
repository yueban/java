//左式堆
public class LeftistHeapTest{
	public static void main(String[] args){
		LeftistHeap h1 = new LeftistHeap();
		LeftistHeap h2 = new LeftistHeap();
		for(int i = 1;i < 100;i++){
			if(i % 2 == 0){
				h1.insert(i);
			}else{
				h2.insert(i);
			}
		}
		h1.merge(h2);
		while(h1.findMin() != null){
			System.out.println("aha! " + h1.deleteMin());
		}
	}
}

//左式堆节点
class LeftHeapNode{
	public LeftHeapNode(Comparable theElement){
		this(theElement,null,null);
	}

	public LeftHeapNode(Comparable theElement,LeftHeapNode lt,LeftHeapNode rt){
		element = theElement;
		left = lt;
		right = rt;
		npl = 0;
	}

	Comparable element;
	LeftHeapNode left;
	LeftHeapNode right;
	//npl表示该节点的零路径长
	//X的零路径长：从X节点到一个不具有两个儿子的后裔节点的最短路径长
	int npl;
}

//左式堆
class LeftistHeap{
	public LeftistHeap(){
		makeEmpty();
	}

	//合并两个左式堆
	public void merge(LeftistHeap rhs){
		if(this == rhs){
			return;
		}
		root = merge(root,rhs.root);
		rhs.root = null;
	}

	//插入就是将只具有一个节点的左式堆合并到当前左式堆
	public void insert(Comparable x){
		root = merge(new LeftHeapNode(x),root);
	}

	public Comparable findMin(){
		return isEmpty() ? null : root.element;
	}

	//删除最小节点，即删除根节点，再将根节点的左子堆和右子堆合并
	public Comparable deleteMin(){
		if(isEmpty()){
			return null;
		}
		Comparable minItem = root.element;
		root = merge(root.left,root.right);
		return minItem;
	}

	public boolean isEmpty(){
		return root == null;
	}

	public boolean isFull(){
		return false;
	}

	public void makeEmpty(){
		root = null;
	}

	private LeftHeapNode root;

	//合并两个左式堆
	private static LeftHeapNode merge(LeftHeapNode h1,LeftHeapNode h2){
		if(h1 == null){
			return h2;
		}
		if(h2 == null){
			return h1;
		}
		//左式堆的合并规则是递归的将根值更大的堆与根值更小的堆的右子堆合并
		//这里作判断是为了与方法merge1对应（使merge1方法更好理解），实际上merge和merge1可以合成一个方法
		if(h1.element.compareTo(h2.element) < 0){
			return merge1(h1,h2);
		}else{
			return merge1(h2,h1);
		}
	}

	private static LeftHeapNode merge1(LeftHeapNode h1,LeftHeapNode h2){
		if(h1.left == null){
			h1.left = h2;
		}else{
			h1.right = merge(h1.right,h2);
			//为了保证合并后的堆还满足左式堆的性质，这里做一次零路径长的判断与处理
			if(h1.left.npl < h1.right.npl){
				swapChildren(h1);
			}
			//更新零路径长
			h1.npl = h1.right.npl + 1;
		}
		return h1;
	}

	//交换两个孩子，即交换t的左子堆和右子堆
	private static void swapChildren(LeftHeapNode t){
		LeftHeapNode tmp = t.left;
		t.left = t.right;
		t.right = tmp;
	}
}