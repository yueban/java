/* 33_java当中的IO（二） */

/* test_01_字节流*/
import java.io.*;

public class Test_33{
	public static void main(String args []){
		//声明输入流的引用
		FileInputStream fis = null;
		//声明输出流的引用
		FileOutputStream fos = null;
		try{
			//生成代表输入流的对象
			fis = new FileInputStream("d:/百度云/代码/java/Test_33/from.txt");
			//生成代表输出流的对象
			fos = new FileOutputStream("d:/百度云/代码/java/Test_33/to.txt");
			//生成一个字节数组
			byte [] buffer = new byte[1024];
			while(true){
				//调用输入流对象的read方法，读取数据
				//temp用来存放read方法的返回值，该返回值是buffer读取的字节数，用于之后write方法的参数，若read读取不到东西，则返回-1
				int temp = fis.read(buffer,0,buffer.length);
				//判断是否已经读取完数据
				if(temp == -1){
					break;
				}
				//调用输出流对象的write方法，存储数据
				fos.write(buffer,0,temp);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

/* etst_02_字符流
import java.io.*;

public class Test_33{
	public static void main(String args []){
		//声明输入流的引用
		FileReader fr = null;
		//声明输出流的引用
		FileWriter fw = null;
		try{
			//生成代表输入流的引用
			fr = new FileReader("d:/百度云/代码/java/Test_33/from.txt");
			//生成代表输出流的引用
			fw = new FileWriter("d:/百度云/代码/java/Test_33/to.txt");
			//生成一个字符数组
			char [] buffer = new char[100];
			while(true){
				//调用输入流对象的read方法，读取数据
				//temp用于存储read方法的返回值，该返回值是读取到的数据的长度，这个值用来作为之后调用输出流对象的方法write的参数，若未取到数据，则返回值为-1，用来作为循环内判断循环结束的条件
				int temp = fr.read(buffer,0,buffer.length);
				//判断是否已经读取完数据
				if(temp == -1){
					break;
				}
				//调用输出流对象的write方法
				fw.write(buffer,0,temp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				fr.close();
				fw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
*/