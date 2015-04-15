package opd2;

public class Main {

	public static void main(String[] args) {
		Voetbalclub ajx = new Voetbalclub("ajax       ");
		System.out.println(ajx);
		Voetbalclub feij = new Voetbalclub("Feijenoord");
		feij.verwerkResultaat ('w');
		feij.verwerkResultaat ('w');
		feij.verwerkResultaat ('w');
		feij.verwerkResultaat ('g');
		System.out.println(feij);
	}
}
