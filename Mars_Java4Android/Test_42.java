/* 42_�༯��ܣ����� */
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
		//����Set�����iterator������������һ�����������󣬸ö������ڱ�������Set
		//iterator��������Collection��
		Iterator<String> it = set.iterator();

		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
	}
}