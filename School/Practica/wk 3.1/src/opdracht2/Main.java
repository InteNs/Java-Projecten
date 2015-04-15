package opdracht2;
import java.util.Calendar;

public class Main {
	public static void main(String[] args) {
		Calendar van = Calendar.getInstance();
		van.set(2014, 6, 18);
		Calendar tot = Calendar.getInstance();
		tot.set(2014, 6, 23);
		Boeking b1 = new Boeking(van, tot);
		KamerType kt1 = new KamerType("Standaard", 2, 60.00);
		KamerType kt2 = new KamerType("DeLuxe", 2, 85.00);
		Kamer k1 = new Kamer(3);
		k1.setHetType(kt1);
		Kamer k2 = new Kamer(1); k2.setHetType(kt2);
		Kamer k3 = new Kamer(4); k3.setHetType(kt2);
		Klant kl1 = new Klant("Jaap de Vries", "Plein 9");
		b1.setDeBoeker(kl1);
		b1.setAantalPersonen(4);
		b1.wijsKamerToe(k1);
		b1.wijsKamerToe(k2);
		System.out.println(b1);
	}
}
