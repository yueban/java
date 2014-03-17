/* 44_equals函数的作用 */
public class Test_44{
	public static void main(String args []){
		/* test_01
		//"=="的作用是判断两个引用在堆内存中的地址是否相同
		User u1 = new User();
		User u2 = new User();
		User u3 = u1;

		boolean b1 = u1 == u2;
		boolean b2 = u1 == u3;

		System.out.println(b1);
		System.out.println(b2);
		*/

		/* test_02*/
		//equals用来判断两个对象的内容是否相同
		User u1 = new User();
		User u2 = new User();
		User u3 = new User();
		
		u1.name = "余然孜";
		u1.age = 20;

		u2.name = "芮舒辉";
		u2.age = 20;

		u3.name = "余然孜";
		u3.age = 20;

		System.out.println(u1.equals(u2));
		System.out.println(u1.equals(u3));
	}
}

class User{
	String name;
	int age;

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
}