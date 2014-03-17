//������α�ʵ��
public class CursorListTest{
	public static void main(String[] args){
		CursorList l = new CursorList();
		l.insert("a",l.zeroth());
		l.insert("b",l.zeroth());
		l.insert("c",l.find("b"));
		for(int i = 0;i < 10;i++){
			System.out.print(l.cursorSpace[i].element + " ");
		}
		
		System.out.println();
		
		int p = l.find("b").current;
		while(l.cursorSpace[p].element != null){
			System.out.println(l.cursorSpace[p].element);
			p = l.cursorSpace[p].next;
			System.out.println("p--->" + p);
		}
		
		System.out.println(l.findPrevious("c").retrieve());
	}
}

//�ڵ���
//element��ʾ�洢��Ԫ��
//next��ʾ��һ���ڵ����ţ����¸��ڵ��������еĽǱ�
class CursorNode{
	CursorNode(Object theElement){
		this(theElement,0);
	}

	CursorNode(Object theElement,int n){
		element = theElement;
		next = n;
	}

	Object element;
	int next;
}

//�ڵ�����࣬����ɨ��ڵ㣬�ýڵ�����������
//isPastEnd()��ʾ�Ƿ��Ѿ�ɨ���������һ���ڵ㣨������α�ʵ�������һ��Ԫ�ػ�ָ��0��
//retrieve()���ڻ�ȡ��ǰɨ��ڵ��Ԫ��
//advance()����ɨ����һ���ڵ�
class CursorListItr{
	CursorListItr(int theNode){
		current = theNode;
	}

	public boolean isPastEnd(){
		return current == 0;
	}

	public Object retrieve(){
		return isPastEnd()?null:CursorList.cursorSpace[current].element;
	}

	public void advance(){
		if(!isPastEnd()){
			current = CursorList.cursorSpace[current].next;
		}
	}

	int current;
}

//������
//alloc()�������ڷ����ȥһ����ǰ���е����鵥Ԫ���ڵ㣩
//free()�������ڻ���һ������ʹ�õ����鵥Ԫ���ڵ㣩
class CursorList{
	private static int alloc(){
		int p = cursorSpace[0].next;
		cursorSpace[0].next = cursorSpace[p].next;
		if(p == 0){
			throw new OutOfMemoryError();
		}
		return p;
	}

	private static void free(int p){
		cursorSpace[p].element = null;
		cursorSpace[p].next = cursorSpace[0].next;
		cursorSpace[0].next = p;
	}

	public CursorList(){
		header = alloc();
		cursorSpace[header].next = 0;
	}

	public boolean isEmpty(){
		return cursorSpace[header].next == 0;
	}

	public void makeEmpty(){
		while(!isEmpty()){
			remove(first().retrieve());
		}
	}

	public CursorListItr zeroth(){
		return new CursorListItr(header);
	}

	public CursorListItr first(){
		return new CursorListItr(cursorSpace[header].next);
	}

	public CursorListItr find(Object x){
		int itr = cursorSpace[header].next;
		while(itr != 0 && !cursorSpace[itr].element.equals(x)){
			itr = cursorSpace[itr].next;
		}
		return new CursorListItr(itr);
	}

	public void insert(Object x,CursorListItr p){
		if(p != null && p.current != 0){
			int pos = p.current;
			int temp = alloc();

			cursorSpace[temp].element = x;
			cursorSpace[temp].next = cursorSpace[pos].next;
			cursorSpace[pos].next = temp;
		}
	}

	public void remove(Object x){
		CursorListItr p = findPrevious(x);
		int pos = p.current;
		if(cursorSpace[pos].next != 0){
			int temp = cursorSpace[pos].next;
			cursorSpace[pos].next = cursorSpace[temp].next;
			free(temp);
		}
	}

	public CursorListItr findPrevious(Object x){
		int itr = header;
		while(cursorSpace[itr].next != 0 && 
			!cursorSpace[cursorSpace[itr].next].element.equals(x)){
			itr = cursorSpace[itr].next;
		}
		return new CursorListItr(itr);
	}

	private int header;
	static CursorNode[] cursorSpace;
	private static final int SPACE_SIZE = 100;

	static{
		cursorSpace = new CursorNode[SPACE_SIZE];
		for(int i = 0;i < SPACE_SIZE;i++){
			cursorSpace[i] = new CursorNode(null,i + 1);
		}
		cursorSpace[SPACE_SIZE - 1].next = 0;
	}
}