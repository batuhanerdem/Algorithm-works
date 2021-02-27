import java.util.Scanner;

public class büyükSayıKüçükSayıBulma {

	public static void main(String[] args) {
		int n, number, counter, small_number = 2099000000, big_number = -2099000000;

		Scanner input = new Scanner(System.in);

		do {
			System.out.print("How many numbers do you want to enter? ");
			n = input.nextInt();
			if (n > 0) {
				break;
			} else {
				System.err.println("Please enter a number greater than 0");
			}

		} while (true);

		for (counter = 0; counter < n; counter++) {
			System.out.print("Please enter the " + (counter + 1) + ". number: ");
			number = input.nextInt();

			if (number > big_number) {
				big_number = number;

			}
			if (number < small_number) {
				small_number = number;
			}
		}
		input.close();
		System.out.println("Greatest number:" + big_number);
		System.out.println("Smallest number:" + small_number);

	}

}
