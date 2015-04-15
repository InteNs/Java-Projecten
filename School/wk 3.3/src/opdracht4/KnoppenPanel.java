package opdracht4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class KnoppenPanel extends HBox implements EventHandler<ActionEvent> {
	private Uithangbord bord;
	private Button open,close;
	@Override
	public void handle(ActionEvent event) {
		System.out.println("event");
		if(event.getSource() == open){
			System.out.println("open");
			bord.maakOpen();
			open.setDisable(true);
			close.setDisable(false);
		}
		if(event.getSource() == close){
			System.out.println("close");
			bord.maakGesloten();
			open.setDisable(false);
			close.setDisable(true);
		}
		
	}
	public KnoppenPanel(Uithangbord bord){
		super();
		close  = new Button("sluiten");  	
		open = new Button("openen");
		this.getChildren().addAll(open, close);
		this.setAlignment(Pos.CENTER);
		this.setMinWidth(200);
		this.setSpacing(10);
		this.bord = bord;

		open.setOnAction(this);

		close.setOnAction(this);
		EventHandler<MouseEvent> mh = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				int aantal = event.getClickCount();
				if(aantal == 1) KnoppenPanel.this.setStyle("-fx-background-color: lightgray;");
				if(aantal == 2) KnoppenPanel.this.setStyle("-fx-background-color: orange;");
				if(aantal == 3) KnoppenPanel.this.setStyle("-fx-background-color: cyan;");
					
			}

		};
		this.setOnMouseClicked(mh);
	}
}
