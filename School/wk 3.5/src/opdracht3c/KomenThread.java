package opdracht3c;

public class KomenThread implements Runnable {
	private Parkeerterrein naar;

	public KomenThread(Parkeerterrein naar) {
		this.naar = naar;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i == 90) {
				try {
					Thread.sleep(800);
				} catch (InterruptedException e1) {
				}
			}
			try {

				naar.autoErbij();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(naar.getAantalBezet());
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
			}

		}

	}

}
