import java.util.Scanner;

public class factorialWithFunction {
	
	
	public static void factorial(int number) {
	
		int factorial=1;
		while(number>0) {
			factorial*=number;
			number--;
		}
		System.out.println("factorial= " + factorial);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number please: ");
		int number= in.nextInt();
		factorial(number);
		in.close();
	}

}
