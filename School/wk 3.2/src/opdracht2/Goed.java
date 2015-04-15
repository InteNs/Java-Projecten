package opdracht2;

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
	//GETTERS AND SETTERS===================================//
	public String getMerk() {								//
		return merk;										//
	}														//
	public void setMerk(String merk) {						//
		this.merk = merk;									//
	}														//
	public double getNieuwPrijs() {							//
		return nieuwPrijs;									//
	}														//
	public void setNieuwPrijs(double nieuwPrijs) {			//
		this.nieuwPrijs = nieuwPrijs;						//
	}														//
	public int getAanschafJaar() {							//
		return aanschafJaar;								//
	}														//
	public void setAanschafJaar(int aanschafJaar) {			//
		this.aanschafJaar = aanschafJaar;					//
	}														//
	//======================================================//
	
	@Override
	public boolean equals(Object ander1){
		Goed ander = (Goed)ander1;
		if(getMerk().equals(ander.getMerk())
		&& getNieuwPrijs() == ander.getNieuwPrijs()
		&& getAanschafJaar() == ander.getAanschafJaar()){
			return true;
		}
		else return false;
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
