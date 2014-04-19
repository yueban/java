public class PalindromeIgnoreNonAlphanumeric{
	public static void main(String[] args){
		String s = "12'z][]][3z2.,1";
		System.out.println(isPalindrome(s));
	}

	public static boolean isPalindrome(String s){
		String s1 = filter(s);
		String s2 = reverse(s1);
		return s1.equals(s2);
	}

	public static String filter(String s){
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0;i < s.length();i++){
			if(Character.isLetterOrDigit(s.charAt(i))){
				stringBuilder.append(s.charAt(i));
			}
		}
		return stringBuilder.toString();
	}

	public static String reverse(String s){
		StringBuilder stringBuilder = new StringBuilder(s);
		stringBuilder.reverse();
		return stringBuilder.toString();
	}
}