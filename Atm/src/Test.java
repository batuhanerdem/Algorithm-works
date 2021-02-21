
public class Test {

	public static void main(String[] args) {

		Hesap account = new Hesap("batuhan", "12345", 1500);
		ATM atm = new ATM();
		atm.calis(account);
		System.err.println("Çıkış yapılıyor...");
		System.out.println("*****************************************************************************");

	}

}
