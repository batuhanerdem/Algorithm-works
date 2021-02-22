
public class Hesap {

	private String isim;
	private int para;
	private boolean baba;
	private int giris;
	private int id;
	private String sifre;
	
	
	public Hesap(String isim, String sifre, int para, boolean baba, int giris, int id){
		
		this.isim=isim;
		this.para=para;
		this.baba=baba;
		this.giris=giris;
		this.id=id;
		this.sifre=sifre;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public int getPara() {
		return para;
	}

	public void setPara(int para) {
		this.para = para;
	}

	public boolean isBaba() {
		if(baba==false) {
			System.out.println("Welcome to club");
			
		}
			return baba;
	}

	public void setBaba(boolean baba) {
		this.baba = baba;
	}

	public int getGiris() {
		return giris;
	}

	public void setGiris(int giris) {
		this.giris = giris;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
