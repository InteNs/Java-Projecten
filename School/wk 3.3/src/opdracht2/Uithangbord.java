package opdracht2;

import javafx.geometry.Pos; import javafx.scene.control.Label;
import javafx.scene.text.Font; import javafx.scene.text.FontPosture;

public class Uithangbord extends Label {
	public Uithangbord() {
		super("Maak Uw Keuze"); setAlignment(Pos.CENTER);
		setPrefSize(200, 80);
		setFont(Font.font("Serif", FontPosture.ITALIC, 24));
		setStyle("-fx-background-color: white;");
	}
	public void maakOpen() {
		setStyle("-fx-background-color: white; -fx-text-fill: green;");
		setText("Open");
	}
	public void maakGesloten() {
		setStyle("-fx-background-color: white; -fx-text-fill: red;");
		setText("Gesloten");
	}
}
