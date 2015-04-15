package opdracht1a;

public class MyThread extends Thread {
	private int getal;
	public MyThread(int getal){
		this.getal = getal;
	}
	@Override
	public void run(){
		for (int i = 0; i < 10; i++) {
			getal += 2;
			System.out.println(getal);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
