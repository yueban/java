/* 37_Java���е��̣߳����� */
public class Test_37{
	public static void main(String args []){
		//��һ��Runnable�ӿ�ʵ����Ķ���
		RunnableImpl ri = new RunnableImpl();
		//����һ��Thread���󣬲���Runnable�ӿ�ʵ����Ķ�����Ϊ����
		//���ݸ���Thread����
		Thread t = new Thread(ri);
		//����Thread��������ȼ�
		t.setPriority(Thread.MIN_PRIORITY);
		//��ӡThread��������ȼ�
		System.out.println(t.getPriority());
		//֪ͨThread����ִ��start����
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