package opdracht1;

import java.text.NumberFormat;

public abstract class Goed {
	protected String merk;
	protected double nieuwPrijs;
	protected int aanschafJaar;
	
	public Goed(String merk, double nieuwPrijs, int aanschafJaar) {
		this.merk = merk;
		this.nieuwPrijs = nieuwPrijs;
		this.aanschafJaar = aanschafJaar;
	}

	public String getMerk() {
		return merk;
	}

	public abstract double huidigeWaarde();
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance();
		 nf.setMinimumFractionDigits(2);
		 nf.setMaximumFractionDigits(2);

		 double w = huidigeWaarde();
		 String waarde = nf.format(w);
		 String prijs = nf.format(nieuwPrijs);

		 return merk+"; aanschafprijs: "+prijs+ "; aanschafjaar: "+aanschafJaar+"; met huidige waarde: "+waarde+"\n";
	}
}
