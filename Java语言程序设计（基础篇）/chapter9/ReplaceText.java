import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceText{
	public static void main(String[] args) throws Exception{
		if(args.length != 4){
			System.out.println("Usage:java ReplaceText sourceFile targetFile odStr newStr");
			//java ReplaceText D:\github\java\Java语言程序设计（基础篇）\chapter9\PalindromeIgnoreNonAlphanumeric.java 1.txt StringBuilder StringBuffer
			System.exit(0);
		}

		File sourceFile = new File(args[0]);
		if(!sourceFile.exists()){
			System.out.println("Source file " + args[0] + " does not exist");
			System.exit(0);
		}

		File targetFile = new File(args[1]);
		if(targetFile.exists()){
			System.out.println("Target file " + args[1] + " already exists");
			System.exit(0);
		}

		Scanner input = new Scanner(sourceFile);
		PrintWriter output = new PrintWriter(targetFile);

		while(input.hasNext()){
			String s1 = input.nextLine();
			String s2 = s1.replaceAll(args[2],args[3]);
			output.println(s2);
		}

		input.close();
		output.close();
	}
}