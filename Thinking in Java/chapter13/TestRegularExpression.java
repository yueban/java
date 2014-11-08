import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TestRegularExpression{
	public static void main(String[] args){
		args = new String[]{"abcabcabcdefabc","abc+","(abc)+","(abc){2,}"};
		System.out.println("Input: \"" + args[0] + "\"");
		for(String arg:args){
			System.out.println("Regular expression: \"" + arg + "\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			while(m.find()){
				System.out.println("Match \"" + m.group() + "\" at position " + m.start() + "-" + m.end());
			}
		}
	}
}