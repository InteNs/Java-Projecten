package opdracht2;

import java.io.Serializable;
import java.util.ArrayList;

import opdracht3.NoTransactionException;

public class Persoon implements Serializable{
	private String naam;
	boolean b;
	private double budget;
	private ArrayList<Goed> bezittingen;
	public Persoon(String naam, double budget) {
		this.naam = naam;
		this.budget = budget;
		bezittingen = new ArrayList<Goed>();
	}
	public double getBudget(){
		return budget;
	}
	public boolean heeftGoed(String merk){
		boolean aanwezig = false;
		for (int i = 0; i < bezittingen.size(); i++) {
			if(bezittingen.get(i).getMerk() == merk)aanwezig = true;
		}
		return aanwezig;
	}
	public Goed zoek(String merk){
		Goed foundObject = null;
		for (int i = 0; i < bezittingen.size(); i++) {
			if(bezittingen.get(i).getMerk() == merk){
				foundObject = bezittingen.get(i);
			}
		}
		return foundObject;
		
	}
	public boolean koop(Goed newGoed) throws NoTransactionException{
		if(!heeftGoed(newGoed.getMerk()) && budget >= newGoed.huidigeWaarde()){
			bezittingen.add(newGoed);
			budget -= newGoed.huidigeWaarde();
			System.out.println(naam + " heeft gekocht: " + newGoed.getMerk());
			b = true;
		}
		else{
			b = false;
			throw new NoTransactionException("Kopen mislukt, want heeft er al zo een");
		}
		return b;
	}
	public boolean verkoop(Goed oldGoed, Persoon koper) throws NoTransactionException{
		if(heeftGoed(oldGoed.getMerk()) && koper.getBudget() >= oldGoed.huidigeWaarde()){
			koper.budget -= oldGoed.huidigeWaarde();
			budget += oldGoed.huidigeWaarde();
			bezittingen.remove(oldGoed);
			koper.bezittingen.add(oldGoed);
			System.out.println(koper.naam+" heeft gekocht: "+oldGoed.getMerk());
			System.out.println(naam+" heeft verkocht: "+oldGoed.getMerk()+"aan koper: "+koper.naam);
			b = true;
		}
		else{
			b  = false;
			throw new NoTransactionException("kopen mislukt, want heeft er al zo een");
		}
		return b;
	}
	@Override
	public String toString() {
		String s = naam + " heeft budget: " + budget + " en bezittingen: \n";
		String s2 = "";
		for (int i = 0; i < bezittingen.size(); i++) {
			s2 += bezittingen.get(i).toString();
		}
		return s + s2;
	}
}
