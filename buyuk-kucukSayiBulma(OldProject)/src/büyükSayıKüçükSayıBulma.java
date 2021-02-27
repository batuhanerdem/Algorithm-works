import java.util.Scanner;

public class büyükSayıKüçükSayıBulma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n , sayi , sayac , kucuk=2099000000 , buyuk = -2099000000;
		
	
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Kac sayi girmek istiyorsunuz?");
			n = input.nextInt();
			if (n>0) {
				break;
			}
			else {
				System.err.println("Lutfen pozitif bir sayi giriniz...");
			}
			
		} while (true);
		
		for(sayac=0; sayac<n; sayac++) {
			System.out.print("Lutfen " + (sayac + 1) + ". sayiyi giriniz: ");
			sayi=input.nextInt();
			 
			
						
			if(sayi>buyuk) {
				buyuk=sayi;
				
			}
			 if(sayi<kucuk) {
				kucuk=sayi;
			} 
		}input.close();
		System.out.println("buyuk sayi:" + buyuk);
		System.out.println("kucuk sayi:" + kucuk);
		
	} 

}
