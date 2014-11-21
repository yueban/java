public class GenericMethods{
	public <T> void f(T x){
		System.out.println(x.getClass().getName());
	}

	public <A,B> void f(A a, B b){
		System.out.println("type a: " + a.getClass().getName() + "\ntype b: " + b.getClass().getName());
	}

	public static void main(String[] args){
		GenericMethods gm = new GenericMethods();
		gm.f("");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0f);
		gm.f('c');
		gm.f(gm);

		gm.f(1,1.0);
	}
}