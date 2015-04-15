package opdracht2;

import java.util.ArrayList;

public class Persoon {
	private String naam;
	private Goed foundObject;
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
	public void setBudget(double budget){
		this.budget = budget;
	}
	public boolean heeftGoed(String merk){
		boolean aanwezig = false;
		for (int i = 0; i < bezittingen.size(); i++) {
			if(bezittingen.get(i).getMerk() == merk)aanwezig = true;
		}
		return aanwezig;
	}
	public Goed zoek(String merk){
		for (int i = 0; i < bezittingen.size(); i++) {
			if(bezittingen.get(i).getMerk() == merk){
				foundObject = bezittingen.get(i);
			}
		}
		if(foundObject != null) return foundObject;
		else return null;
		
	}
	public boolean koop(Goed newGoed){
		boolean bezit = false;
		for(Goed g : bezittingen){
			if(g.equals(newGoed))bezit = true;
		}
		if(budget >= newGoed.huidigeWaarde()&& bezit == false){
			bezittingen.add(newGoed);
			budget -= newGoed.huidigeWaarde();
			System.out.println(naam + " heeft gekocht: " + newGoed.getMerk());
			return true;
		}
		else{
			System.out.println(naam + " heeft niet gekocht: " + newGoed.getMerk());
			return false;
		}
	}
	public boolean verkoop(Goed oldGoed, Persoon koper){
		
		if(bezittingen.contains(oldGoed) && koper.getBudget() >= oldGoed.huidigeWaarde()){
			koper.setBudget(koper.getBudget() - oldGoed.huidigeWaarde());
			budget += oldGoed.huidigeWaarde();
			bezittingen.remove(oldGoed);
			koper.bezittingen.add(oldGoed);
			System.out.println(koper.naam+" heeft gekocht: "+oldGoed.getMerk());
			System.out.println("verkoper "+naam+" heeft verkocht "+oldGoed.getMerk()+" aan koper "+koper.naam);
			return true;
			
		}
		
		else{
			System.out.println("verkoper "+naam+" bezit niet "+oldGoed.getMerk());
			return false;
		}
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
