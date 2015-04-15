package opdracht1;

public class Huis {
	private String adres;
	private double huur;
	public Huis(String adres, double huur) {
		super();
		this.adres = adres;
		this.huur = huur;
	}
	public double huurPerMaand(){
		return huur;
	}
	@Override
	public String toString() {
		return "Huis [adres=" + adres + ", huur=" + huur + "]";
	}

}
