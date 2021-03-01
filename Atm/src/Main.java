import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Hesap sülo = new Hesap("sülo", "123456", 400, false, 1, 1);
		Database.hesapList.add(sülo);
		startUp();

	}

	private static void menu(int index) {
		menu: while (true) {
			System.out.println("**********************************************");
			System.out.println("1. Bilgi gÃ¶ster");
			System.out.println("2. Para yatÄ±r");
			System.out.println("3. Para Ã§ek");
			System.out.println("4. Para gÃ¶nder");
			System.out.println("5. HesabÄ± sil");
			System.out.println("6. GiriÅŸe dÃ¶n ");
			System.out.println("7. Programdan Ã§Ä±k ");
			System.out.println("**********************************************");

			String secim = in.next();

			switch (secim) {
			case "1":
				bilgi(index);
				break;

			case "2":
				System.out.println("KaÃ§ gayme atÄ±yon bize   ");
				int miktar = in.nextInt();
				parayatir(miktar, index);
				break;
			case "3":
				System.out.println("Ã‡ok Ã§ekme la\nNeyse kaÃ§ Ã§ekiyon? ");
				miktar = in.nextInt();
				while (miktar > Database.hesapList.get(index).getPara()) {
					System.out.println(
							"O kadar yok yalnÄ±z kanki sende. Senin bakiye: " + Database.hesapList.get(index).getPara());
					System.out.println("Tekrar gir bakim: ");
					miktar = in.nextInt();
				}
				paraCek(miktar, index);
				break;
			case "4":
				paraGonder(index);
				break;
			case "5":
				removeAcc(index);
				in.nextLine();
				startUp();
				return;

			case "6":
				in.hasNextLine();
				in.nextLine();
				startUp();
				break;
			case "7":
				System.out.println("Ã‡Ä±kÄ±ÅŸ yapÄ±lÄ±yor...");
				break menu;
			}
		}
	}

	private static void startUp() {
		System.out.println("**********************************************");
		System.out.println("1. GiriÅŸ yap yoldaÅŸ");
		System.out.println("2. KayÄ±t ol yoldaÅŸ");
		System.out.println("**********************************************");
		String secim = in.nextLine();
		switch (secim) {
		case "1":
		case "giriÅŸ yap yoldaÅŸ":
		case "GiriÅŸ yap yoldaÅŸ":
			login();
			break;

		case "2":
		case "kayÄ±t ol yoldaÅŸ":
		case "KayÄ±t ol yoldaÅŸ":
			register();
			break;
		default:
			System.err.println("\nNe yazÄ±yon yoldaÅŸ?\n");
			startUp();
			break;
		}
	}

	private static void register() {
		boolean buba;
		System.out.println("KayÄ±da hoÅŸgeldiniz...");
		System.out.println("Ä°sim giriniz: ");
		String isim = in.nextLine();
		System.out.println("Å�ifre giriniz: ");
		String sifre = in.nextLine();
		System.out.println("Buba var mÄ±?(e/h)");
		String baba = in.nextLine();
		if (baba.equals("e")) {
			buba = true;
		} else if (baba.equals("h")) {
			buba = false;
		} else {
			System.err.println("BabacÄ±m ya e ya h yazcan neyini anlamadÄ±n");
			register();
			return;
		}
		Hesap account = new Hesap(isim, sifre, 100, buba, 0, Database.hesapList.size() + 1);
		Database.hesapList.add(account);
		System.out.println("Senin ID: " + Database.hesapList.size());
		System.out.println("KayÄ±t oldun knk");
		if(buba) {
			account.setPara(1000);
		}
		startUp();
		return;
	}

	private static void login() {
		System.out.println("GiriÅŸe hoÅŸgeldiniz...");
		Hesap yasar = findId();

		System.out.println("Å�ifrenizi giriniz:");
		in.nextLine();
		String sifre = in.nextLine();

		if (yasar.getSifre().equals(sifre)) {
			yasar.setGiris(yasar.getGiris() + 1);
			int i = Database.hesapList.indexOf(yasar);
			menu(i);

		} else {
			System.out.println("Å�ifrenizi yanlÄ±ÅŸ girdiniz... LÃ¼tfen tekrar deneyiniz.");
			login();
		}

	}

	private static void bilgi(int index) {

		System.out.println("\nÄ°sim: " + Database.hesapList.get(index).getIsim());
		System.out.println("Bakiye: " + Database.hesapList.get(index).getPara());
		System.out.println(
				"Baba: " + (Database.hesapList.get(index).isbuba() ? "var(ÅŸanslÄ± araba)" : "yok(welcome to club)"));
		System.out.println("GiriÅŸ: " + Database.hesapList.get(index).getGiris() + ". kez girildi.");

	}

	private static void parayatir(int miktar, int index) {
		if (miktar > 0) {
			Database.hesapList.get(index).setPara(Database.hesapList.get(index).getPara() + miktar);
			System.out.println(miktar + " lirayÄ± bize verdin(enayi), yeni bakiyen: "
					+ Database.hesapList.get(index).getPara() + "\n");
			return;
		}
		System.out.println("Kanka eksili para yatÄ±raman yok Ã¶yle bi ÅŸey.\n0'dan bÃ¼yÃ¼k bi ÅŸey yaz: ");
		int yenimiktar = in.nextInt();
		parayatir(yenimiktar, index);

	}

	private static void paraCek(int miktar, int index) {
		if (miktar > 0) {
			Database.hesapList.get(index).setPara(Database.hesapList.get(index).getPara() - miktar);
			System.out.println(
					"Vermem ki o kadar\n " + "Å�aka ÅŸaka " + miktar + " lirayÄ± sana verdik(enayi olduk), yeni bakiyen: "
							+ Database.hesapList.get(index).getPara() + "\n");
			if (Database.hesapList.get(index).getPara() == 0) {
				System.out.println("Fakirsin xd");
			}
			return;
		}
		System.out.println("Kanka eksili para Ã§ekemen, bize para vermiÅŸ oluyon Ã¶yle(enayi).\n0'dan bÃ¼yÃ¼k bi ÅŸey yaz: ");
		int yenimiktar = in.nextInt();
		paraCek(yenimiktar, index);

	}

	private static void paraGonder(int index) {
		System.out.println("MiktarÄ± giriniz: ");
		int miktar = in.nextInt();
		if (miktar > 0 && miktar <= Database.hesapList.get(index).getPara()) {
			System.out.println("Para gÃ¶ndermek istediÄŸiniz hesabÄ±n ID'sini giriniz: ");
			Hesap yasar = findId();
			if (Database.hesapList.indexOf(yasar) != index) {

				Database.hesapList.get(index).setPara(Database.hesapList.get(index).getPara() - miktar);
				Database.hesapList.get(Database.hesapList.indexOf(yasar)).setPara(yasar.getPara() + miktar);
				System.out.println(yasar.getIsim() + " kiÅŸisine " + miktar + " tlyi yolladÄ±n enayi \nYeni bakiyen: "
						+ Database.hesapList.get(index).getPara());
			} else {
				System.out.println("Kendi kendine para atamazsÄ±n bro. Tekrar dene.");
				paraGonder(index);
			}

		} else {
			System.out.println("DeÄŸer 0'dan bÃ¼yÃ¼k olmalÄ±dÄ±r veya bakiyenizden kÃ¼Ã§Ã¼k olmalÄ±dÄ±r; Bakiyeniz: "
					+ Database.hesapList.get(index).getPara() + "\nÄ°ÅŸlem iptal ediliyor...");
			return;
		}
	}

	public static Hesap findId() {

		int i;
		boolean isContains = false;

		System.out.println("ID giriniz:  ");
		int id = in.nextInt();
		for (i = 0; i < Database.hesapList.size(); i++) {

			if (Database.hesapList.get(i).getId() == id) {
				isContains = true;
				break;
			}
		}
		if (!isContains) {

			System.out.println("ID'yi yanlÄ±ÅŸ girdiniz... LÃ¼tfen tekrar deneyiniz.");
			return findId();

		}
		return Database.hesapList.get(i);
	}

	public static void removeAcc(int index) {
		Database.deletedList.add(Database.hesapList.get(index));
		Database.hesapList.remove(index);
		System.out.println("Hesap baÅŸarÄ±yla silindi.\nÃ‡Ä±kÄ±ÅŸ yapÄ±lÄ±yor...");
	}
}
