package opdracht1;

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

public class MyStage extends Application implements EventHandler<ActionEvent> {
	private Uithangbord bord;
	private Button open,close;
	public static void main(String[] args) {
		Application.launch(args);

	}
	@Override
	public void start(Stage stage) throws Exception {
		bord = new Uithangbord();
		bord.setAlignment(Pos.CENTER);
		HBox buttons = new HBox();
		buttons.setAlignment(Pos.CENTER);
		buttons.setMinWidth(200);
		buttons.setSpacing(10);
		close  = new Button("sluiten");  	close.setOnAction(this);
		open = new Button("openen");		open.setOnAction(this);
		buttons.getChildren().addAll(open, close);
		FlowPane flowpane = new FlowPane();
		flowpane.getChildren().addAll(bord,buttons);
		stage.setScene(new Scene(flowpane, 200, 125));
		stage.setResizable(false);
		stage.show();
		
	}
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == open){
			bord.maakOpen();
			open.setDisable(true);
			close.setDisable(false);
		}
		if(event.getSource() == close){
			bord.maakGesloten();
			open.setDisable(false);
			close.setDisable(true);
		}
	}

	

}
