/* 20_�����ĸ�д */
public class Test_20{
	public static void main(String args []){
		Student student = new Student();
		student.name = "��Ȼ��";
		student.age = 20;
		student.address = "�ϲ�";
		student.introduce();
		
		Person person = new Person();
		person.name = "�־Զ";
		person.age = 20;
		person.introduce();
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
	
	void introduce(){
		//System.out.println("�ҵ�������" + name + "���ҵ�������" + age);
		//super.introduce();
		System.out.println("�ҵļ���" + address);
		super.introduce();
	}
}