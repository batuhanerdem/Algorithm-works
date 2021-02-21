import java.util.Scanner;

public class ATM {

	public void calis(Hesap hesap) {

		Login login = new Login();
		Scanner in = new Scanner(System.in);
		System.out.println("Bankamıza hoşgeldiniz");
		System.err.println("********************************");
		System.out.println("Kullanıcı girişi");
		System.err.println("********************************");

		int giris_hakki = 3;

		while (true) {

			if (login.login(hesap)) {

				System.out.println("Giriş başarılı, hoşgeldin yoldaş");
				break;
			} else {
				System.err.println("Giriş başarısız!");
				giris_hakki--;
				System.out.println("Kalan giriş hakkı: " + giris_hakki);
			}
			if (giris_hakki == 0) {
				System.err.println("Üye ol da gel yoldaş.");
				return;
			}

		}

		String islem;
		loop: while (true) {
			hesap.Menu();
			in.hasNextLine();
			islem = in.nextLine();

			switch (islem) {
			case "1":
			case "Bakiye Görüntüleme":
				System.out.println("Bakiye: " + hesap.getBakiye());
				break;

			case "2":
			case "Para Yatırma":
				System.out.println("Yatırmak istediğiniz tutar: ");
				int tutar = in.nextInt();
				in.nextLine();
				hesap.paraYatir(tutar);
				break;
			case "3":
			case "Para Çekme":
				System.out.println("Çekmek istediğiniz tutar: ");
				tutar = in.nextInt();
				in.nextLine();
				hesap.paraCek(tutar);
				break;
			case "4":
			case "exit":
				break loop;

			default:
				System.out.println("Geçersiz işlem...");
				break;

			}
		}
	}
}
