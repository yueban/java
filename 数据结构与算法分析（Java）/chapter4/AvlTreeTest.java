public class AvlTreeTest{
	public static void main(String[] args){
		AvlTree at = new AvlTree();
		for(int i = 0;i < 70;i++){
			at.insert((int)(Math.random() * 100));
		}
		at.printTree();
		System.out.println(at.findMin());
		System.out.println(at.findMax());
		System.out.println(at.height());
	}
}

class AvlNode{
	AvlNode(Comparable theElement){
		this(theElement,null,null);
	}

	AvlNode(Comparable theElement,AvlNode lt,AvlNode rt){
		element = theElement;
		left = lt;
		right = rt;
	}

	Comparable element;
	AvlNode left;
	AvlNode right;
	int height;
}

class AvlTree{
	public AvlTree(){
		root = null;
	}

	public boolean isEmpty(){
		return root == null;
	}

	public void makeEmpty(){
		root = null;
	}

	public int height(){
		return height(root);
	}

	public void insert(Comparable x){
		root = insert(x,root);
	}

	public void remove(Comparable x){
		System.out.println("Sorry,remove unimplemented!");
	}

	public Comparable findMin(){
		if(isEmpty()){
			return null;
		}
		return findMin(root).element;
	}

	public Comparable findMax(){
		if(isEmpty()){
			return null;
		}
		return findMax(root).element;
	}

	public boolean contains(Comparable x){
		return contains(x,root);
	}

	public void printTree(){
		if(isEmpty()){
			System.out.println("Empty tree");
		}else{
			printTree(root);
		}
	}

	private int height(AvlNode t){
		return t == null?-1:Math.max(height(t.left),height(t.right)) + 1;
	}

	private AvlNode insert(Comparable x,AvlNode t){
		if(t == null){
			t = new AvlNode(x,null,null);
		}else if(x.compareTo(t.element) < 0){
			t.left = insert(x,t.left);
			if(height(t.left) - height(t.right) == 2){
				if(x.compareTo(t.left.element) < 0){
					t = rotateWithLeftChild(t);
				}else{
					t = doubleWithLeftChild(t);
				}
			}
		}else if(x.compareTo(t.element) > 0){
			t.right = insert(x,t.right);
			if(height(t.right) - height(t.left) == 2){
				if(x.compareTo(t.right.element) > 0){
					t = rotateWithRightChild(t);
				}else{
					t = doubleWithRightChild(t);
				}
			}
		}
		t.height = Math.max(height(t.left),height(t.right)) + 1;
		return t;
	}

	private AvlNode findMin(AvlNode t){
		if(t == null){
			return null;
		}
		while(t.left != null){
			t = t.left;
		}
		return t;
	}

	private AvlNode findMax(AvlNode t){
		if(t == null){
			return null;
		}
		while(t.right != null){
			t = t.right;
		}
		return t;
	}

	private boolean contains(Comparable x,AvlNode t){
		if(t == null){
			return false;
		}
		if(x.compareTo(t.element) < 0){
			return contains(x,t.left);
		}else if(x.compareTo(t.element) > 0){
			return contains(x,t.right);
		}else{
			return true;
		}
	}

	private void printTree(AvlNode t){
		if(t != null){
			printTree(t.left);
			System.out.print(t.element + " ");
			printTree(t.right);
		}
	}

	private AvlNode rotateWithLeftChild(AvlNode k2){
		AvlNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left),height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left),height(k1.right)) + 1;
		return k1;
	}

	private AvlNode rotateWithRightChild(AvlNode k1){
		AvlNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = Math.max(height(k1.left),height(k1.right)) + 1;
		k2.height = Math.max(height(k2.left),height(k2.right)) + 1;
		return k2;
	}

	private AvlNode doubleWithLeftChild(AvlNode t){
		t.left = rotateWithRightChild(t.left);
		return rotateWithLeftChild(t);
	}

	private AvlNode doubleWithRightChild(AvlNode t){
		t.right = rotateWithLeftChild(t.right);
		return rotateWithRightChild(t);
	}

	private AvlNode root;
}