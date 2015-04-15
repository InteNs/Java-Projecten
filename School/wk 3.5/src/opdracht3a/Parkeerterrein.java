package opdracht3a;

public class Parkeerterrein {
	private int maxAantal, aantalBezet;
	public Parkeerterrein(int maxAantal){
		this.maxAantal = maxAantal;
	}
	public int getAantalBezet(){
		return aantalBezet;
	}
	public void setAantalBezet(int aantal){
		this.aantalBezet = aantal;
	}
	public synchronized void autoErbij(){
		aantalBezet += 1;
	}
	public synchronized void autoEraf() {
		aantalBezet -= 1;
	}
}
