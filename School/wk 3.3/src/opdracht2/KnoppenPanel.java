package opdracht2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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
	public KnoppenPanel(Uithangbord bord, Button open, Button close){
		super();
		this.bord = bord;
		this.open = open;
		open.setOnAction(this);
		this.close= close;
		close.setOnAction(this);
		
	}
	
}
