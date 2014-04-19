import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileNotFoundExceptionDemo{
	public static void main(String[] args){
		String fileName = "C:\\Users\\bigfat\\Desktop\\Test.java";
		try{
			Scanner input = new Scanner(new File(fileName));
			System.out.println("File " + fileName + " Exists");
		}catch(FileNotFoundException ex){
			System.out.println("Exception:File " + fileName + " Not Found");
		}
	}
}