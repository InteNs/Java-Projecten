package opdracht1;

public class Persoon {
	private String naam;
	private int jaarSalaris;
	private Auto deAuto;
	private Huis hetHuis;
	public Persoon(String naam, int jaarSalaris) {
		super();
		this.naam = naam;
		this.jaarSalaris = jaarSalaris;
	}
	public void setDeAuto(Auto deAuto) {
		this.deAuto = deAuto;
	}
	public void setHetHuis(Huis hetHuis) {
		this.hetHuis = hetHuis;
	}
	public double vrijeMaandBesteding(){
		return (jaarSalaris / 12)-maandLasten();
	}
	public double maandLasten(){
		int lasten = 0;
		if(deAuto != null) lasten += deAuto.wegenbelastingPerMaand();
		if(hetHuis != null) lasten += hetHuis.huurPerMaand();
		return lasten;

	}
	public String toString(){
		return naam+ " heeft "+maandLasten()+ " euro aan maandelijkse lasten\n"+naam+ " heeft nog vrij per maand te besteden: "+vrijeMaandBesteding();

	}
}
