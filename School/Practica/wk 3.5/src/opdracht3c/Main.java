package opdracht3c;

public class Main {
	  public static void main(String[] args) throws InterruptedException {
	    System.out.println("Parkeerterrein met 50 plaatsen");
	    Parkeerterrein p = new Parkeerterrein(50);
	    p.setAantalBezet(12);
	    System.out.println("Start: 12 plaatsen bezet");
	    KomenThread kt = new KomenThread(p);
	    GaanThread vt = new GaanThread(p);
	    Thread thread1 = new Thread(kt);
	    Thread thread2 = new Thread(vt);
	    thread1.start();
	    thread2.start();
	    thread1.join();
	    thread2.join();
	System.out.println("Einde: "+p.getAantalBezet()+" bezet"); 
	}
}
