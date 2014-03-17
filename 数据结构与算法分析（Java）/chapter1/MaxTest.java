import java.io.*;
import java.util.*;

public class MaxTest{
	public static void main(String[] args){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String oneLine;
		StringTokenizer str;
		int x;
		int y;
		
		System.out.println("Enter 2 ints on one line:");
		try{
			oneLine = in.readLine();
			str = new StringTokenizer(oneLine);
			if(str.countTokens() != 2){
				throw new NumberFormatException();
			}
			x = Integer.parseInt(str.nextToken());
			y = Integer.parseInt(str.nextToken());
			System.out.println("Max is:" + Math.max(x,y));
		}catch(Exception e){
			System.out.println(e + "\nError:need two ints");
		}
	}
}