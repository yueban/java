/* 16_this的使用方法 */
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
		System.out.println("无参数的构造函数");
	}
	
	Person(String name,int age){
		this();
		this.name = name;
		this.age = age;
		System.out.println("两个参数的构造函数");
	}
	
	Person(String name,int age,String address){
		//若用this调用本类的其他构造函数，则this应放在第一行
		this(name,age);
		this.address = address;
		System.out.println("三个参数的构造函数");
	}
	
	//this代表调用该成员函数的对象
	void talk(String name){
		System.out.println("my name is " + this.name);
	}
}