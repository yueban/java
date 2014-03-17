/* 23_抽象类和抽象函数 */
public class Test_23{
	public static void main(String args []){
		/* test_01
		Person p = new Person();
		p.introduce();
		*/
		
		/* test_02*/
		Chinese c = new Chinese();
		c.name = "余然孜";
		c.age = 20;
		c.introduce();
		c.eat();
	}
}

abstract class Person{
	String name;
	int age;
	
	Person(){
		System.out.println("Person的无参数构造函数");
	}

	Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	void introduce(){
		System.out.println("我的名字是" + name + "，我的年龄是" + age);
	}
	
	abstract void eat();
}

class Chinese extends Person{
	String address;

	Chinese(){
		System.out.println("Chinese的无参数构造函数");
	}

	Chinese(String name,int age,String address){
		super(name,age);
		this.address = address;
	}
	
	void eat(){
		System.out.println("用筷子吃饭");
	}
}