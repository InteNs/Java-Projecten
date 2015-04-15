package opdracht2;

import java.util.ArrayList;
import java.util.Calendar;

public class Boeking {
	private Calendar aanmaakDatum, vanDatum, totDatum;
	private int aantalPersonen;
	private Klant deBoeker;
	private ArrayList<Kamer> kamers;
	
	public Boeking(Calendar vanDatum, Calendar totDatum) {
		super();
		this.aanmaakDatum = Calendar.getInstance();
		this.vanDatum = vanDatum;
		this.totDatum = totDatum;
		kamers = new ArrayList<Kamer>();
	}

	public void wijsKamerToe(Kamer k) {
		kamers.add(k);
	}
	
	public void setAantalPersonen(int aantalPersonen) {
		this.aantalPersonen = aantalPersonen;
	}

	public void setDeBoeker(Klant deBoeker) {
		this.deBoeker = deBoeker;
	}
	
	private String datumString(Calendar c) {
		return (c.get(Calendar.DAY_OF_MONTH)+1)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.YEAR);
	}
	
	public String toString() {
		String s = "Boekingsdatum: "+datumString(aanmaakDatum)+"\n"+
				"Aantal personen: "+aantalPersonen+" en aantal kamers: "+kamers.size()+"\n"+
				"Gegevens van de boekende klant: "+deBoeker+"\n"+
				"Er is geboekt van "+datumString(vanDatum)+" tot "+datumString(totDatum)+"\n"+
				"De volgende kamers zijn geboekt: \n";
		for(Kamer k: kamers) {
			s += k+"\n";
		}
		return s;
	}
	
}
