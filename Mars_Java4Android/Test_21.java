/* 21_对象的转型 */
public class Test_21{
	public static void main(String args []){
		/* test_01 向上转型
		//Student s = new Student();
		//Person p = s;
		Person p = new Student();
		
		p.name = "张伦";
		p.age = 20;
		//p.address = "190225";
		p.introduce();
		*/
		
		/* test_02 向下转型*/
		/*
		//错误的向下转型
		Person p = new Person();
		Student s = (Student)p;
		*/
		
		Person p = new Student();
		Student s = (Student)p;
		s.name = "濮志远";
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
		System.out.println("我的姓名是" + name + "，我的年龄是" + age);
	}
}

class Student extends Person{
	String address;
	
	void study(){
		System.out.println("我正在学习");
	}
	
	void introduce(){
		super.introduce();
		System.out.println("我的家在" + address);
	}
}