//二叉查找树
public class BinarySearchTreeTest{
	public static void main(String[] args){
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(3);
		bst.insert(2);
		bst.insert(1);
		bst.insert(5);
		bst.insert(4);
		bst.insert(8);
		bst.insert(6);
		bst.insert(7);
		bst.printTree();
		System.out.println();
		//移除叶子
		bst.remove(1);
		bst.printTree();
		System.out.println();
		//移除单节点
		bst.remove(8);
		bst.printTree();
		System.out.println();
		//移除双节点
		bst.remove(5);
		bst.printTree();
	}
}

class BinaryNode{
	BinaryNode(Comparable theElement){
		this(theElement,null,null);
	}

	BinaryNode(Comparable theElement,BinaryNode lt,BinaryNode rt){
		element = theElement;
		left = lt;
		right = rt;
	}

	Comparable element;
	BinaryNode left;
	BinaryNode right;
}

class BinarySearchTree{
	public BinarySearchTree(){
		root = null;
	}

	public boolean isEmpty(){
		return root == null;
	}

	public void makeEmpty(){
		root = null;
	}

	public Comparable find(Comparable x){
		return elementAt(find(x,root));
	}

	public Comparable findMin(){
		return elementAt(findMin(root));
	}

	public Comparable findMax(){
		return elementAt(findMax(root));
	}

	public void insert(Comparable x){
		root = insert(x,root);
	}

	public void remove(Comparable x){
		root = remove(x,root);
	}

	public void printTree(){
		if(isEmpty()){
			System.out.println("Empty Tree!");
		}else{
			printTree(root);
		}
	}

	private BinaryNode root;

	private Comparable elementAt(BinaryNode t){
		return t == null?null:t.element;
	}

	private BinaryNode find(Comparable x,BinaryNode t){
		if(t == null){
			return null;
		}
		if(x.compareTo(t.element) < 0){
			return find(x,t.left);
		}else if(x.compareTo(t.element) > 0){
			return find(x,t.right);
		}else{
			return t;
		}
	}

	private BinaryNode findMin(BinaryNode t){
		if(t == null){
			return null;
		}else if(t.left == null){
			return t;
		}
		return findMin(t.left);
	}

	private BinaryNode findMax(BinaryNode t){
		if(t != null){
			while(t.right != null){
				t = t.right;
			}
		}
		return t;
	}

	private BinaryNode insert(Comparable x,BinaryNode t){
		if(t == null){
			t = new BinaryNode(x,null,null);
		}else if(x.compareTo(t.element) < 0){
			t.left = insert(x,t.left);
		}else if(x.compareTo(t.element) > 0){
			t.right = insert(x,t.right);
		}
		return t;
	}

	private BinaryNode remove(Comparable x,BinaryNode t){
		if(t == null){
			return null;
		}
		if(x.compareTo(t.element) < 0){
			t.left = remove(x,t.left);
		}else if(x.compareTo(t.element) > 0){
			t.right = remove(x,t.right);
		}else if(t.left != null && t.right != null){
			t.element = findMin(t.right).element;
			t.right = remove(t.element,t.right);
		}else{
			t = (t.left != null)?t.left:t.right;
		}
		return t;
	}

	// private BinaryNode removeMin(BinaryNode t){
	// 	return null;
	// }

	private void printTree(BinaryNode t){
		if(t != null){
			printTree(t.left);
			System.out.print(t.element + " ");
			printTree(t.right);
		}
	}
}