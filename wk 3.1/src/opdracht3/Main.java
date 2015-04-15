package opdracht3;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		
		double[] cijfers = {9.8, 5.3, 6.2, 5.5, 5.4, 7.7, 8.1, 3.7, 1.8, 4.6};
		System.out.println("in de array staan de volgende "+cijfers.length+" cijfers:");
		double totaal = 0;
		int voldoendes = 0, onvoldoendes = 0;
		for(double c: cijfers){
			System.out.print(c+"\t");
			totaal += c;
			if(c<5.5)onvoldoendes++;
			else voldoendes++;
		}
		System.out.println();
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("het gemiddelde is: "+ df.format(totaal/cijfers.length));
		System.out.println("aantal voldoendes: "+ voldoendes);
		System.out.println("aantal onvoldoendes: "+ onvoldoendes);
		

	}

}
