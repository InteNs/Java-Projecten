package opdracht4;

public class KamerType {
	private String typeNaam;
	private int aantalBedden;
	private double prijsPerNacht;
	
	public KamerType(String typeNaam, int aantalBedden, double prijsPerNacht) {
		super();
		this.typeNaam = typeNaam;
		this.aantalBedden = aantalBedden;
		this.prijsPerNacht = prijsPerNacht;
	}

	@Override
	public String toString() {
		return typeNaam+" heeft "+aantalBedden+" bedden, en kost "+prijsPerNacht+" Euro";
	}

	public String getTypeNaam() {
		return typeNaam;
	}
	
	
}
