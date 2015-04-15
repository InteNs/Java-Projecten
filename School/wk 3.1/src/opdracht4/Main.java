package opdracht4;

public class Main {

	public static void main(String[] args) {
		KamerType[] types = new KamerType[10];
		types[0] = new KamerType("Standaard", 2, 60);
		types[1] = new KamerType("DeLuxe", 2, 85);
		types[2] = new KamerType("DeLuxe", 4, 125);
		types[3] = new KamerType("Hiker", 2, 35);
		
		System.out.println("Dit zijn de kamertypen:");
		for(KamerType t: types) {
			if(t != null) {
				System.out.println(t);
			}
		}
	}

}
