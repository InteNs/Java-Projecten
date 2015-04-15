package opdracht2;

import java.util.Calendar;

public class Auto extends Goed {
	private String kenteken;
	
	public Auto(String merk, double nieuwPrijs, int aanschafJaar, String kenteken) {
		super(merk, nieuwPrijs, aanschafJaar);
		this.kenteken = kenteken;
	}
	public String getKenteken(){
		return kenteken;
	}

	public boolean equals(Object ander1){
		Auto ander;
		if(ander1 instanceof Auto) ander = (Auto)ander1;
		else return false;
		if(super.equals(ander)){
			if(ander instanceof Auto){
				if(getKenteken().equals(((Auto) ander).getKenteken()))return true;
				else return false;
			}
			else return false;
		}
		else return false;
	}
	@Override
	public double huidigeWaarde() {
		Calendar now = Calendar.getInstance();
		int leeftijd = now.get(Calendar.YEAR) - aanschafJaar;
		return (double)(nieuwPrijs * (Math.pow(0.6,leeftijd)));
	}
	@Override
	public String toString() {
		return "Auto " + super.toString();
	}

}
