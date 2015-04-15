package opdracht3b;

public class KomenThread implements Runnable {
	private Parkeerterrein naar;

	public KomenThread(Parkeerterrein naar) {
		this.naar = naar;
	}

	public void run() {
			for (int i = 0; i < 100; i++) {
				if (i == 10) {
					try {
						Thread.sleep(800);
					} catch (InterruptedException e1) {
					}
				}
				naar.autoErbij();
				System.out.println(naar.getAantalBezet());
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
				}

		}

	}

}
