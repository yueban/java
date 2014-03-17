/* 31_Java当中的异常（二） */
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
			//RuntimeException e = new RuntimeException("年龄不能为负数");
			Exception e = new Exception("年龄不能为负数");
			throw e;
		}
		this.age = age;
	}
}