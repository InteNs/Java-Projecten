package opdracht2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;

import opdracht3.NoTransactionException;

public class Main implements Serializable{
	public static void main(String[] args) {
		int huidigJaar = Calendar.getInstance().get(Calendar.YEAR);
		int aanschafJaarG1 = huidigJaar - 4; // g1 is 4 jaar oud
		int aanschafJaarG2 = huidigJaar - 3; // g2 is 3 jaar oud
		Goed g1 = new Computer("Medion", 2000, aanschafJaarG1, "Super");
		Goed g2 = new Computer("Dell", 1500, aanschafJaarG2, "Home");
		Persoon p1 = new Persoon("Eric", 20000);
		Persoon p2 = new Persoon("Hans", 60000);
		Persoon p3 = new Persoon("Willem-Alexander", 8500000);
		try {
			if (p1.koop(g1)) {
				System.out.println("Deze koper bezit nu nog "+ p1.getBudget());
			}
		} catch (NoTransactionException e) {
			System.out.println(e.getMessage());
		}
		try {
			if (p1.koop(g1)) {
				System.out.println("Deze koper bezit nu nog "+ p1.getBudget());
			}
		} catch (NoTransactionException e) {
			System.out.println(e.getMessage());
		}
		try {
			if (p2.koop(g1)) {
				System.out.println("Deze koper bezit nu nog "+ p2.getBudget());
			}
		} catch (NoTransactionException e) {
			System.out.println(e.getMessage());
		}
		try {
			if (p2.koop(g2)) {
				System.out.println("Deze koper bezit nu nog "+ p2.getBudget());
			}
		} catch (NoTransactionException e) {
			System.out.println(e.getMessage());
		}
		try {
			if (p3.koop(new Computer("Dell", 1500, aanschafJaarG2, "Home"))){
				System.out.println("Deze koper bezit nu nog " + p3.getBudget());
			}
		} catch (NoTransactionException e) {
			System.out.println(e.getMessage());
		}
		try {
			if (p3.koop(g2)) {
				System.out.println("Deze koper bezit nu nog " + p3.getBudget());
			}
		} catch (NoTransactionException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n" + p1);
		System.out.println(p2);
		System.out.println(p3);
		try {
			if (p1.verkoop(g1, p3)) {
				System.out.println("Deze verkoper bezit nu nog "+p1.getBudget());
			}
		} catch (NoTransactionException e) {
			System.out.println(e.getMessage());
		}
		try {
			if (p2.verkoop(g1, p3)) {
				System.out.println("Deze verkoper bezit nu nog "+p2.getBudget());
			}
		} catch (NoTransactionException e) {
			System.out.println(e.getMessage());
		}
		try {
			if (p2.verkoop(g2, p1)) {
				System.out.println("Deze verkoper bezit nu nog "+p2.getBudget());
			}
		} catch (NoTransactionException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n" + p1);
		System.out.println(p2);
		System.out.println(p3);
		schrijfweg(p1,"persoon1.obj"); p1 = null;
		schrijfweg(p2,"persoon2.obj"); p2 = null;
		schrijfweg(p3,"persoon3.obj"); p3 = null;
		p1 = lees("persoon1.obj");
		p2 = lees("persoon2.obj");
		p3 = lees("persoon3.obj");
		System.out.println("Na lezen uit file:");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

	}
	public static void schrijfweg(Persoon p, String filename) {
		try {
			ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream(filename));
			objectWriter.writeObject(p);
			objectWriter.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
	}
	public static Persoon lees(String filename)  {
			try{
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Persoon p = ((Persoon) ois.readObject());
			ois.close();
			return p;
			}catch (ClassNotFoundException e){
				e.printStackTrace();
			}catch (IOException e){
				e.printStackTrace();
			}
			return null;
	}
}

