package opdracht1;

public class KamerType {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aantalBedden;
		long temp;
		temp = Double.doubleToLongBits(prijsPerNacht);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((typeNaam == null) ? 0 : typeNaam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KamerType other = (KamerType) obj;
		if (aantalBedden != other.aantalBedden)
			return false;
		if (Double.doubleToLongBits(prijsPerNacht) != Double
				.doubleToLongBits(other.prijsPerNacht))
			return false;
		if (typeNaam == null) {
			if (other.typeNaam != null)
				return false;
		} else if (!typeNaam.equals(other.typeNaam))
			return false;
		return true;
	}

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
