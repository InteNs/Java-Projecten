import java.util.Scanner;


public class Stringroteerder {
	//rotatie van 1 naar links
	public String roteerNaarLinks(String invoer) {
		return roteer(invoer, -1);
	}
	//rotatie van getal invoer naar links
	public String roteerNaarLinks(String invoer, int aantal) {
		return roteer(invoer, -aantal);
	}
	//rotatie van 1 naar rechts
	public String roteerNaarRechts(String invoer) {
		return roteer(invoer, 1);
	}
	//rotatie van getal invoer naar rechts
	public String roteerNaarRechts(String invoer, int aantal) {
		return roteer(invoer, aantal);
	}
	//afhankelijk van het aantal gaat hij naar links (negatief getal) of naar rechts (positief getal)
	public String roteer(String invoer, int aantal)
	{
		String result = "";
		//loop door alle tekens van de invoer 
		//i is het getal van het character
		for(int i = 0; i < invoer.length(); i++) {
			//krijg de positie van het teken
			//pos is de positie van het character
			int pos = i-aantal;
			//zorg dat de positie tussen 0 en lengte van de invoer is
			while(pos < 0)
			{
				pos += invoer.length();
			}
			pos = pos%invoer.length();
			//voeg het teken op de positie toe
			result += invoer.charAt(pos);
		}
		return result;
	}
	//lees de invoer
	public static void main(String[] args) {
		Stringroteerder st = new Stringroteerder();
		Scanner s = new Scanner(System.in);
		String text = s.nextLine();
		s.close();
		//testvoorbeelden
		System.out.println("string \""+text+"\" wordt na roteren over een positie naar links: \"" +st.roteerNaarLinks(text)+ "\"");
		System.out.println("string \""+text+"\" wordt na roteren over drie posities naar links: \"" +st.roteerNaarLinks(text, 3)+ "\"");
		System.out.println("string \""+text+"\" wordt na roteren over een positie naar rechts: \"" +st.roteerNaarRechts(text)+ "\"");
		System.out.println("string \""+text+"\" wordt na roteren over drie posities naar rechts: \"" +st.roteerNaarRechts(text, 3)+ "\"");
		System.out.println("string \""+text+"\" wordt na roteren over 25 posities naar links: \"" +st.roteerNaarLinks(text, 25)+ "\"");
		
	}
}
