package opd2;

public class Student
{
  private String naam;
  
  public Student( String nm )
  {
    naam = nm;
  }
  public String getNaam( )
  {
    return naam;
  }
  
  public String toString( )
  {
    String s = "Deze student heet " + naam;
    return s; 
  }
}