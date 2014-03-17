/* 15_面向对象基础（四） */
public class Test_15{
	public static void main(String args []){
		/* test_01
		A a = new A();
		a.funA();
		a.funA(10);
		a.funA(1,2.0);
		*/
		
		/* test_02
		A a = new A();
		*/
		
		/* test_03
		Person person1 = new Person("zhangsan",10);
		Person person2 = new Person("lisi",20);
		
		System.out.println("person1的name是" + person1.name + "，age是" + person1.age);
		System.out.println("person2的name是" + person2.name + "，age是" + person2.age);
		*/
	}
}

class A{

	A(){
		System.out.println("我是构造函数");
	}

	//同一类下函数名相同，参数列表不同的函数之间构成函数的重载关系
	void funA(){
		System.out.println("没有参数的funA函数");
	}
	
	void funA(int i){
		System.out.println("拥有一个整型参数的funA函数");
	}
	
	void funA(int i,double d){
		System.out.println("拥有两个参数的funA函数");
	}
}

class Person{
	Person(){
	}
	
	Person(String n,int a){
		name = n;
		age = a;
	}
	
	String name;
	int age;
}