/* 23_������ͳ����� */
public class Test_23{
	public static void main(String args []){
		/* test_01
		Person p = new Person();
		p.introduce();
		*/
		
		/* test_02*/
		Chinese c = new Chinese();
		c.name = "��Ȼ��";
		c.age = 20;
		c.introduce();
		c.eat();
	}
}

abstract class Person{
	String name;
	int age;
	
	Person(){
		System.out.println("Person���޲������캯��");
	}

	Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	void introduce(){
		System.out.println("�ҵ�������" + name + "���ҵ�������" + age);
	}
	
	abstract void eat();
}

class Chinese extends Person{
	String address;

	Chinese(){
		System.out.println("Chinese���޲������캯��");
	}

	Chinese(String name,int age,String address){
		super(name,age);
		this.address = address;
	}
	
	void eat(){
		System.out.println("�ÿ��ӳԷ�");
	}
}