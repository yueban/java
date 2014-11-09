import java.util.*;

public class PetCount3{
	static class PetCounter extends HashMap<Class<? extends Pet>,Integer>{
		public PetCounter(){
			for(Class<? extends Pet> c:LiteralPetCreator.allTypes){
				put(c,0);
			}
		}

		public void count(Pet pet){
			for(Map.Entry<Class<? extends Pet>,Integer> pair:entrySet()){
				if(pair.getKey().isInstance(pet)){
					put(pair.getKey(),pair.getValue()+1);
				}
			}
		}
	}


	public static void main(String[] args){
		PetCounter petCount = new PetCounter();
		for(Pet pet:Pets.createArray(20)){
			petCount.count(pet);
		}
		System.out.println(petCount);
	}
}