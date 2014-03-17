/* 24_Ϊʲô�ó����� */
public class Test_24{
	public static void main(String args []){
		Printer p1 = new HPPrinter();
		p1.open();
		p1.print();
		p1.close();
		
		Printer p2 = new CanonPrinter();
		p1.open();
		p1.print();
		p1.close();
	}
}

abstract class Printer{
	void open(){
		System.out.println("open");
	}
	
	void close(){
		System.out.println("close");
	}
	
	/*void print(){
	
	}*/
	
	abstract void print();
}

//�ô�ӡ��Ϊ��ī��ӡ��
class HPPrinter extends Printer{
	void print(){
		System.out.println("ʹ����ī��ӡ�����д�ӡ");
	}
}

//�ô�ӡ��Ϊ��ʽ��ӡ��
class CanonPrinter extends Printer{
	void print(){
		System.out.println("ʹ����ʽ��ӡ�����д�ӡ");
	}
}