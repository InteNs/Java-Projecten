package opdracht2;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DamspelApp extends Application implements EventHandler<ActionEvent> {
	private Damspel spel = new Damspel();
	private Stage stage;
	private Image image = new Image("oma.jpg");
	private ImageView oma;
	private String currentPlayer, newPlayer;
	private Label rotationLabel, confirmLabel,playerLabel,countBlackLabel,countWhiteLabel,notificationLabel;
	private Button firstButton, secondButton, resetButton;
	private ToggleButton bigField;
	private int amountBlack,amountWhite;
	private boolean selected = false, confirm = false;
	private GridPane gridpane;
	private RotateTransition rotation;
	private CheckBox rotationCheck,confirmCheck;
	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		//create playfield
		gridpane = new GridPane();
		for (int row = 0; row <10; row++){
			for (int col = 0; col <10; col++){
				Button btn = new Button();
				btn.setId(""+(col*10 +row));
				btn.getStyleClass().add(spel.getVeldStatus(col*10 +row));
				btn.setPrefSize(40, 40);	
				btn.setOnAction(this);
				gridpane.add(btn, row, col);
			}
		}
		//field rotation
		rotation = new RotateTransition(Duration.millis(500), gridpane);
		rotation.setByAngle(180);
		//creating menu
		VBox menu = new VBox();	
		menu.setPadding(new Insets(5));
		menu.setSpacing(5);
		resetButton = new Button("Reset");				
		resetButton.setPrefWidth(120);
		resetButton.setOnAction(this);
		//fieldrotation option
		HBox menuRotate = new HBox();								
		rotationCheck = new CheckBox();								
		rotationLabel = new Label("Rotate field");						
		menuRotate.getChildren().addAll(rotationCheck,rotationLabel);
		//confirmation option
		HBox menuConfirm = new HBox();								
		confirmCheck = new CheckBox();								
		confirmLabel = new Label("Confirm moves");					
		menuConfirm.getChildren().addAll(confirmCheck,confirmLabel);
		//label for current player
		playerLabel = new Label();									
		playerLabel.textProperty().bind(Bindings.concat("Player: ").concat(spel.getSpelerProperty()));
		//label for amount of black pieces left
		amountBlack = 20;
		countBlackLabel = new Label("Pieces Black: "+amountBlack);									
		//label for amount of white pieces left
		amountWhite = 20;
		countWhiteLabel= new Label("Pieces White: "+amountWhite);	
		//button to enlarge field
		bigField = new ToggleButton("Big field");
		bigField.setOnAction(this);
		//image
		oma = new ImageView();
		//add everything to menu
		menu.getChildren().addAll(resetButton,menuRotate, menuConfirm,playerLabel,countBlackLabel,countWhiteLabel,bigField,oma);
		//label to show game notifications
		notificationLabel = new Label();
		notificationLabel.textProperty().bind(spel.getMeldingProperty());
		notificationLabel.setPadding(new Insets(5));
		//add everything to window
		BorderPane borderpane = new BorderPane();
		borderpane.setPadding(new Insets(10));
		borderpane.setTop(notificationLabel);
		BorderPane.setAlignment(notificationLabel, Pos.TOP_RIGHT);
		borderpane.setCenter(gridpane);
		borderpane.setLeft(menu);
		Scene scene = new Scene(borderpane);
		scene.getStylesheets().add("style.css");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.setTitle("Damspel");
		stage.setResizable(false);
		stage.show();
	}	
	/**
	 * @param btn Button object
	 * @return int returns the Button ID in an integer
	 */
	public int getId(Button btn){
		if(btn != null) return Integer.parseInt(btn.getId());
		else return -1;
	}
	@Override
	public void handle(ActionEvent e) {
		//reset
		if(e.getSource()== resetButton){
			spel.reset();
			amountBlack = 20;
			amountWhite = 20;
			updateMore();
			
		}
		//make field bigger
		if(e.getSource()==bigField){
			//if(bigField.isSelected())oma.setImage(image);
			//else 						oma.setImage(null);
			for(Node n : gridpane.getChildren()){
				Button btn = (Button)n;
				if(bigField.isSelected())btn.setPrefSize(60, 60);							
				else 						btn.setPrefSize(40, 40);
			}
			stage.sizeToScene();
		}
		//handle the turn
		else{
			//if the first field is pressed 
			if(firstButton == null){
				firstButton = (Button) e.getSource();
				//if the first field is playable
				if(spel.isVeldSpeelbaar(getId(firstButton))){
					selected = true;
					update();
				}
				//if the first field is not playable
				else{
					update();
					firstButton = null;
				}
			}
			//if confirmation has been canceled
			else if(confirmCheck.isSelected()== true && confirm && e.getSource() == firstButton){
				newPlayer = spel.getSpeler();
				updateMore();
			}
			//if the second field is clicked and is different than the first one
			else if(e.getSource() != firstButton){
				secondButton = (Button) e.getSource();
				currentPlayer = spel.getSpeler();
				//if the turn has been confirmed
				if(confirm && e.getSource() == secondButton){
					spel.doeZet(getId(firstButton), getId(secondButton));	
					newPlayer = spel.getSpeler();
					updateMore();
					updateScore();
				}
				//if confirmations are enabled
				else if(confirmCheck.isSelected()== true&& e.getSource() != firstButton){
					//if the turn is possible
					if(spel.isZetMogelijk(getId(firstButton), getId(secondButton))){						
						confirm = true;
						update();
					}	
				}
				//if confirmations are disabled
				else if(spel.doeZet(getId(firstButton), getId(secondButton))){
					newPlayer = spel.getSpeler();
					updateMore();
					updateScore();
				}
				else{
					update();
					secondButton = null;
				}
			}
			//if the first button has been deselected  
			else {
				newPlayer = spel.getSpeler();
				updateMore();
			}
		}
	}
	/**
	 * playfield will rotate if checkbox is checked and a new player has a turn
	 */
	private void rotate(){
		if(rotationCheck.isSelected() == true && newPlayer != currentPlayer) rotation.play();
	}
	/**
	 * call this when all parameters should be reset after an action
	 */
	private void updateScore(){
		//pieces left will be updatet
		amountBlack = 0;
		amountWhite = 0;
		for(Node n : gridpane.getChildren()){
			if(spel.getVeldStatus(getId((Button) n)) == "ZWART") 		amountBlack ++;
			if(spel.getVeldStatus(getId((Button) n)) == "ZWARTDAM") 	amountBlack ++;
			if(spel.getVeldStatus(getId((Button) n)) == "WIT")			amountWhite ++;	
			if(spel.getVeldStatus(getId((Button) n)) == "WITDAM")		amountWhite ++;	
		}
		countBlackLabel.setText("stenen Zwart: "+amountBlack);
		countWhiteLabel.setText("stenen Wit:   "+amountWhite);
	}
	private void updateMore(){
		selected = false;
		confirm = false;
		update();
		rotate();
		firstButton = null;
		secondButton = null;
	}
	/**
	 * call this if updateMore does not work
	 */
	private void update(){
		//update styleclass for selected button
		if(firstButton !=null){
			if(selected){
				firstButton.getStyleClass().removeAll("AANGEKLIKT");
				firstButton.getStyleClass().add("AANGEKLIKT");
			}
			else firstButton.getStyleClass().removeAll("AANGEKLIKT");
		}
		//update styleclass for confirmation
		if(secondButton != null){
			if(confirm){
				secondButton.getStyleClass().removeAll("BEVESTIG");
				secondButton.getStyleClass().add("BEVESTIG");
			}
			else secondButton.getStyleClass().removeAll("BEVESTIG");
		}
		//update all the field states
		for(Node n : gridpane.getChildren()){
			n.getStyleClass().clear();
			n.getStyleClass().add(spel.getVeldStatus(getId((Button) n)));
			if(confirm)secondButton.getStyleClass().add("BEVESTIG");
			if(selected)firstButton.getStyleClass().add("AANGEKLIKT");
		}
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
