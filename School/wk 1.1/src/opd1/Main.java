package opd1;

public class Main
{
  public static void main(String[] args)
  {
    Klant k1 = new Klant("Jan", "Nijenoord 1", "Utrecht");
    k1.setAdres("Vreeburg 38");
    System.out.println("klant nr 1:" + k1.toString());
    Klant k2 = new Klant("Wim", "Oudenoord 340", "Utrecht");
    k2.setPlaats("Amsterdam");
    System.out.println("klant nr 2:" + k2.toString());
  }
}