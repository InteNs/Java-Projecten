package opdracht2;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Stand st = new Stand(0);
		System.out.println("Beginstand is : " + st.getPunten());
		GelijkspelThread gt = new GelijkspelThread(st);
		WinnenThread wt = new WinnenThread(st);
		gt.start();
		wt.start();
		gt.join();
		wt.join();
		System.out.println("Eindstand is : " + st.getPunten());

	}
}
