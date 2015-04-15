package opd1;
class Zwembad
{
  private double breedte;
  private double lengte;
  private double diepte;

  public Zwembad(double B, double L, double D)
  {
      breedte = B;
      lengte = L;
      diepte = D;
  }
  public Zwembad()
  {
  }

  //getters:
  public double getBreedte()
  {
      return breedte;
  }
  public double getLengte()
  {
      return lengte;
  }
  public double getDiepte()
  {
      return diepte;
  }
  public double inhoud()
  {
	  return lengte * breedte * diepte;
  }
  //setters:
  public void setBreedte(double nwB)
  {
	  breedte = nwB;
  }
  public void setLengte(double nwL)
  {
	  lengte = nwL;
  }
  public void setDiepte(double nwD)
  {
	  diepte = nwD;
  }
  //commands:
  public String toString()
  {
	  String s = "dit zwembad is" + breedte + "meter breedt, " + lengte + "meter lang, en " + diepte + "meter diep";
      return s;
  }
}