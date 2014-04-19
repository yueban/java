public class InternedStringTest{
	public static void main(String[] args){
		String s1 = "Welcome to java!";
		String s2 = new String("Welcome to java!");
		String s3 = "Welcome to java!";
		System.out.println("s1 == s2 : " + (s1 == s2));
		System.out.println("s1 == s3 : " + (s1 == s3));
	}
}