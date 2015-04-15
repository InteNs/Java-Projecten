package opdracht1a;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		MyThread mt1 = new MyThread(0);
		MyThread mt2 = new MyThread(9);
		mt1.start();
		mt2.start();
		mt1.join();
		mt2.join();
		System.out.println("\neinde van de main-thread");
	}
}
