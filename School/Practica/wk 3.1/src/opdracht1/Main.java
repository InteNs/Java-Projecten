package opdracht1;

public class Main {
	public static void main(String[] args) {
		Persoon p = new Persoon("Gerrit Hiemstra", 30000);
		Huis h = new Huis("Boslust 12", 800);
		Auto a = new Auto("BMW 3.18", "13-AA-42", 1100);
		System.out.println(p.toString()+ "\n");
		p.setHetHuis(h);
		System.out.println(p.toString()+ "\n");
		p.setDeAuto(a);
		System.out.println(p.toString()+ "\n");
	}
} 
