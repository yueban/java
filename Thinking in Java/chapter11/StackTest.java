import java.util.Stack;

public class StackTest{
	public static void main(String[] args){
		Stack<String> stack = new Stack<String>();
		for(String s: "WangCai is a good dog!".split(" ")){
			stack.push(s);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
}