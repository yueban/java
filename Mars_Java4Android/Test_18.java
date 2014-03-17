/* 18_继承初步 */
public class Test_18{
	public static void main(String args []){
		Student student = new Student();
		student.name = "张三";
		student.age = 18;
		student.grade = 3;
		student.address = "南昌";
		
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
		System.out.println("吃饭");
	}
	
	void introduce(){
		System.out.println("我的名字是" + name + "，我的年龄是" + age + "，我的家在" + address);
	}
}

class Student extends Person{
	int grade;
	
	void study(){
		System.out.println("我是" + grade + "年级学生，我爱学习");
	}
}

class Teacher extends Person{
	
}