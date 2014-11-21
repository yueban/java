// class Manipulator<T>{
// 	private T obj;

// 	public Manipulator(T x){
// 		obj = x;
// 	}

// 	public void manipulate(){
// 		obj.f();
// 	}
// }

public class Manipulation{
	public static void main(String[] args){
		HasF hf = new HasF();
		// Manipulator2<HasF> manipulator = new Manipulator2<HasF>(hf);
		Manipulator3 manipulator = new Manipulator3(hf);
		manipulator.manipulate();
	}
}