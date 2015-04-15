package opdracht1;

public class Kamer {
	private int kamerNummer;
	private boolean extraBed;
	private KamerType hetType;
	
	public Kamer(int kamerNummer) {
		super();
		this.kamerNummer = kamerNummer;
	}

	public int getKamerNummer() {
		return kamerNummer;
	}

	public void setHetType(KamerType hetType) {
		this.hetType = hetType;
	}

	@Override
	public String toString() {
		return "kamer: "+kamerNummer+" en: "+hetType;
	}

	public boolean isExtraBed() {
		return extraBed;
	}

	public void setExtraBed(boolean extraBed) {
		this.extraBed = extraBed;
	}

	public KamerType getHetType() {
		return hetType;
	}

	public void setKamerNummer(int kamerNummer) {
		this.kamerNummer = kamerNummer;
	}

	
}
