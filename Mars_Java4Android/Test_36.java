/* 36_Java���е��̣߳�һ�� */
public class Test_36{
	public static void main(String args []){
		//�����߳���Ķ���
		FirstThread ft= new FirstThread();
		//�����߳�
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