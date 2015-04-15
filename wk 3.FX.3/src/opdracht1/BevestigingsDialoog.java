package opdracht1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BevestigingsDialoog extends Stage {
	private String keuze;
	public BevestigingsDialoog(Stage owner, String message){
		initOwner(owner);
		Label messageL = new Label(message);
		Button cancel = new Button("Annuleren");
		cancel.setOnAction(e->{
			keuze = "cancel";
			this.hide();
		});
		Button no = new Button("Nee");
		no.setOnAction(e->{
			keuze = "no";
			this.hide();
		});
		Button yes = new Button("Ja");
		yes.setOnAction(e->{
			keuze = "yes";
			this.hide();
		});
		Scene scene = new Scene(new VBox(10,messageL,new HBox(10,cancel,no,yes)));
		this.setScene(scene);
		this.sizeToScene();
	}
	public String getKeuze(){
		return keuze;
	}
}
