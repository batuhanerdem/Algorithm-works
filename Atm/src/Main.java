import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		startUp();
	}

	private void menu() {

	}

	private static void startUp() {
		System.out.println("**********************************************");
		System.out.println("1. Giriş yap yoldaş");
		System.out.println("2. Kayıt ol yoldaş");
		System.out.println("**********************************************");
		String secim = in.nextLine();
		switch (secim) {
		case "1":
		case "giriş yap yoldaş":
		case "Giriş yap yoldaş":
			// to do
			break;

		case "2":
		case "kayıt ol yoldaş":
		case "Kayıt ol yoldaş":
			register();
			// to do
			break;
		default:
			System.err.println("\nNe yazıyon yoldaş?\n");
			startUp();
			break;
		}
	}

	private static void register() {
		boolean buba;
		System.out.println("Kayıda hoşgeldiniz...");
		System.out.println("İsim giriniz: ");
		String isim = in.nextLine();
		System.out.println("Şifre giriniz: ");
		String sifre = in.nextLine();
		System.out.println("Buba var mı?(e/h)");
		String baba = in.nextLine();
			if (baba.equals("e")) {
				buba = true;
			} else if (baba.equals("h")) {
				buba = false;
			} else {
				System.err.println("Babacım ya e ya h yazcan neyini anlamadın");
				register();
				return;
		}
			Hesap account = new Hesap(isim, sifre, 100, buba, 0, 60);
			Database.hesapList.add(account);
			System.out.println(Database.hesapList);
	}

}
