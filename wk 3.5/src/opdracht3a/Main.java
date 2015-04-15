package opdracht3a;

public class Main {
	  public static void main(String[] args) throws InterruptedException {
	    System.out.println("Parkeerterrein met 50 plaatsen");
	    Parkeerterrein p = new Parkeerterrein(50);
	    p.setAantalBezet(12);
	    System.out.println("Start: 12 plaatsen bezet");
	    KomenThread kt = new KomenThread(p);
	    GaanThread vt = new GaanThread(p);
	    kt.start();
		vt.start();
		kt.join();
		vt.join();
		System.out.println("Einde: "+p.getAantalBezet()+" bezet"); 
	}
}
