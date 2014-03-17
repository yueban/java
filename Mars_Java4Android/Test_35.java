/* 35_内部类和匿名内部类 */
public class Test_35{
	public static void main(String args []){
		/* test_01
		A a = new A();
		A.B b = a.new B();
		
		a.i = 3;
		b.j = 5;
		int result = b.funB();
		System.out.println(result);
		*/
		
		/* test_02*/
		//AImpl a1 = new AImpl();
		//A a = a1;
		
		B b= new B();
		b.fun(new A(){
			public void doSomething(){
				System.out.println("匿名内部类");
			}
		});
	}
}

/* test_01
class A{
	int i;
	
	class B{
		int j;
		
		int funB(){
			int result = A.this.i + this.j;
			return result;
		}
	}
}
*/

/* test_02*/
interface A{
	public void doSomething();
}

class AImpl implements A{
	public void doSomething(){
		System.out.println("doSomething");
	}
}

class B{
	public void fun(A a){
		System.out.println("B类的fun函数");
		a.doSomething();
	}
}