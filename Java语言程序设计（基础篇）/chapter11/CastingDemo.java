public class CastingDemo{
	public static void main(String[] args){
		Fruit f1 = new Fruit();
		Fruit f2 = new Apple();
		Fruit f3 = new Orange();

		test(f1);
		test(f2);
		test(f3);
	}

	public static void test(Fruit fruit){
		if(fruit instanceof Apple){
			((Apple)fruit).printApple();
		}else if(fruit instanceof Orange){
			((Orange)fruit).printOrange();
		}else{
			fruit.printFruit();
		}
	}
}

class Apple extends Fruit{
	public void printApple(){
		System.out.println("Apple");
	}
}

class Orange extends Fruit{
	public void printOrange(){
		System.out.println("Orange");
	}
}

class Fruit{
	public void printFruit(){
		System.out.println("Fruit");
	}
}