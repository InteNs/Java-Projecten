import java.util.HashMap;

public class Frequentietabel {
	public void drukFrequentieTabelAf(String tekst) {
		//verwijder leestekens
		tekst = tekst.replace(",", "");
		tekst = tekst.replace(".", "");
		tekst = tekst.replace("!", "");
		tekst = tekst.replace("?", "");
		tekst = tekst.replace(";", "");
		//krijg een lijst van alle woorden
		String[] woorden = tekst.split(" ");
		
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		
		//loop langs alle woorden 
		for (String woord : woorden) {
			woord = woord.toLowerCase(); //maak van het woord kleine letters
			h.put(woord, h.getOrDefault(woord, 0) + 1); //hoog het aantal keer van dat het woord voorkomt met 1 op
		}
		System.out.println("Output:");
		String[] regels = h.toString().split(", ");
		for(String s: regels)
		{
			System.out.println(s.replace("{", "").replace("}", "").replace("=", ": ")+" keer");
		}
	}

	public static void main(String[] args) {
		Frequentietabel tabel = new Frequentietabel();
		tabel.drukFrequentieTabelAf("Een kapsalon bestaat uit patat, frikandellen, mayo en saus, en een catamaran uit patat, frikandellen, mayo en saus. Yes! Catamaran! No! Kapsalon!");
	}
}
