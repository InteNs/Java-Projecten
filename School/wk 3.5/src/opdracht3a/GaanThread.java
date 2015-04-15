package opdracht3a;

public class GaanThread extends Thread {
	private Parkeerterrein naar;
	public GaanThread(Parkeerterrein naar) {
		this.naar = naar;
	}
	public void run(){
		for (int i = 0; i < 100; i++) {
			naar.autoEraf();
			System.out.println(naar.getAantalBezet());
			try {
				sleep(10);
			} catch (InterruptedException e) {
			}
		}
	}
}
