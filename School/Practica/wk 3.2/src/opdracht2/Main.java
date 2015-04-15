package opdracht2;

import java.util.Calendar;
public class Main {
	public static void main(String[] args) {
		int huidigJaar = Calendar.getInstance().get(Calendar.YEAR);
		int aanschafJaarG1 = huidigJaar - 4; // g1 is 4 jaar oud
		int aanschafJaarG2 = huidigJaar - 3; // g2 is 3 jaar oud
		int aanschafJaarG3 = huidigJaar - 4;
		int aanschafJaarG4 = huidigJaar - 3;
		int aanschafJaarG5 = huidigJaar - 7;
		Goed g1 = new Computer("Medion", 2000, aanschafJaarG1,"Super");
		Goed g2 = new Computer("Dell", 1500, aanschafJaarG2, "Home");
		Goed g3 = new Auto("Citroen", 25000,aanschafJaarG3,"26 GR NJ");
		Goed g4 = new Auto("Renault", 30000,aanschafJaarG4,"71 JH KD");
		Persoon p1 = new Persoon("Eric", 20000);
		Persoon p2 = new Persoon("Hans", 60000);
		Persoon p3 = new Persoon("Willem-Alexander", 8500000);
		if (p1.koop(g1)) {
			System.out.println("Kopen van 'Medion' is geslaagd!");
		}
		if (p1.koop(g3)) {
			System.out.println("Kopen van 'Citroen' is geslaagd!");
		}
		if (p2.koop(g2)) {
			System.out.println("Kopen van 'Dell' is geslaagd!\n");
		}
		if (p2.koop(g4)) {
			System.out.println("Kopen van 'Renault' is geslaagd!");
		}
		System.out.println(p1); System.out.println(p2);
		System.out.println(p3);
		if (p1.verkoop(g3, p2)) {
			System.out.println("Verkopen van 'Citroen' is geslaagd!");
		}
		if (p1.verkoop(g4, p3)) {
			System.out.println("Verkopen van 'Renault' is geslaagd!");
		}
		if (p2.verkoop(g1, p2)) {
			System.out.println("Verkopen van 'Medion' is geslaagd!");
		}
		System.out.println(p1); System.out.println(p2);
		System.out.println(p3);
		if (p3.koop(new Auto("BMW",65000,aanschafJaarG5,"AA BB 99"))) {
			System.out.println("Kopen van 'BMW' is geslaagd!");
		}
		if (p3.koop(new Auto("BMW",65000,aanschafJaarG5,"AA BB 99"))) {
			System.out.println("Kopen van 'BMW' is geslaagd!");
		}
		if (p3.verkoop(new Auto("BMW",65000,aanschafJaarG5,"AA BB 99"),p2)){
			System.out.println("Verkopen van 'BMW' is geslaagd!\n");
		}
		System.out.println(p2); System.out.println(p3);
	}
}
