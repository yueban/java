import java.util.Scanner;
import java.io.File;

//通过栈验证代码中括号是否一一对应
public class CheckPareByStack{
	//声明括号数组
	static final String[] Pare = {"(",")","[","]","{","}"};

	public static void main(String[] args){
		Scanner input = null;
		try{
			input = new Scanner(new File("D:\\kuaipan\\code\\java\\数据结构与算法分析（Java）\\chapter3\\StackArTest.java"));
		}catch(Exception e){
			System.out.println(e);
		}
		StringBuilder sb = new StringBuilder();
		while(input.hasNextLine()){
			sb.append(input.nextLine());
		}
		System.out.println(CheckPare(sb));
	}

	//检查sb中括号是否一一对应
	public static boolean CheckPare(StringBuilder sb){
		int length = sb.length();
		StackAr stack = new StackAr(20);
		for(int i = 0;i < length;i++){
			String temp = String.valueOf(sb.charAt(i));
			if(isLeftPare(temp)){
				stack.push(temp);
			}else if(isRightPare(temp)){
				if(stack.isEmpty()){
					return false;
				}else if(isMatched(stack.top(),temp)){
					stack.pop();
				}else{
					return false;
				}
			}
		}
		return stack.isEmpty()?true:false;
	}

	//是否是左括号
	public static boolean isLeftPare(String s){
		for(int i = 0;i < Pare.length;i+=2){
			if(s.equals(Pare[i])){
				return true;
			}
		}
		return false;
	}

	//是否是右括号
	public static boolean isRightPare(String s){
		for(int i = 1;i < Pare.length;i+=2){
			if(s.equals(Pare[i])){
				return true;
			}
		}
		return false;
	}

	//两括号是否匹配
	public static boolean isMatched(String a,String b){
		if( (a.equals(Pare[0]) && b.equals(Pare[1])) || 
			(a.equals(Pare[2]) && b.equals(Pare[3])) || 
			(a.equals(Pare[4]) && b.equals(Pare[5]))){
			return true;
		}
		return false;
	}
}

//栈的数组实现
class StackAr{
	public StackAr(int eleAmount){
		theArray = new String[eleAmount];
		topOfStack = -1;
	}

	public boolean isEmpty(){
		return topOfStack == -1;
	}

	public boolean isFull(){
		return topOfStack == theArray.length - 1;
	}

	public void push(String x){
		if(isFull()){
			System.out.println("Stack OverFLow!");
			return;
		}
		theArray[++topOfStack] = x;
	}

	public String top(){
		return isEmpty()?null:theArray[topOfStack];
	}

	public void pop(){
		if(isEmpty()){
			System.out.println("Stack UnderFlow!");
			return;
		}
		theArray[topOfStack--] = null;
	}

	public String topAndPop(){
		if(isEmpty()){
			return null;
		}
		String topItem = theArray[topOfStack];
		theArray[topOfStack--] = null;
		return topItem;
	}

	private String[] theArray;
	private int topOfStack;
}