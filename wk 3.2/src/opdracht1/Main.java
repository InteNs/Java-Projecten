package opdracht1;

import java.util.Calendar;

public class Main {
	public static void main(String[] args) {
		int huidigJaar = Calendar.getInstance().get(Calendar.YEAR);
		int aanschafJaarG1 = huidigJaar - 4; // g1 is 4 jaar oud
		int aanschafJaarG2 = huidigJaar - 3; // g2 is 3 jaar oud
		Goed g1 = new Computer("Medion", 2000, aanschafJaarG1, "Super");
		Goed g2 = new Computer("Dell", 1500, aanschafJaarG2, "Home");
		Persoon p1 = new Persoon("Eric", 20000);
		Persoon p2 = new Persoon("Hans", 60000);
		Persoon p3 = new Persoon("Willem-Alexander", 8500000);
		if (p1.koop(g1)) {
			System.out.println("Deze koper bezit nu nog "+ p1.getBudget());
		}
		if (p1.koop(g1)) {
			System.out.println("Deze koper bezit nu nog "+ p1.getBudget());
		}
		if (p2.koop(g1)) {
			System.out.println("Deze koper bezit nu nog "+ p2.getBudget());
		}
		if (p2.koop(g2)) {
			System.out.println("Deze koper bezit nu nog "+ p2.getBudget());
		}
		if (p3.koop(new Computer("Dell", 1500, aanschafJaarG2, "Home"))){
			System.out.println("Deze koper bezit nu nog " + p3.getBudget());
		}
		if (p3.koop(g2)) {
			System.out.println("Deze koper bezit nu nog " + p3.getBudget());
		}
		System.out.println("\n" + p1);
		System.out.println(p2);
		System.out.println(p3);
		if (p1.verkoop(g1, p3)) {
			System.out.println("Deze verkoper bezit nu nog "+p1.getBudget());
		}
		if (p2.verkoop(g1, p3)) {
			System.out.println("Deze verkoper bezit nu nog "+p2.getBudget());
		}
		if (p2.verkoop(g2, p1)) {
			System.out.println("Deze verkoper bezit nu nog "+p2.getBudget());
		}
		System.out.println("\n" + p1);
		System.out.println(p2);
		System.out.println(p3);
	}
}

