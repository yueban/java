/* 18_�̳г��� */
public class Test_18{
	public static void main(String args []){
		Student student = new Student();
		student.name = "����";
		student.age = 18;
		student.grade = 3;
		student.address = "�ϲ�";
		
		student.eat();
		student.introduce();
		student.study(); 
	}
}

class Person{
	String name;
	int age;
	String address;
	
	void eat(){
		System.out.println("�Է�");
	}
	
	void introduce(){
		System.out.println("�ҵ�������" + name + "���ҵ�������" + age + "���ҵļ���" + address);
	}
}

class Student extends Person{
	int grade;
	
	void study(){
		System.out.println("����" + grade + "�꼶ѧ�����Ұ�ѧϰ");
	}
}

class Teacher extends Person{
	
}