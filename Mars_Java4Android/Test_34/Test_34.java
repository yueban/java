/* 34-Java���е�IO������ */
import java.io.*;

public class Test_34{
	public static void main(String args []){
	/* test_01_�ַ���
		//��������������
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try{
			//��������������
			fileReader = new FileReader("d:/�ٶ���/����/java/Test_34/from.txt");
			bufferedReader = new BufferedReader(fileReader);
			//����һ��String���ͱ���
			String line = null;
			while(true){
				//����BufferedReader��readLine��������ȡһ������
				line = bufferedReader.readLine();
				//�ж������Ƿ��Ѿ���ȡ���
				if(line == null){
					break;
				}
				System.out.println(line);
			}
			System.out.println(line);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				bufferedReader.close();
				fileReader.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		*/
		
		/* test_02_װ����ģʽ
		Plumber plumber = new Plumber();
		AWorker aWorker1 = new AWorker(plumber);
		aWorker.doSomeWork();
		
		Capenter capenter = new Capenter();
		AWorker aWorker2 = new AWorker(capenter);
		aWorker.doSomeWork();
		*/
	}
}

/* test_02_װ����ģʽ
interface Worker{
	public void doSomeWork();
}

class Plumber implements Worker{
	public void doSomeWork(){
		System.out.println("��ˮ��");
	}
}

class Carpenter implements Worker{
	public void doSomeWork(){
		System.out.println("���Ŵ�");
	}
}

class AWorker implements Worker{
	private Worker worker;
	
	public AWorker(Worker worker){
		this.worker = worker;
	}
	
	public void doSomeWork(){
		System.out.println("���");
		worker.doSomeWork();
	}
}
*/