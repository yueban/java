/* 19_����ʵ�������� */
public class Test_19{
	public static void main(String args []){
		Student student = new Student("xiaojiji",20,3);
		System.out.println(student.name);
		System.out.println(student.age);
		System.out.println(student.grade);
	}
}

class Person{
	String name;
	int age;
	
	Person(){
		System.out.println("Person���޲������캯��");
	}
	
	Person(String name,int age){
		this.name = name;
		this.age = age;
		System.out.println("Person���в������캯��");
	}
	
	void eat(){
		System.out.println("�Է�");
	}
}

class Student extends Person{
	int grade;

	Student(){
		System.out.println("Student���޲������캯��");
	}
	
	Student(String name,int age,int grade){
		//this.name = name;
		//this.age = age;
		super(name,age);
		this.grade = grade;
	}
}