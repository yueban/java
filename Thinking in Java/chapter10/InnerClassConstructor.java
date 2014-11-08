class WithInner{
	class Inner{}
}

public class InnerClassConstructor{
	class A{
		private A(){
			System.out.println("A Constructor");
		}
	}

	static class B{
		private B(){
			System.out.println("B Constructor");
		}
	}

	class C extends WithInner.Inner{
		C(WithInner withInner){
			withInner.super();
			System.out.println("C Constructor");
		}
	}

	public static void main(String[] args){
		InnerClassConstructor i = new InnerClassConstructor();
		A a = i.new A();

		// InnerClassConstructor i2 = new InnerClassConstructor();
		// B a = i2.new B();
		B b = new B();

		C c = i.new C(new WithInner());
	}
}