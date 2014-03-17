/* 17_static关键字的作用 */
public class Test_17{
	public static void main(String args []){
		/* test_01
		Person p1 = new Person();
		p1.i = 10;
		Person p2 = new Person();
		p2.i = 20;
		
		//Person.i = 30;
		System.out.println("p1的i的值为" + p1.i);
		System.out.println("p2的i的值为" + p2.i);
		
		//Person.i = 40;
		p1.i = 50;
		System.out.println("p1的i的值为" + p1.i);
		System.out.println("p2的i的值为" + p2.i);
		*/
		
		/* test_02*/
		Person.name = "zhangsan";
		Person.talk();
	}
}

class Person{
	/* test_01
	static int i;
	*/
	
	/* test_02*/
	static{
		System.out.println("静态代码块");
	}
	
	static String name;
	
	static void talk(){
		System.out.println("my name is " + name);
	}
}