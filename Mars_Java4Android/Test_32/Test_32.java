/* 32_Java���е�IO��һ�� */

//��һ���裺������
import java.io.*;

public class Test_32{
	public static void main(String args []){
		//����������������
		FileInputStream fis = null;
		//���������������
		FileOutputStream fos = null;
		try{
			//���ɴ����������Ķ���
			fis = new FileInputStream("d:/�ٶ���/����/java/Test_32/from.txt");
			//���ɴ������������
			fos = new FileOutputStream("d:/�ٶ���/����/java/Test_32/to.txt");
			//����һ���ֽ�����
			byte [] buffer = new byte[100];
			//���������������read����
			int bitcount = fis.read(buffer,0,buffer.length);
			//��������������write����
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