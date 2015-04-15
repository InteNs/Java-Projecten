package opd1;

class ScooterLening {
	private String merk;
	private int maxAantalMaanden;
	private int maandenBetaalt;
	private double bedragPerMaand;
	private double aanBetaling;
	private double totNuToeBetaald;

	public ScooterLening (String mk, int mM, double bPM) {
		merk = mk;
		maxAantalMaanden = mM;
		bedragPerMaand = bPM;
	}

	public String getMerk() {
		return merk;
	}
	public double getAanBetaling() {
		return aanBetaling;
	}
	public void setAanBetaling(double nAB) {
		aanBetaling = nAB;
	}
	public void verwerkMaandBetaling() {
		maandenBetaalt =+ 1;
	}
	public double totNuToeBetaald() {
		totNuToeBetaald = maandenBetaalt * bedragPerMaand + aanBetaling;
		return totNuToeBetaald;
	}
	public String toString() {
		String s ="Deze "+merk+" kost "+bedragPerMaand+" per maand en er is "+maandenBetaalt+" van de "+maxAantalMaanden+" maanden betaald.";
		return s;
	}
}




