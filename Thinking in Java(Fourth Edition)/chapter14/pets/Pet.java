public class Pet{
	public Pet(){}

	public Pet(String name){
		this.name = name;
	}

	private String name;
	
	public static void main(String[] args){
		System.out.println(Pet.class.getName());
	}
}