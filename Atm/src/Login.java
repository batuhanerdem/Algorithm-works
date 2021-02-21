import java.util.Scanner;

public class Login {
	public boolean login(Hesap account) {

		Scanner in = new Scanner(System.in);
		System.out.println("Kullanıcı adınızı giriniz: ");
		String kullanici_adi = in.nextLine();
		System.out.println("Şifrenizi giriniz: ");
		String sifre = in.nextLine();

		if (account.getkullanici_adi().equals(kullanici_adi) && account.getSifre().equals(sifre)) {
			return true;
		} else {
			return false;
		}

	}
}
