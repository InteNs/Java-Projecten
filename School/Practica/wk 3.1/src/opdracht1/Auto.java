package opdracht1;

public class Auto {
	private String merk, kenteken;
	private int gewicht;
	public Auto(String merk, String kenteken, int gewicht) {
		super();
		this.merk = merk;
		this.kenteken = kenteken;
		this.gewicht = gewicht;
	}
	public double wegenbelastingPerMaand(){
		if(gewicht < 1000) return 200;
		return 300;
	}
	@Override
	public String toString() {
		return "Auto [merk=" + merk + ", kenteken=" + kenteken + ", gewicht="
				+ gewicht + "]";
	}

}
