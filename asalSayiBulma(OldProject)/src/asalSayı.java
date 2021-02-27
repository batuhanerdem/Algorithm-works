import java.util.Scanner;

public class asalSayı {

	public static boolean AsalMi(int sayi) {
		for(int i=2; i<sayi; i++) {
			if(sayi % i == 0) {
				return false;
		}
		}return true;
	}
	
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		System.out.print("Sayıyı giriniz: ");
		int sayi = in.nextInt();
		if(AsalMi(sayi) && sayi>1) {
			System.out.println("Sayı asal");
		}else {
			System.out.println("Sayı asal değil");
		}
		in.close();
	
	}

}
