/* 15_�������������ģ� */
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
		
		System.out.println("person1��name��" + person1.name + "��age��" + person1.age);
		System.out.println("person2��name��" + person2.name + "��age��" + person2.age);
		*/
	}
}

class A{

	A(){
		System.out.println("���ǹ��캯��");
	}

	//ͬһ���º�������ͬ�������б�ͬ�ĺ���֮�乹�ɺ��������ع�ϵ
	void funA(){
		System.out.println("û�в�����funA����");
	}
	
	void funA(int i){
		System.out.println("ӵ��һ�����Ͳ�����funA����");
	}
	
	void funA(int i,double d){
		System.out.println("ӵ������������funA����");
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