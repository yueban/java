//��ʽ��
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

//��ʽ�ѽڵ�
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
	//npl��ʾ�ýڵ����·����
	//X����·��������X�ڵ㵽һ���������������ӵĺ���ڵ�����·����
	int npl;
}

//��ʽ��
class LeftistHeap{
	public LeftistHeap(){
		makeEmpty();
	}

	//�ϲ�������ʽ��
	public void merge(LeftistHeap rhs){
		if(this == rhs){
			return;
		}
		root = merge(root,rhs.root);
		rhs.root = null;
	}

	//������ǽ�ֻ����һ���ڵ����ʽ�Ѻϲ�����ǰ��ʽ��
	public void insert(Comparable x){
		root = merge(new LeftHeapNode(x),root);
	}

	public Comparable findMin(){
		return isEmpty() ? null : root.element;
	}

	//ɾ����С�ڵ㣬��ɾ�����ڵ㣬�ٽ����ڵ�����ӶѺ����ӶѺϲ�
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

	//�ϲ�������ʽ��
	private static LeftHeapNode merge(LeftHeapNode h1,LeftHeapNode h2){
		if(h1 == null){
			return h2;
		}
		if(h2 == null){
			return h1;
		}
		//��ʽ�ѵĺϲ������ǵݹ�Ľ���ֵ����Ķ����ֵ��С�Ķѵ����ӶѺϲ�
		//�������ж���Ϊ���뷽��merge1��Ӧ��ʹmerge1����������⣩��ʵ����merge��merge1���Ժϳ�һ������
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
			//Ϊ�˱�֤�ϲ���Ķѻ�������ʽ�ѵ����ʣ�������һ����·�������ж��봦��
			if(h1.left.npl < h1.right.npl){
				swapChildren(h1);
			}
			//������·����
			h1.npl = h1.right.npl + 1;
		}
		return h1;
	}

	//�����������ӣ�������t�����ӶѺ����Ӷ�
	private static void swapChildren(LeftHeapNode t){
		LeftHeapNode tmp = t.left;
		t.left = t.right;
		t.right = tmp;
	}
}