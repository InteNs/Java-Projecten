package opdracht1b;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		MyRunnable mr1 = new MyRunnable(0);
		MyRunnable mr2 = new MyRunnable(9);
		mr1.run();
		mr2.run();
		System.out.println("\neinde van de main-thread");
	}
}
