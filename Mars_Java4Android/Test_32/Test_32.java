/* 32_Java当中的IO（一） */

//第一步骤：导入类
import java.io.*;

public class Test_32{
	public static void main(String args []){
		//声明输入流的引用
		FileInputStream fis = null;
		//声明输出流的引用
		FileOutputStream fos = null;
		try{
			//生成代表输入流的对象
			fis = new FileInputStream("d:/百度云/代码/java/Test_32/from.txt");
			//生成代表输出流对象
			fos = new FileOutputStream("d:/百度云/代码/java/Test_32/to.txt");
			//生成一个字节数组
			byte [] buffer = new byte[100];
			//调用输入流对象的read方法
			int bitcount = fis.read(buffer,0,buffer.length);
			//调用输出流对象的write方法
			fos.write(buffer,0,bitcount);
			/*
			String s = new String(buffer);
			s = s.trim();
			System.out.println(s);
			//for(int i = 0;i < buffer.length;i++){
			//	System.out.println(buffer[i]);
			//}
			*/
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}