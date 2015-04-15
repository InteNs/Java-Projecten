package opdracht2;

public class Stand {
	private int punten;
	public Stand(int punten){
		this.punten = punten;
	}
	public int getPunten(){
		return punten;
	}
	public void voegPuntenToe(int punten){
		this.punten += punten;
	}
}
