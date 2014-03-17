/* 33_java���е�IO������ */

/* test_01_�ֽ���*/
import java.io.*;

public class Test_33{
	public static void main(String args []){
		//����������������
		FileInputStream fis = null;
		//���������������
		FileOutputStream fos = null;
		try{
			//���ɴ����������Ķ���
			fis = new FileInputStream("d:/�ٶ���/����/java/Test_33/from.txt");
			//���ɴ���������Ķ���
			fos = new FileOutputStream("d:/�ٶ���/����/java/Test_33/to.txt");
			//����һ���ֽ�����
			byte [] buffer = new byte[1024];
			while(true){
				//���������������read��������ȡ����
				//temp�������read�����ķ���ֵ���÷���ֵ��buffer��ȡ���ֽ���������֮��write�����Ĳ�������read��ȡ�����������򷵻�-1
				int temp = fis.read(buffer,0,buffer.length);
				//�ж��Ƿ��Ѿ���ȡ������
				if(temp == -1){
					break;
				}
				//��������������write�������洢����
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

/* etst_02_�ַ���
import java.io.*;

public class Test_33{
	public static void main(String args []){
		//����������������
		FileReader fr = null;
		//���������������
		FileWriter fw = null;
		try{
			//���ɴ���������������
			fr = new FileReader("d:/�ٶ���/����/java/Test_33/from.txt");
			//���ɴ��������������
			fw = new FileWriter("d:/�ٶ���/����/java/Test_33/to.txt");
			//����һ���ַ�����
			char [] buffer = new char[100];
			while(true){
				//���������������read��������ȡ����
				//temp���ڴ洢read�����ķ���ֵ���÷���ֵ�Ƕ�ȡ�������ݵĳ��ȣ����ֵ������Ϊ֮��������������ķ���write�Ĳ�������δȡ�����ݣ��򷵻�ֵΪ-1��������Ϊѭ�����ж�ѭ������������
				int temp = fr.read(buffer,0,buffer.length);
				//�ж��Ƿ��Ѿ���ȡ������
				if(temp == -1){
					break;
				}
				//��������������write����
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