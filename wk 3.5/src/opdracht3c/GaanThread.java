package opdracht3c;

public class GaanThread implements Runnable {
	private Parkeerterrein naar;
	public GaanThread(Parkeerterrein naar) {
		this.naar = naar;
	}
	public void run(){

		for (int i = 0; i < 100; i++) {
			try {

				naar.autoEraf();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(naar.getAantalBezet());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}

		
	}
}
