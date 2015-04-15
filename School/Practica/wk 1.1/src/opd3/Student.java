package opd3;


public class Student
{
  private String naam;
  private int studentNummer;
  public Student( String nm)
    {  naam = nm;
    }
  public Student( String nm,int nb )
    {
      naam = nm;
      studentNummer = nb;
    }
  public String getNaam( )
    {
      return naam;
    }
  public int getStudentNummer( )
    {
	  return studentNummer;
    }
  public void setStudentNummer(int nwnb)
    {
	  studentNummer = nwnb;
    }
  public String toString( )
    {
      String s = "Deze student heet " + naam + " en heeft als nummer: " + studentNummer;
      return s;
    }
}