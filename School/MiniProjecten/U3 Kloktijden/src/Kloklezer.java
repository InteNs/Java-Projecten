import java.util.Scanner;


public class Kloklezer {
	/**
	 * hier wordt de om te rekenen tijd ingevoerd en ingelezen
	 * @param args
	 */
	public static void main(String[] args) {
		Kloklezer k = new Kloklezer();
		Scanner s = new Scanner(System.in);
		System.out.println("Uren:");
		String uren = s.nextLine();
		System.out.println("Minuten:");
		String minuten = s.nextLine();
		try
		{
			System.out.println(k.leesTijd(Integer.parseInt(uren), Integer.parseInt(minuten))); //zet invoer om in getallen
		}
		catch(NumberFormatException e)					//check of er een getal is ingevuld
		{
			System.out.println("Dit is geen getal");
		}
		s.close();
	}
	
	public String leesTijd(int uren, int minuten) {
		if(uren < 1 || uren > 23)						//check if getal is geldige tijds
		{
			System.out.println("Uren is te hoog of te laag");
			return "";
		}
		if(minuten < 1 || minuten > 23)
		{
			System.out.println("Minuten is te hoog of te laag");
			return "";
		}
		int uurtijd = uren%12; 				// hier word het getal gedeeld door 12 en de rest in de uitkomst( 13/12 REST = 1)
		String result = readUur(uurtijd);
		if(minuten == 15)					// minuten omzetten in woorden
		{
			result = "kwart over "+result;
		}
		else if(minuten == 30)				//vanaf hier moet het uur een hoger want het is half 12 en niet half over 11
		{
			result = "half "+readUur((uurtijd+1)%12);
		}
		else if(minuten == 45)
		{
			result = "kwart voor "+readUur((uurtijd+1)%12);
		}
		else if (minuten != 0 || minuten != 15 || minuten != 30 || minuten != 45) {  //noobcheck
			 System.out.println("Dit progamma werkt alleen in kwartieren...");
		}
		return result;
	}
	
	public String readUur(int uren) {   	// uren omgezet in woorden
		switch(uren){
		case 0 : return "twaalf";
		case 1 : return "een";
		case 2 : return "twee";
		case 3 : return "drie";
		case 4 : return "vier";
		case 5 : return "vijf";
		case 6 : return "zes";
		case 7 : return "zeven";
		case 8 : return "acht";
		case 9 : return "negen";
		case 10 : return "tien";
		case 11 : return "elf";
		
		}
		return "";
	}

}
