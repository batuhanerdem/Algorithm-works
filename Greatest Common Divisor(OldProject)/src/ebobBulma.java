import java.util.Scanner;

public class ebobBulma {

	public static int gcd(int sayi1, int sayi2) {
		int gcd=1;
		for(int i=1; i<sayi1 && i<sayi2; i++) {
			
			if((sayi1 % i == 0) && (sayi2 % i == 0)) {
				gcd=i;
			} 
			
		} return gcd;
		
		
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		int number1 , number2;
		
		System.out.print("Enter first number: ");
		number1=in.nextInt();
		
		System.out.print("Enter second number: ");
		number2=in.nextInt();
		
		System.out.print("Greatest common divisor is: " + gcd(number1 , number2));
		in.close();
		

	}

}
