public class Holder2{
	private Object a;

	public Holder2(Object a){
		this.a = a;
	}

	public void set(Object a){
		this.a = a;
	}

	public Object get(){
		return a;
	}

	public static void main(String[] args){
		Holder2 h2 = new Holder2(new AutoMobile());
		AutoMobile a = (AutoMobile)h2.get();

		h2.set("Not an AutoMobile");
		// System.out.println((String)h2.get());
		System.out.println(h2.get());

		h2.set(1);
		System.out.println(h2.get());
	}
}