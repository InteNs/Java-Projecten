package opdracht5;

import java.util.ArrayList;

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
		
		System.out.println("Testen op dezelfde typenaam:");
		int aantal = 0;
		ArrayList<KamerType> gehad = new ArrayList<KamerType>();
		for(int i=0;i<types.length;i++) {
			KamerType t = types[i];
			if(t != null && !gehad.contains(t)) {
				for(int j=0;j<types.length;j++) {
					KamerType t2 = types[j];
					if(t2 != null && t != t2 && !gehad.contains(t2)) {
						if(t.getTypeNaam().equals(t2.getTypeNaam())) {
							System.out.println("ar["+i+"] heeft dezelfde typenaam als ar["+j+"]");
							aantal++;
							gehad.add(t);
							gehad.add(t2);
						}
					}
				}
						
			}
		}
		if(aantal == 0) {
			System.out.println("Er zijn geen typen met dezelfde typenaam");
		}
		
		System.out.println();
		System.out.println("Testen op equals:");
		aantal = 0;
		gehad = new ArrayList<KamerType>();
		for(int i=0;i<types.length;i++) {
			KamerType t = types[i];
			if(t != null && !gehad.contains(t)) {
				for(int j=0;j<types.length;j++) {
					KamerType t2 = types[j];
					if(t.equals(t2) && t != t2 && !gehad.contains(t2)) {
						System.out.println("ar["+i+"] is hetzelfde als ar["+j+"]");
						aantal++;
					}
				}
						
			}
		}
		if(aantal == 0) {
			System.out.println("Er zijn geen objecten met dezelfde inhoud");
		}
	}

}
