package opdracht3a;

public class KomenThread extends Thread {
	private Parkeerterrein naar;

	public KomenThread(Parkeerterrein naar) {
		this.naar = naar;
	}

	public void run() {
			for (int i = 0; i < 100; i++) {
				if (i == 90) {
					try {
						sleep(800);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				System.out.println("erbij doen...");
				naar.autoErbij();
				System.out.println(naar.getAantalBezet());
				try {
					sleep(2);
				} catch (InterruptedException e) {
				}
			}
	}
}
