import generator.*;

public class BaseGeneratorDemo{
	public static void main(String[] args){
		Generator<CountedObject> gen = BaseGenerator.create(CountedObject.class);
		// Generator<CountedObject> gen = new BaseGenerator(CountedObject.class);
		for(int i = 0;i < 5;i++){
			System.out.println(gen.next());
		}
	}
}