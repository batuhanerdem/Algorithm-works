
public class Hesap {
	private String kullanici_adi;
	private String sifre;
	private int bakiye;
	
	
	public Hesap(String kullanici_adi, String sifre, int bakiye) {
		this.kullanici_adi=kullanici_adi;
		this.sifre=sifre;
		this.bakiye=bakiye;
	}
	public Hesap() {
		
	}

	public String getkullanici_adi() {
		return kullanici_adi;
	}


	public void setkullanici_adi(String kullanici_adi) {
		this.kullanici_adi = kullanici_adi;
	}


	public String getSifre() {
		return sifre;
	}


	public void setSifre(String sifre) {
		this.sifre = sifre;
	}


	public int getBakiye() {
		return bakiye;
	}


	public void setBakiye(int bakiye) {
		this.bakiye = bakiye;
	}
	
	
	public void paraYatir(int miktar) {
		do {
		if(miktar<=0) {
			System.out.println("Lütfen 0'dan büyük bir sayı giriniz...");
			break;
		}else {
			bakiye+=miktar;
			System.out.println(miktar + " tl yatırıldı\nYeni bakiye: " + bakiye);
			break;
		}	
			
			
			
		}while(true);
		
	}
	
	
	public void paraCek(int miktar) {
		do {
			if(miktar<=0) {
				System.out.println("Lütfen 0'dan büyük bir sayı giriniz.");
				break;
				
			}else {
				if(miktar>2000) {
					System.out.println("Bir gunde 2000 tl'den fazla cekemezsiniz.");
				}
				else if(bakiye>=miktar) {
					bakiye-=miktar;
					System.out.println(miktar + " tl cekildi\nYeni bakiye: " + bakiye);
				}
				else {
					System.out.println("Bakiyenizden fazla cekemezsiniz! Bakiyeniz: " + bakiye);
				}
				if(bakiye==0) {
					System.err.println("Artık fakirsiniz(babanız yok)");
				} break;
				
			}
			
			
		}while(true);

			
		
	}
	
	
	
}
