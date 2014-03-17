import java.util.Scanner;

public class ComputeAeraWithConsoleInput{
	public static void main(String[] args){
		//创建一个Scanner类型的对象
		Scanner input = new Scanner(System.in);
		
		//读取用户输入
		System.out.println("请输入圆的半径：");
		double radius = input.nextDouble();
		
		//计算圆的面积
		double area = radius * radius * 3.14159;
		
		//输出结果
		System.out.println("半径为 " + radius + " 的圆的面积为 " + area);
	}
}