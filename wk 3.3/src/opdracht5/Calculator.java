package opdracht5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application implements EventHandler<ActionEvent> {
	private Button[] buttons = new Button[16];
	private Label screen;
	private int first = 0, second = 0, result = 0;
	private String firstS = "", secondS = "";
	private boolean isFirst = true;
	private char operator;
	private GridPane gridpane;

	@Override
	public void start(Stage stage) throws Exception {
		EventHandler<MouseEvent> mh = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				for (Button b : buttons) {
					b.setStyle("");
				}
				Button button = (Button)event.getSource();
				if(button.getId() == "int")button.setStyle("-fx-background-color: white;");
				if(button.getId() == "op")button.setStyle("-fx-background-color: yellow;");
				if(button.getId() == "=")button.setStyle("-fx-background-color: pink;");
				if(button.getId() == "c")button.setStyle("-fx-background-color: green;");
				

			}

		};
		buttons[0] = new Button("7"); 	buttons[0].setId("int");
		buttons[1] = new Button("8");	buttons[1].setId("int");
		buttons[2] = new Button("9");	buttons[2].setId("int");
		buttons[3] = new Button("/");	buttons[3].setId("op");
		buttons[4] = new Button("4");	buttons[4].setId("int");
		buttons[5] = new Button("5");	buttons[5].setId("int");
		buttons[6] = new Button("6");	buttons[6].setId("int");
		buttons[7] = new Button("*");	buttons[7].setId("op");
		buttons[8] = new Button("1");	buttons[8].setId("int");
		buttons[9] = new Button("2");	buttons[9].setId("int");
		buttons[10] = new Button("3");	buttons[10].setId("int");
		buttons[11] = new Button("+");	buttons[11].setId("op");
		buttons[12] = new Button("c");	buttons[12].setId("c");
		buttons[13] = new Button("0");	buttons[13].setId("int");
		buttons[14] = new Button("=");	buttons[14].setId("=");
		buttons[15] = new Button("-");	buttons[15].setId("op");
		for (Button button : buttons) {
			button.setPrefSize(40, 40);
			button.setOnAction(this);
			button.setOnMouseClicked(mh);
			
		}
		gridpane = new GridPane();
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				gridpane.add(buttons[row*4 +col], col, row);
			}
		}
		
	
		screen = new Label();
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(screen);
		borderpane.setCenter(gridpane);
		BorderPane.setAlignment(screen, Pos.CENTER_RIGHT);
		Scene scene = new Scene(borderpane);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.setTitle("Calculator");
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void handle(ActionEvent event) {
		
		
		System.out.println(second);
		if(event.getSource() == buttons[12]){
			first = 0;
			second = 0;
			firstS = "";
			secondS = "";
			isFirst = true;
			operator = '0';
		}
		if (event.getSource() == buttons[0]){
			if(isFirst) firstS += "7";
			else secondS +="7";
		}
		if (event.getSource() == buttons[1]){
			if(isFirst) firstS += "8";
			else secondS +="8";
		}
		if (event.getSource() == buttons[2]){
			if(isFirst) firstS += "9";
			else secondS +="9";
		}
		if (event.getSource() == buttons[3]){
			operator = '/';
			isFirst = false;
		}
		if (event.getSource() == buttons[4]){
			if(isFirst) firstS += "4";
			else secondS +="4";
		}
		if (event.getSource() == buttons[5]){
			if(isFirst) firstS += "5";
			else secondS +="5";
		}
		if (event.getSource() == buttons[6]){
			if(isFirst) firstS += "6";
			else secondS +="6";
		}
		if (event.getSource() == buttons[7]){
			operator = '*';
			isFirst = false;
		}
		if (event.getSource() == buttons[8]){
			if(isFirst) firstS += "1";
			else secondS +="1";
		}
		if (event.getSource() == buttons[9]){
			if(isFirst) firstS += "2";
			else secondS +="2";
		}
		if (event.getSource() == buttons[10]){
			if(isFirst) firstS += "3";
			else secondS +="3";
		}
		if (event.getSource() == buttons[11]){
			operator = '+';
			isFirst = false;
		}
		if (event.getSource() == buttons[13]){
			if(isFirst) firstS += "0";
			else secondS +="0";
		}
		if (event.getSource() == buttons[14]){
			doMath();
			screen.setText(Integer.toString(result));
			firstS = ""+result;
			secondS = "";
		}
		if (event.getSource() == buttons[15]){
			operator = '-';
			isFirst = false;
		}
		if(isFirst && event.getSource() != buttons[14]) screen.setText(firstS);
		else if(!isFirst && event.getSource() != buttons[14]) screen.setText(secondS);
		
	}
	private void doMath(){
		try {
			first = Integer.parseInt(firstS);
			second = Integer.parseInt(secondS);
			if(operator == '/') result = first / second;
			if(operator == '*') result = first * second;
			if(operator == '-') result = first - second;
			if(operator == '+') result = first + second;
		} catch (NumberFormatException e) {
			System.out.println("Number was too high");
		}		
	}
}
