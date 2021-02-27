import java.util.Scanner;

public class armstrongSayısı {

	public static void main(String[] args) {
		int sayı , sayı0 , temp , toplam=0 , basamak=-0 , basamakdeğeri;
		/* rakamlarının kendi basamak sayısı kadar üslerinin toplamı kendine eşit olan sayılara armstrong sayıları denir
		örnek: 1634 = 1^4 + 6^4 + 3^4 + 4^4
			   371= 3^3 + 7^3 + 1^3
		*/
		Scanner in = new Scanner(System.in);
		
		System.out.print("Sayıyı giriniz: ");
		sayı = in.nextInt();
		temp=sayı;
		sayı0=sayı;
		
		do {
			sayı0/=10;
			basamak++;
		} while(sayı0>0);
				
		
		do {
			basamakdeğeri = temp % 10;
			toplam += (int) Math.pow(basamakdeğeri, basamak);
			temp/=10;		
		} while(temp>0);
		
		
		
		if(toplam==sayı) {
			System.out.println("Sayı armstrong sayısıdır...");
		} else {
			System.out.println("Sayı armstrong sayısı değildir...");
		} in.close();
	}

}
