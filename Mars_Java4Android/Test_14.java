/* 14_面向对象基础（三） */
public class Test_14{
	public static void main(String args []){
		/* test_01
		Dog d = new Dog();
		
		d.name = "旺财";
		d.age = 2;
		d.color = "黑色";
		
		d.jump();
		System.out.println("名字是：" + d.name);
		*/
		
		/* test_02
		Dog d1 = new Dog();
		Dog d2 = new Dog();
		
		d1.name = "旺财";
		d2.name = "四喜";
		
		d1.jump();
		d2.jump();
		*/
		
		/* test_03
		new Dog().jump();
		*/
	}
}

class Dog{
	String name;
	int age;
	String color;
	
	void jump(){
		//System.out.println("jump");
		System.out.println(name + "在跳");
	}
}