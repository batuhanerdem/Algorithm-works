public class Hesap {

	private String isim;
	private int para;
	private boolean buba;
	private int giris;
	private int id;
	private String sifre;
	
	
	public Hesap(String isim, String sifre, int para, boolean buba, int giris, int id){
		
		this.isim=isim;
		this.para=para;
		this.buba=buba;
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

	public boolean isbuba() {
			return buba;
	}

	public void setbuba(boolean buba) {
		this.buba = buba;
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