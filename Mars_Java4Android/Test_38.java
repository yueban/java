/* 38_Java���е��̣߳����� */
public class Test_38{
	public static void main(String args []){
		MyThread myThread = new MyThread();
		//��������Thread���󣬵���������Thread������һ���߳���
		Thread t1 = new Thread(myThread);
		Thread t2 = new Thread(myThread);
		t1.setName("�߳�a");
		t2.setName("�߳�b");
		
		t1.start();
		t2.start();
	}
}

class MyThread implements Runnable{
	int i = 100;
	public void run(){
		synchronized(this){
			while(true){
				//Thread.currentThread()��ȡ��ǰ���������ĸ��߳�������
				System.out.println(Thread.currentThread().getName() + i);
				i--;
				Thread.yield();
				if(i < 0){
					break;
				}
			}
		}
	}
}