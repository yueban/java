/* 16_this��ʹ�÷��� */
public class Test_16{
	public static void main(String args []){
		/* test_01
		Person p1 = new Person();
		p1.name = "zhangsan";
		
		Person p2 = new Person();
		p2.name = "lisi";
		
		p1.talk("zhangsan1");
		p2.talk("lisi1");
		*/
		
		/* test_02*/
		Person p1 = new Person("zhangsan",20,"beijing");
		
	}
}

class Person{
	String name;
	int age;
	String address;
	
	Person(){
		System.out.println("�޲����Ĺ��캯��");
	}
	
	Person(String name,int age){
		this();
		this.name = name;
		this.age = age;
		System.out.println("���������Ĺ��캯��");
	}
	
	Person(String name,int age,String address){
		//����this���ñ�����������캯������thisӦ���ڵ�һ��
		this(name,age);
		this.address = address;
		System.out.println("���������Ĺ��캯��");
	}
	
	//this������øó�Ա�����Ķ���
	void talk(String name){
		System.out.println("my name is " + this.name);
	}
}