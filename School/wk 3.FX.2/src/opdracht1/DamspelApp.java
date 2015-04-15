package opdracht1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DamspelApp extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		
		GridPane gridpane = new GridPane();
		for (int row = 0; row <10; row++){
			for (int col = 0; col <10; col++){
				Button btn = new Button(""+(col*10 +row));
				btn.setId(""+(col*10 +row));
				btn.setPrefSize(40, 40);
				gridpane.add(btn, row, col);
			}
		}
		VBox menu = new VBox();	
		menu.setPadding(new Insets(5));
		menu.setSpacing(5);
		Button reset = new Button("Reset");			menu.getChildren().add(reset);
		reset.setPrefWidth(120);
		HBox rotatie = new HBox();					menu.getChildren().add(rotatie);
		CheckBox checkbox = new CheckBox();			rotatie.getChildren().add(checkbox);
		Label roteer = new Label("Bord roteren");	rotatie.getChildren().add(roteer);
		Label speler = new Label("speler: -");		menu.getChildren().add(speler);
		Label stenenZ= new Label("Stenen Z: -");	menu.getChildren().add(stenenZ);
		Label stenenW= new Label("Stenen W: -");	menu.getChildren().add(stenenW);
		
		
		Label info = new Label("meldingen komen hier!");
		info.setPadding(new Insets(5));
		BorderPane borderpane = new BorderPane();
		borderpane.setPadding(new Insets(10));
		borderpane.setTop(info);
		BorderPane.setAlignment(info, Pos.TOP_RIGHT);
		borderpane.setCenter(gridpane);
		borderpane.setLeft(menu);
		Scene scene = new Scene(borderpane, 510,420);
		scene.getStylesheets().add("style.css");
		stage.setScene(scene);
		stage.setTitle("Damspel");
		stage.setResizable(false);
		stage.show();
		
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
