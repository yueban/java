//���е�����ʵ��
public class QueueArTest{
	public static void main(String[] args){
		QueueAr qa = new QueueAr(5);
		qa.deQueue();
		qa.enQueue("g");
		qa.enQueue(1);
		qa.enQueue(false);
		System.out.println(qa.getFront());
		System.out.println(qa.deQueue());
		qa.enQueue("dd");
		qa.enQueue("h");
		qa.enQueue("1");
		qa.enQueue("f");
	}
}

//������
class QueueAr{
	public QueueAr(){
		this(DEFAULT_CAPACITY);
	}

	public QueueAr(int capacity){
		theArray = new Object[capacity];
		makeEmpty();
	}

	public boolean isEmpty(){
		return currentSize == 0;
	}

	public boolean isFull(){
		return currentSize == theArray.length;
	}

	public void makeEmpty(){
		currentSize = 0;
		front = 0;
		back = -1;
	}

	public Object getFront(){
		if(isEmpty()){
			return null;
		}
		return theArray[front];
	}

	public void enQueue(Object x){
		if(isFull()){
			System.out.println("Queue OverFlow!");
			return;
		}
		back = increment(back);
		theArray[back] = x;
		currentSize++;
	}

	public int increment(int x){
		if(++x == theArray.length){
			x = 0;
		}
		return x;
	}

	public Object deQueue(){
		if(isEmpty()){
			System.out.println("Queue UnderFlow!");
			return null;
		}
		Object frontItem = theArray[front];
		theArray[front] = null;
		front = increment(front);
		currentSize--;
		return frontItem;
	}

	//theArray�����洢����
	private Object[] theArray;
	//currentSize������ʾ��ǰ�洢�����ݸ���
	private int currentSize;
	//front��ʾ��ǰ����ͷ��������
	private int front;
	//back��ʾ��ǰ����β��������
	private int back;

	private static final int DEFAULT_CAPACITY = 10;
}