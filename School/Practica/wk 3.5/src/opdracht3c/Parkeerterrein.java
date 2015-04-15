package opdracht3c;

public class Parkeerterrein {
	private int maxAantal, aantalBezet;
	public Parkeerterrein(int maxAantal){
		this.maxAantal = maxAantal;
	}
	public int getAantalBezet(){
		return aantalBezet;
	}
	public void setAantalBezet(int aantal){
		this.aantalBezet = aantal;
	}
	
	public synchronized void autoErbij() throws InterruptedException{
		
		while(aantalBezet >= maxAantal){
			System.out.println("wait-max");
			wait();
			
			
		}
		aantalBezet ++;
		notify();
	}
	public synchronized void autoEraf() throws InterruptedException {

		while(aantalBezet == 0){
			System.out.println("wait-min");
			wait();
			
		}		
		
		aantalBezet --;
		notify();
	}
}
