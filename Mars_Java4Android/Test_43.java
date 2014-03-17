/* 43_Àà¼¯¿ò¼Ü£¨Èý£© */
import java.util.Map;
import java.util.HashMap;

public class Test_43{
	public static void main(String args []){
		HashMap<String,String> hashMap = new HashMap<String,String>();
		Map<String,String> map = hashMap;
		
		map.put("1","a");
		map.put("2","b");
		map.put("3","c");
		map.put("4","d");
		map.put("3","e");
		
		int i = map.size();
		System.out.println(i);
		
		String s = map.get("3");
		System.out.println(s);
	}
}