import java.util.*;

public class GenericVarargs{
	public static <T> List<T> makeList(T... args){
		List<T> result = new ArrayList<T>();
		for(T t : args){
			result.add(t);
		}
		return result;
	}

	public static void main(String[] args){
		List<String> ls = makeList("A");
		System.out.println(ls);

		ls = makeList("A", "B", "C");
		System.out.println(ls);

		ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
		System.out.println(ls);
	}
}