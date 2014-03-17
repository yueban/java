/* 19_子类实例化过程 */
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
		System.out.println("Person的无参数构造函数");
	}
	
	Person(String name,int age){
		this.name = name;
		this.age = age;
		System.out.println("Person的有参数构造函数");
	}
	
	void eat(){
		System.out.println("吃饭");
	}
}

class Student extends Person{
	int grade;

	Student(){
		System.out.println("Student的无参数构造函数");
	}
	
	Student(String name,int age,int grade){
		//this.name = name;
		//this.age = age;
		super(name,age);
		this.grade = grade;
	}
}