/* 21_�����ת�� */
public class Test_21{
	public static void main(String args []){
		/* test_01 ����ת��
		//Student s = new Student();
		//Person p = s;
		Person p = new Student();
		
		p.name = "����";
		p.age = 20;
		//p.address = "190225";
		p.introduce();
		*/
		
		/* test_02 ����ת��*/
		/*
		//���������ת��
		Person p = new Person();
		Student s = (Student)p;
		*/
		
		Person p = new Student();
		Student s = (Student)p;
		s.name = "�־Զ";
		s.age = 20;
		s.address = "190224";
		s.introduce();
		s.study();
	}
}

class Person{
	String name;
	int age;
	
	void introduce(){
		System.out.println("�ҵ�������" + name + "���ҵ�������" + age);
	}
}

class Student extends Person{
	String address;
	
	void study(){
		System.out.println("������ѧϰ");
	}
	
	void introduce(){
		super.introduce();
		System.out.println("�ҵļ���" + address);
	}
}