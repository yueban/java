/* 31_Java���е��쳣������ */
public class Test_31{
	public static void main(String args []){
		User user = new User();
		try{
			user.setAge(-20);
		}catch(Exception e){
			e.printStackTrace();
			//System.out.println(e);
		}
	}
}

class User{
	private int age;
	
	public void setAge(int age) throws Exception{
		if(age < 0){
			//RuntimeException e = new RuntimeException("���䲻��Ϊ����");
			Exception e = new Exception("���䲻��Ϊ����");
			throw e;
		}
		this.age = age;
	}
}