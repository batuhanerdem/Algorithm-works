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
			System.out.println("1. Bilgi göster");
			System.out.println("2. Para yatır");
			System.out.println("3. Para çek");
			System.out.println("4. Para gönder");
			System.out.println("5. Çıkış yap");
			System.out.println("6. Ana menüye dön");
			System.out.println("**********************************************");

			String secim = in.next();

			switch (secim) {
			case "1":
				bilgi(index);
				break;

			case "2":
				System.out.println("Kaç gayme atıyon bize   ");
				int miktar = in.nextInt();
				paraYatır(miktar, index);
				break;
			case "3":
				System.out.println("Çok çekme la\nNeyse kaç çekiyon? ");
				miktar = in.nextInt();
				while (miktar > Database.hesapList.get(index).getPara()) {
					System.out.println(
							"O kadar yok yalnız kanki sende. Senin bakiye: " + Database.hesapList.get(index).getPara());
					System.out.println("Tekrar gir bakim: ");
					miktar = in.nextInt();
				}
				paraCek(miktar, index);
				break;
			case "4":
				int id=0;
				 miktar=1;
				paraGonder(miktar,index,id);
				break;
			case "5":
				break menu;
			case "6":
				in.hasNextLine();
				startUp();
				break;
			}
		}
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
			login();
			break;

		case "2":
		case "kayıt ol yoldaş":
		case "Kayıt ol yoldaş":
			register();
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
		Hesap account = new Hesap(isim, sifre, 100, buba, 0, Database.hesapList.size() + 1);
		Database.hesapList.add(account);
		System.out.println("Senin ID: " + Database.hesapList.size());
		System.out.println("Kayıt oldun knk");
		startUp();
		return;
	}

	private static void login() {
		int i;
		boolean isContains = false;

		System.out.println("Girişe hoşgeldiniz...");
		System.out.println("ID'nizi giriniz: ");
		int id = in.nextInt();
		String x = in.nextLine();
		for (i = 0; i < Database.hesapList.size(); i++) {

			if (Database.hesapList.get(i).getId() == id) {
				isContains = true;
				break;
			}
		}
		if (isContains) {
			System.out.println("Şifrenizi giriniz:");
			String sifre = in.nextLine();

			if (Database.hesapList.get(i).getSifre().equals(sifre)) {
				Database.hesapList.get(i).setGiris(Database.hesapList.get(i).getGiris() + 1);
				menu(i);

			} else {
				System.out.println("Şifrenizi yanlış girdiniz... Lütfen tekrar deneyiniz.");
				login();
			}

		} else {
			System.out.println("ID'nizi yanlış girdiniz... Lütfen tekrar deneyiniz.");
			login();
		}

	}

	private static void bilgi(int index) {

		System.out.println("\nİsim: " + Database.hesapList.get(index).getIsim());
		System.out.println("Bakiye: " + Database.hesapList.get(index).getPara());
		System.out.println(
				"Baba: " + (Database.hesapList.get(index).isbuba() ? "var(şanslı araba)" : "yok(welcome to club)"));
		System.out.println("Giriş: " + Database.hesapList.get(index).getGiris() + ". kez girildi.");

	}

	private static void paraYatır(int miktar, int index) {
		if (miktar > 0) {
			Database.hesapList.get(index).setPara(Database.hesapList.get(index).getPara() + miktar);
			System.out.println(miktar + " lirayı bize verdin(enayi), yeni bakiyen: "
					+ Database.hesapList.get(index).getPara() + "\n");
			return;
		}
		System.out.println("Kanka eksili para yatıraman yok öyle bi şey.\n0'dan büyük bi şey yaz: ");
		int yenimiktar = in.nextInt();
		paraYatır(yenimiktar, index);

	}

	private static void paraCek(int miktar, int index) {
		if (miktar > 0) {
			Database.hesapList.get(index).setPara(Database.hesapList.get(index).getPara() - miktar);
			System.out.println(
					"Vermem ki o kadar\n " + "Şaka şaka " + miktar + " lirayı sana verdik(enayi olduk), yeni bakiyen: "
							+ Database.hesapList.get(index).getPara() + "\n");
			if (Database.hesapList.get(index).getPara() == 0) {
				System.out.println("Fakirsin xd");
			}
			return;
		}
		System.out.println("Kanka eksili para çekemen, bize para vermiş oluyon öyle(enayi).\n0'dan büyük bi şey yaz: ");
		int yenimiktar = in.nextInt();
		paraCek(yenimiktar, index);

	}

	private static void paraGonder(int miktar, int index, int id) {
		System.out.println("Miktarı giriniz: ");
		miktar = in.nextInt();
		if (miktar > 0 && miktar<=Database.hesapList.get(index).getPara()) {
			System.out.println("Para göndermek istediğiniz hesabın ID'sini giriniz: ");
			id = in.nextInt();
			if ((id-1) != index) {
				Database.hesapList.get(index).setPara(Database.hesapList.get(index).getPara() - miktar);
				Database.hesapList.get(id-1).setPara(Database.hesapList.get(id-1).getPara() + miktar);
				System.out.println("İşlem başarılı," + miktar + " tl gönderildi, yeni bakiyeniz: " + Database.hesapList.get(index).getPara());
				return;
			} else {
				System.out.println("Kendi kendinize para gönderemezsiniz...\nLütfen tekrar ID giriniz: ");
				int id2 = in.nextInt();
				paraGonder(miktar, index, id2);

			}
		} else {
			System.out.println("Değer 0'dan büyük olmalıdır veya bakiyenizden küöük olmalıdır; Bakiyeniz: " + Database.hesapList.get(index).getPara() + "\nİşlem iptal ediliyor...");
			return;
		}
	}
}
