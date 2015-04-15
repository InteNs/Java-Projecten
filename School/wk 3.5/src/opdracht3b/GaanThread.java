package opdracht3b;

public class GaanThread implements Runnable {
	private Parkeerterrein naar;
	public GaanThread(Parkeerterrein naar) {
		this.naar = naar;
	}
	public void run(){

		for (int i = 0; i < 100; i++) {
			naar.autoEraf();
			System.out.println(naar.getAantalBezet());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}

		
	}
}
