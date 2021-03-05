import java.util.Scanner;

public class primeNumbers {

	public static boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = in.nextInt();
		if (isPrime(number) && number > 1) {
			System.out.println("Your number is prime number");
		} else {
			System.out.println("Your number is not prime number");
		}
		in.close();

	}

}
