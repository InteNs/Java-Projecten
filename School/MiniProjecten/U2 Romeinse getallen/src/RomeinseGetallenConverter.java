
public class RomeinseGetallenConverter
{
	private String[] tekens = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"  };
	private int[] getallen =  new int[]   { 1 , 4  , 5 ,  9 , 10, 40 , 50, 90 ,100,400 ,500 , 900,1000};
	
	/**
	 * De constructor. Loopt door de getallen 0 t/m 1500 en print het romeinse getal. Vertaal het romeinse getal terug 
	 * naar decimaal en print dat ook. Als het vertaalde decimale getal ongelijk is aan het oorspronkelijke getal,
	 * print het een foutmelding.
	 */
	public RomeinseGetallenConverter()
	{
		for(int i=0;i<1501;i++)
		{
			String romeins = naarRomeins(i);
			System.out.println(""+i+" in het romeins is "+romeins+" en dat is als decimaal "+naarDecimaal(romeins));
			if(i != naarDecimaal(romeins))
			{
				System.out.println("HIER KLOPT NIKS VAN! ------------------------");
			}
		}
		try
		{
			naarDecimaal("Grote onzin");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	/**
	 * Vertaalt romeins getal naar een decimaal getal.
	 * 
	 * @param romeins
	 * @return
	 */
	private int naarDecimaal(String romeins)
	{
		int getal = 0;
		for(int i=0;i<romeins.length();i++) //loop door alle tekens in de String romeins
		{
			String letter = romeins.substring(i, i+1); //neem het i'de teken
			boolean onzin = true;
			for(int j=0;j<tekens.length;j++) //loop door de array tekens
			{
				if(letter.equals(tekens[j])) //als het teken gelijk is aan het teken in de array
				{
					onzin = false; //er moet geen foutmelding komen
					getal += getallen[j]; //tel de waarde van dit teken op bij het totaal
					break;
				}
			}
			if(onzin)
			{
				throw new IllegalArgumentException(romeins+" is geen romeins teken!");
			}
		}
		//compenseer voor speciale gevallen
		if(romeins.contains("IV"))
		{
			getal -= 2;
		}
		if(romeins.contains("IX"))
		{
			getal -= 2;
		}
		if(romeins.contains("XL"))
		{
			getal -= 20;
		}
		if(romeins.contains("XC"))
		{
			getal -= 20;
		}
		if(romeins.contains("CD"))
		{
			getal -= 200;
		}
		if(romeins.contains("CM"))
		{
			getal -= 200;
		}
		return getal;
	}

	/**
	 * Vertaald een decimaal getal naar een romeins getal
	 * De functie loopt door de lijst van romeinse tekens, en plaats ieder teken zo vaak als de waarde
	 * van dat teken in het voorlopige getal past. Dan wordt de waarde van de geplaatste tekens van het voorlopige 
	 * getal afgetrokken.
	 * @param het decimale getal
	 * @return het romeinse getal
	 */
	private String naarRomeins(int getal)
	{
		String result = "";
		for(int i=tekens.length-1;i>=0;i--) 
		{
			int aantalKeer = getal/getallen[i];  
			for(int j=0;j<aantalKeer;j++)		
			{
				if(j>=aantalKeer) 
				{
					break;
				}
				result += tekens[i]; 
				getal -= getallen[i]; 
			}
		}
		return result;
	}

	/**
	 * Maakt een instantie van RomeinseGetallenConverter
	 * @param args
	 */
	public static void main(String[] args)
	{
		new RomeinseGetallenConverter();
	}
}
