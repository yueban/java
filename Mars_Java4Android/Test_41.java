/* 41_Àà¼¯¿ò¼Ü£¨Ò»£© */
import java.util.List;
import java.util.ArrayList;

public class Test_41{
	public static void main(String args []){
		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");
		
		arrayList.remove(1);
		
		for(int i = 0;i < arrayList.size();i++){
			String s = arrayList.get(i);
			System.out.println(s);
		}
		
	}
}