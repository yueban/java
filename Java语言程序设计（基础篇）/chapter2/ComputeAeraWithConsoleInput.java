import java.util.Scanner;

public class ComputeAeraWithConsoleInput{
	public static void main(String[] args){
		//����һ��Scanner���͵Ķ���
		Scanner input = new Scanner(System.in);
		
		//��ȡ�û�����
		System.out.println("������Բ�İ뾶��");
		double radius = input.nextDouble();
		
		//����Բ�����
		double area = radius * radius * 3.14159;
		
		//������
		System.out.println("�뾶Ϊ " + radius + " ��Բ�����Ϊ " + area);
	}
}