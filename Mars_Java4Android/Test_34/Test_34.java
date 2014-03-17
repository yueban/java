/* 34-Java当中的IO（三） */
import java.io.*;

public class Test_34{
	public static void main(String args []){
	/* test_01_字符流
		//声明输入流引用
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try{
			//生成输入流对象
			fileReader = new FileReader("d:/百度云/代码/java/Test_34/from.txt");
			bufferedReader = new BufferedReader(fileReader);
			//声明一个String类型变量
			String line = null;
			while(true){
				//调用BufferedReader的readLine方法，读取一行数据
				line = bufferedReader.readLine();
				//判断数据是否已经读取完毕
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
		
		/* test_02_装饰者模式
		Plumber plumber = new Plumber();
		AWorker aWorker1 = new AWorker(plumber);
		aWorker.doSomeWork();
		
		Capenter capenter = new Capenter();
		AWorker aWorker2 = new AWorker(capenter);
		aWorker.doSomeWork();
		*/
	}
}

/* test_02_装饰者模式
interface Worker{
	public void doSomeWork();
}

class Plumber implements Worker{
	public void doSomeWork(){
		System.out.println("修水管");
	}
}

class Carpenter implements Worker{
	public void doSomeWork(){
		System.out.println("修门窗");
	}
}

class AWorker implements Worker{
	private Worker worker;
	
	public AWorker(Worker worker){
		this.worker = worker;
	}
	
	public void doSomeWork(){
		System.out.println("你好");
		worker.doSomeWork();
	}
}
*/