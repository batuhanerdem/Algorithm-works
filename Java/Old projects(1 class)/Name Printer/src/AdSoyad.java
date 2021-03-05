import java.util.Scanner;

public class AdSoyad {

	public static void main(String[] args) {
		String name, surname;
		int i = 0;
		int n;
		Scanner input = new Scanner(System.in);
		System.out.print("How many times do you want to print your name?");
		n = input.nextInt();

		System.out.print("Enter name: ");
		name = input.next();

		System.out.print("Enter surname: ");
		surname = input.next();

		input.close();
		for (i = 0; i < n; i++) {
			System.out.print((i + 1) + ") " + name + " ");
			System.out.println(surname);
		}
	}

}
