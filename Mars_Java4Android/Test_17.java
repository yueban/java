/* 17_static�ؼ��ֵ����� */
public class Test_17{
	public static void main(String args []){
		/* test_01
		Person p1 = new Person();
		p1.i = 10;
		Person p2 = new Person();
		p2.i = 20;
		
		//Person.i = 30;
		System.out.println("p1��i��ֵΪ" + p1.i);
		System.out.println("p2��i��ֵΪ" + p2.i);
		
		//Person.i = 40;
		p1.i = 50;
		System.out.println("p1��i��ֵΪ" + p1.i);
		System.out.println("p2��i��ֵΪ" + p2.i);
		*/
		
		/* test_02*/
		Person.name = "zhangsan";
		Person.talk();
	}
}

class Person{
	/* test_01
	static int i;
	*/
	
	/* test_02*/
	static{
		System.out.println("��̬�����");
	}
	
	static String name;
	
	static void talk(){
		System.out.println("my name is " + name);
	}
}