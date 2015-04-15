public class PalindroomDetector
{
	/**
	 * Constructor met alle strings waarvan we willen weten of het een palindroom is.
	 */
	public PalindroomDetector()
	{
		laatPalindroomZien("a");
		laatPalindroomZien("legovogel");
		laatPalindroomZien("test");
		laatPalindroomZien("meetsyteem");
		laatPalindroomZien("Madam I'm Adam");
		laatPalindroomZien("a man, a plan, a canal: panama!");
	}
	
	/**
	 * Print of een string een palindroom is of niet
	 * @param invoer
	 */
	private void laatPalindroomZien(String invoer)
	{
		System.out.println(invoer+": "+isPalindroom(invoer));
	}
	
	/**
	 * kijkt of de gegeven string een palindroom is
	 * @param invoer
	 * @return of de invoer een palindroom is
	 */
	public boolean isPalindroom(String invoer) 
	{	
		invoer = zetOm(invoer);
		
		String omgekeerd = new StringBuilder(invoer).reverse().toString();
		
		return omgekeerd.equals(invoer);
	}
	
	/**
	 * haalt de spaties uit een string, verwijdert leestekens en zet het om naar kleine letters
	 * @param invoer
	 * @return de verbeterde string
	 */
	private String zetOm(String invoer)
	{
		return invoer.toLowerCase()
					 .replace(" ", "")
					 .replace("'", "")
					 .replace(".", "")
					 .replace(",", "")
					 .replace("!", "")
					 .replace(":", "");
	}

	/**
	 * maakt een nieuwe palindroomdetector aan
	 * @param args
	 */
	public static void main(String[] args)
	{
		new PalindroomDetector();
	}
}
