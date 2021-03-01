import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.print("Enter the number: ");
		int number = in.nextInt();

		int factorial = 1;
		
		while (number > 0) {
			factorial *= number;
			number--;
		}
		System.out.println(factorial);
		in.close();
	}
}
