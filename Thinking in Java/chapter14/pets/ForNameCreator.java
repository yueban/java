import java.util.*;

public class ForNameCreator extends PetCreator{
	private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
	
	private static String[] typeNames = {
		"Mutt",
		"Pug",
		"EgyptianMau",
		"Manx",
		"Cymric",
		"Rat",
		"Mouse",
		"Hamster",
	};
	
	@SuppressWarnings("unchecked")
	private static void loader(){
		try{
			for(String name:typeNames){
				types.add((Class<? extends Pet>)Class.forName(name));
			}
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}
	
	static {loader();}
	
	public List<Class<? extends Pet>> types(){
		return types;
	}
}