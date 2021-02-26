import java.util.Random;
import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("*********************************");
		System.out.println("Welcome to the game.");
		System.out.println("*********************************");
		startUp();
	}

	public static void startUp() {

		System.out.println("1. Register");
		System.out.println("2. Login");
		int chose = in.nextInt();
		in.nextLine();
		if (chose == 1) {
			register();
			return;
		}
		if (chose == 2) {
			login();
			return;
		}
	}

	public static void register() {
		System.out.println("Please enter an username: ");
		String username = in.nextLine();

		if (Database.accountList.size() == 0) {
			System.out.println("Please enter a password: ");
			String password = in.nextLine();
			Accounts account = new Accounts(username, password);
			Database.accountList.add(account);
			System.out.println("You registered.");
			startUp();
			return;
		}
		boolean check = true;
		for (int i = 0; i < Database.accountList.size(); i++) {

			if (username.equals(Database.accountList.get(i).getUsername())) {
				check = false;
				break;
			}
		}
		if (check) {
			System.out.println("Please enter a password: ");
			String password = in.nextLine();
			Accounts account = new Accounts(username, password);
			Database.accountList.add(account);
			System.out.println("You registered.");
			startUp();
			return;
		} else {
			System.out.println("Username is taken, please enter another one");
			register();
			return;
		}
	}

	public static void login() {

		System.out.println("Please enter your username: ");
		String username = in.nextLine();
		boolean check = false;
		int i;
		for (i = 0; i < Database.accountList.size(); i++) {
			if (username.equals(Database.accountList.get(i).getUsername())) {
				check = true;
				break;
			}
		}
		if (check) {
			System.out.println("Enter password: ");
			String password = in.nextLine();
			for (i = 0; i < Database.accountList.size(); i++) {
				if (password.equals(Database.accountList.get(i).getPassword())) {
					check = true;
					break;
				} else {
					check = false;
				}
			}
			if (check) {

			} else {
				System.out.println("Wrong password, try again");
				login();
				return;
			}
		} else {
			System.out.println("Wrong username, try again");
			login();
			return;
		}
		menu();
	}

	public static void game() {
		int guess;
		Random random = new Random();
		int point = 0;
		int number;
		System.out.println("Please enter 1 or 2");
		while (true) {
			number = random.nextInt(2) + 1;
			System.out.println("Level: " + (point + 1));
			guess = in.nextInt();
			if (guess != number) {
				System.out.println("Wrong guess, number was: " + number);
				System.err.println("Your point: " + point);
				menu();
				break;
			}
			point++;
			System.out.println("Correct guess!");
		}
	}

	public static void menu() {
		System.out.println("****************************");
		System.out.println("Menu");
		System.out.println("****************************");
		System.out.println("1. Play the game");
		System.out.println("2. Logout");
		System.out.println("3. Show last score list");
		System.out.println("4. Show high score");
		System.out.println("5. Exit");
		int chose = in.nextInt();
		in.nextLine();
		switch (chose) {
		case 1:
			game();
			break;
		case 2:
			startUp();
			return;
		case 3:
			// to do
			break;
		case 4:
			// to do
			break;
		case 5:
			// to do
			break;
		}
	}
}
