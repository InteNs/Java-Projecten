package opd1;

public class Main {
	public static void main(String[] args) {
		ScooterLening sl1 = new ScooterLening("Aprilia", 30, 79.00);
		sl1.setAanBetaling(499.00);
		System.out.println(sl1.toString());
		for (int i = 0 ; i < 9 ; i++) {
			sl1.verwerkMaandBetaling();
		}
		System.out.println(sl1);
		System.out.println("Voor deze scooter is " + sl1.getAanBetaling() + " aanbetaald");
		System.out.println("Tot nu toe is " + sl1.totNuToeBetaald() + " betaald\n");

		ScooterLening sl2 = new ScooterLening("Yamaha", 24, 49.00);
		for (int i = 0 ; i < 15 ; i++) {
			sl2.verwerkMaandBetaling();
		}
		sl2.setAanBetaling(399.00);
		System.out.println(sl2);
	}
}
