package opdracht2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MyStage extends Application {
	private Uithangbord bord;
	private Button open,close;
	private KnoppenPanel knoppenpanel;
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		bord = new Uithangbord();
		bord.setAlignment(Pos.CENTER);
		close  = new Button("sluiten");  	
		open = new Button("openen");
		knoppenpanel = new KnoppenPanel(bord, open, close);		
		knoppenpanel.getChildren().addAll(open, close);
		knoppenpanel.setAlignment(Pos.CENTER);
		knoppenpanel.setMinWidth(200);
		knoppenpanel.setSpacing(10);
		FlowPane flowpane = new FlowPane();
		flowpane.getChildren().addAll(bord,knoppenpanel);
		stage.setScene(new Scene(flowpane, 200, 125));
		stage.setResizable(false);
		stage.show();
	}
}
