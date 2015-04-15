package opdracht2;

public class Klant {
	private String naam, adres;

	public Klant(String naam, String adres) {
		super();
		this.naam = naam;
		this.adres = adres;
	}

	@Override
	public String toString() {
		return naam+" met adres: "+adres;
	}
}
