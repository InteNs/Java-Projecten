package opdracht1b;

public class MyRunnable implements Runnable {
	private int getal;
	
	public MyRunnable(int getal){
		this.getal = getal;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			getal += 2;
			System.out.println(getal);
		}
		
	}

}
