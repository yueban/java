import java.util.Scanner;
import java.util.InputMismatchException;

public class InputMismatchExceptionDemo{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;
		while(continueInput){
			try{
				int number = input.nextInt();
				System.out.println("you input a " + number);
				continueInput = false;
			}catch(InputMismatchException ex){
				System.out.println("Input again,you should input an integer!");
				input.nextLine();
			}
		}
	}
}