import java.util.Scanner;

public class armstrongSayısı {

	public static void main(String[] args) {
		int number, digitFinder, temp, total = 0, digit = 0, digitvalue;
		Scanner in = new Scanner(System.in);

		System.out.print("Enter the number: ");
		number = in.nextInt();
		temp = number;
		digitFinder = number;

		do {
			digitFinder /= 10;
			digit++;
		} while (digitFinder > 0);

		do {
			digitvalue = temp % 10;
			total += (int) Math.pow(digitvalue, digit);
			temp /= 10;
		} while (temp > 0);

		if (total == number) {
			System.out.println(number + " is an armstrong number");
		} else {
			System.out.println(number + " is not an armstrong number");
		}
		in.close();
	}

}