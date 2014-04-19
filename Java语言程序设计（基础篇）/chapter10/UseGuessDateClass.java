import java.util.Scanner;

public class UseGuessDateClass{
	public static void main(String[] args){
		int date = 0;
		Scanner input = new Scanner(System.in);

		for(int setNo = 0;setNo < 5;setNo++){
			System.out.println("\nIs your birthday in:");
			for(int row = 0;row < 4;row++){
				for(int clomn = 0;clomn < 4;clomn++){
					System.out.printf("%-3s",GuessDate.getValue(setNo,row,clomn));
				}
				System.out.println();
			}
			System.out.print("Enter 1 for Yes and 0 for No:");
			date += input.nextInt() == 1 ? GuessDate.getValue(setNo,0,0) : 0;
		}

		System.out.println("\nYour birthday is " + date);
	}
}

class GuessDate{
	private GuessDate(){}

	public static int getValue(int setNo,int row,int clomn){
		return dates[setNo][row][clomn];
	}

	private static final int[][][] dates = {
		{{ 1, 3, 5, 7},
		 { 9,11,13,15},
		 {17,19,21,23},
		 {25,27,29,31}},
		{{ 2, 3, 6, 7},
		 {10,11,14,15},
		 {18,19,22,23},
		 {26,27,30,31}},
		{{ 4, 5, 6, 7},
		 {12,13,14,15},
		 {20,21,22,23},
		 {28,29,30,31}},
		{{ 8, 9,10,11},
		 {12,13,14,15},
		 {24,25,26,27},
		 {28,29,30,31}},
		{{16,17,18,19},
		 {20,21,22,23},
		 {24,25,26,27},
		 {28,29,30,31}}};
}