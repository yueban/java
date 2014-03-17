/* 20_函数的复写 */
public class Test_20{
	public static void main(String args []){
		Student student = new Student();
		student.name = "余然孜";
		student.age = 20;
		student.address = "南昌";
		student.introduce();
		
		Person person = new Person();
		person.name = "濮志远";
		person.age = 20;
		person.introduce();
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
	
	void introduce(){
		//System.out.println("我的姓名是" + name + "，我的年龄是" + age);
		//super.introduce();
		System.out.println("我的家在" + address);
		super.introduce();
	}
}