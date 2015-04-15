package opd1;

class Klant {
   private String naam;
   private String adres;
   private String plaats;

   public Klant(String nm, String adr, String pl) {
     naam = nm;
	 adres = adr;
	 plaats = pl;
   }
//getters
public String getNaam() {
	return naam;
}

public String getAdres() {
	return adres;
}

public String getPlaats() {
	return plaats;
}

//setters
public void setAdres(String nwAdr) {
	adres = nwAdr;
}

public void setPlaats(String nwPl) {
	plaats = nwPl;
}

public String toString() {
	String s = naam + " woont op " + adres + " in " + plaats;
	return s;
}
}