import java.util.Scanner;

public class ebobBulma {

	public static int Ebob(int sayi1, int sayi2) {
		int ebob=1;
		for(int i=1; i<sayi1 && i<sayi2; i++) {
			
			if((sayi1 % i == 0) && (sayi2 % i == 0)) {
				ebob=i;
			} 
			
		} return ebob;
		
		
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		int birinciSayi , ikinciSayi;
		
		System.out.print("Birinci sayıyı giriniz: ");
		birinciSayi=in.nextInt();
		
		System.out.print("İkinci sayiyi giriniz: ");
		ikinciSayi=in.nextInt();
		
		System.out.print("İki sayının en büyük ortak böleni: " + Ebob(birinciSayi , ikinciSayi));
		in.close();
		

	}

}
