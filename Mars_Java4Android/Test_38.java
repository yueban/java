/* 38_Java当中的线程（三） */
public class Test_38{
	public static void main(String args []){
		MyThread myThread = new MyThread();
		//生成两个Thread对象，但是这两个Thread对象共用一个线程体
		Thread t1 = new Thread(myThread);
		Thread t2 = new Thread(myThread);
		t1.setName("线程a");
		t2.setName("线程b");
		
		t1.start();
		t2.start();
	}
}

class MyThread implements Runnable{
	int i = 100;
	public void run(){
		synchronized(this){
			while(true){
				//Thread.currentThread()获取当前代码正在哪个线程中运行
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