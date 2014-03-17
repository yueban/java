/* 42_类集框架（二） */
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Test_42{
	public static void main(String args []){
		/* test_01
		HashSet<String> hashSet = new HashSet<String>();
		Set<String> set = hashSet;
		
		boolean b = set.isEmpty();
		System.out.println(b);
		
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("c");
		
		b = set.isEmpty();
		System.out.println(b);
		
		set.remove("a");
		
		int i = set.size();
		System.out.println(i);
		
		set.clear();
		
		i = set.size();
		System.out.println(i);
		*/
		
		/* test_02*/
		HashSet<String> hashSet = new HashSet<String>();
		Set<String> set = hashSet;
		
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		//Iterator <-- Collection <-- Set <-- HashSet
		//hasNext(); next();
		//调用Set对象的iterator方法，会生成一个迭代器对象，该对象用于遍历整个Set
		//iterator方法属于Collection类
		Iterator<String> it = set.iterator();

		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
	}
}