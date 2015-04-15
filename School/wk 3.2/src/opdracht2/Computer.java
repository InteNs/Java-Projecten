package opdracht2;

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
	public boolean equals(Object ander1){
		Computer ander;
		if(ander1 instanceof Computer) ander = (Computer)ander1;
		else return false;
		if(super.equals(ander)){
			if(ander instanceof Computer){
				if(getType() == ((Computer) ander).getType())return true;
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
		return "Computer " + super.toString();
	}
	

}
