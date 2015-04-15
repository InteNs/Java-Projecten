package opdracht1;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private ArrayList<Boeking> boekingen;
	private Kamer[] kamers;
	
	public Hotel() {
		boekingen = new ArrayList<Boeking>();
		kamers = new Kamer[20];
		for(int i=0;i<kamers.length;i++) {
			kamers[i] = new Kamer(i);
			kamers[i].setHetType(new KamerType[]{new KamerType("Standaard", 2, 60.00), new KamerType("DeLuxe", 2, 85.00),  new KamerType("DeLuxe", 4, 125), new KamerType("Hiker", 2, 35)}[i%4]);
		}
	}
	
	public void voegBoekingToe(Boeking b, KamerType kt) {
		boekingen.add(b);
		for(Kamer k: kamers) {
			if(k.getHetType() == kt) {
				b.wijsKamerToe(k);
				break;
			}
		}
	}
	
	public List<KamerType> geefAlleKamerTypen() {
		ArrayList<KamerType> types = new ArrayList<KamerType>();
		for(Kamer k: kamers) {
			if(!types.contains(k.getHetType())) {
				types.add(k.getHetType());
			}
		}
		return types;
	}
	

	@Override
	public String toString() {
		String s = "Boekingen:\n";
		for(Boeking b: boekingen) {
			s += b+"\n";
		}
		return s;
	}
}
