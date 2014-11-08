import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularExercise{
	public static void main(String[] args){
		// exercise1();
		exercise2();
	}

	public static void exercise1(){
		String str = "Java now has regular expressions";
		String[] regStrs = new String[]{"[^Java]","\\Breg.*","n.w\\s+h(a|i)s","s?","s*","s+","s{4}","s{1}","s{0,3}"};
		for(String regStr:regStrs){
			Pattern p = Pattern.compile(regStr);
			Matcher m = p.matcher(str);
			System.out.println(regStr);
			while(m.find()){
				System.out.println("Match \"" + m.group() + "\" at position " + m.start() + "-" + m.end());
			}
			System.out.println("----------");
		}
	}

	public static void exercise2(){
		String str = "Arline ate eight apples and one orange while Anita hadn't any";
		String regStr = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
		Pattern p = Pattern.compile(regStr);
		Matcher m = p.matcher(str);
		while(m.find()){
			System.out.println("Match \"" + m.group() + "\" at position " + m.start() + "-" + m.end());
		}
	}
}