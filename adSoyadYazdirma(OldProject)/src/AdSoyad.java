import java.util.Scanner;

public class AdSoyad {
// siminizi istediğiniz kadar yazdiran program
	public static void main(String[] args) {
		String ad, soyad;
		int i=0;
		int n;
		Scanner input = new Scanner(System.in);
		System.out.print("kac kez yazdırmak istiyorsunuz? ");
		n=input.nextInt();
		
		System.out.print("Ad giriniz: ");
		ad = input.next();
		
		System.out.print("Soyad giriniz: ");
		soyad = input.next();

		input.close(); 
		for(i=0 ; i<n ; i++) {
			System.out.println((i + 1) + ". kez adiniz: " + ad);
			System.out.println((i + 1) + ". kez soyadiniz: " + soyad);
		}
	}

}
