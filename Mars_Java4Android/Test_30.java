/* 30_Java当中的异常（一） */
public class Test_30{
	public static void main(String args []){
		/* test_01*/
		System.out.println("1");
		//uncheck exception
		try{
			System.out.println("2");
			int i = 1 / 0;
			//int i = 1 / 1;
			System.out.println("3");
		}catch(Exception e){
			System.out.println("4");
			e.printStackTrace();
			System.out.println("5");
		}finally{
			System.out.println("finally");
		}
		System.out.println("6");
		
		/* test_02
		//check exception
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		*/
	}
}