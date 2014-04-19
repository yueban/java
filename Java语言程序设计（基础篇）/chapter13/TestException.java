public class TestException{
	public static void main(String[] args){
		int[] n = {1};
		try{
			int m = n[3];
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n" + e.getMessage());
			System.out.println("\n" + e.toString());
			System.out.println("\nTrace Info Obtained from getStackTrace");
			StackTraceElement[] traceElements = e.getStackTrace();
			for(int i = 0;i < traceElements.length;i++){
				System.out.print("method " + traceElements[i].getMethodName());
				System.out.print("(" + traceElements[i].getClassName() + ":");
				System.out.println(traceElements[i].getLineNumber() + ")");
			}
		}
	}
}