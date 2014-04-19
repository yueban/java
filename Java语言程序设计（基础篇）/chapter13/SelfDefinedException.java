public class SelfDefinedException{
	public static void main(String[] args){
		try{
			throw new MyException("my exception");
		}catch(MyException e){
			System.out.println(e.getExceptionInfo());
		}
	}
}

class MyException extends Exception{
	private String exceptionInfo;

	public MyException(String exceptionInfo){
		this.exceptionInfo = exceptionInfo;
	}

	public String getExceptionInfo(){
		return exceptionInfo;
	}
}