/* 14_���������������� */
public class Test_14{
	public static void main(String args []){
		/* test_01
		Dog d = new Dog();
		
		d.name = "����";
		d.age = 2;
		d.color = "��ɫ";
		
		d.jump();
		System.out.println("�����ǣ�" + d.name);
		*/
		
		/* test_02
		Dog d1 = new Dog();
		Dog d2 = new Dog();
		
		d1.name = "����";
		d2.name = "��ϲ";
		
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
		System.out.println(name + "����");
	}
}