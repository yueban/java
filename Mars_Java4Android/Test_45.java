/* 45_hashCode()与toString() */
import java.util.*;

public class Test_45{
	public static void main(String args []){
		/* test_01
		User u = new User("余然孜",20);

		HashMap<User,String> map = new HashMap<User,String>();
		map.put(u,"abc");
		
		String s = map.get(new User("余然孜",20));
		System.out.println(s);
		*/

		/* test_02*/
		User u = new User("余然孜",20);

		System.out.println(u);
	}
}

class User{
	String name;
	int age;

	public User(){

	}

	public User(String name,int age){
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}

		boolean b = obj instanceof User;
		if(b){
			User u = (User)obj;

			if(this.age == u.age && this.name.equals(u.name)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public int hashCode(){
		int result = 17;

		result = 31 * result + age;
		result = 31 * result + name.hashCode();

		return result;
	}

	public String toString(){
		String result = "name:" + name + ";age:" + age + "\n";
		return result;
	}
}