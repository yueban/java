/* 36_Java当中的线程（一） */
public class Test_36{
	public static void main(String args []){
		//生成线程类的对象
		FirstThread ft= new FirstThread();
		//启动线程
		ft.start();
		
		for(int i = 0;i < 100;i++){
			System.out.println("main-->" + i);
		}
	}
}

class FirstThread extends Thread{
	public void run(){
		for(int i = 0;i < 100;i++){
			System.out.println("FirstThread-->" + i);
		}
	}
}