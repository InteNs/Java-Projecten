package opdracht2;

public class GelijkspelThread extends Thread {
	private Stand st;
	public GelijkspelThread(Stand st){
		this.st = st;
	}
	@Override
	public void run(){
		synchronized (st) {
			for (int i = 0; i < 2000000; i++) {
				st.voegPuntenToe(1);
			}
		}
	}
}
