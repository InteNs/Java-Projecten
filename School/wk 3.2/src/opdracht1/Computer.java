package opdracht1;

import java.util.Calendar;

public class Computer extends Goed {
	private String type;
	

	public Computer(String merk, double nieuwPrijs, int aanschafJaar,
			String type) {
		super(merk, nieuwPrijs, aanschafJaar);
		this.type = type;
	}
	public String getType(){
		return type;
	}

	@Override
	public double huidigeWaarde() {
		Calendar now = Calendar.getInstance();
		int leeftijd = now.get(Calendar.YEAR) - aanschafJaar;
		return (double)(nieuwPrijs * (Math.pow(0.6,leeftijd)));
	}

	@Override
	public String toString() {
		return "Computer " + super.toString();
	}
	

}
