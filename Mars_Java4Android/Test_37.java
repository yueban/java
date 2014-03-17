/* 37_Java当中的线程（二） */
public class Test_37{
	public static void main(String args []){
		//生一个Runnable接口实现类的对象
		RunnableImpl ri = new RunnableImpl();
		//生成一个Thread对象，并将Runnable接口实现类的对象作为参数
		//传递给该Thread对象
		Thread t = new Thread(ri);
		//设置Thread对象的优先级
		t.setPriority(Thread.MIN_PRIORITY);
		//打印Thread对象的优先级
		System.out.println(t.getPriority());
		//通知Thread对象，执行start方向
		//t.start();
		
	}
}

class RunnableImpl implements Runnable{
	public void run(){
		for(int i = 0;i < 100;i++){
			System.out.println("Runnable-->" + i);
			if(i == 50){
				try{
					Thread.sleep(2000);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}