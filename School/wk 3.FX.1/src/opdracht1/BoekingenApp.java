package opdracht1;

import java.time.LocalDate;
import java.util.Calendar;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BoekingenApp extends Application {
	private Hotel hotel;
	
	@Override
	public void start(Stage s) throws Exception {
		FlowPane f = new FlowPane();
		f.setPadding(new Insets(10));
		ObservableList<Node> l = f.getChildren();
		
		Scene scene = new Scene(f, 350,175);
		scene.getStylesheets().add("style.css");
		s.setScene(scene);
		
		Label label = new Label("Voer uw gegevens in!");
		label.setMinWidth(f.getWidth());
		l.add(label);		
		Label l1 = new Label("naam:");							l.add(l1);		l1.setMinWidth(f.getWidth()/3);
		TextField tf1 = new TextField();						l.add(tf1);		tf1.setMinWidth(f.getWidth()/3*2-20);
		Label l2 = new Label("adres:");							l.add(l2);		l2.setMinWidth(f.getWidth()/3);
		TextField tf2 = new TextField();						l.add(tf2);		tf2.setMinWidth(f.getWidth()/3*2-20);
		Label l3 = new Label("aankomstdatum:");					l.add(l3);		l3.setMinWidth(f.getWidth()/3);
		DatePicker dp1 = new DatePicker();						l.add(dp1);		dp1.setMinWidth(f.getWidth()/3*2-20);
		Label l4 = new Label("vertrekdatum:");					l.add(l4);		l4.setMinWidth(f.getWidth()/3);
		DatePicker dp2 = new DatePicker();						l.add(dp2);		dp2.setMinWidth(f.getWidth()/3*2-20);
		Label l5 = new Label("kamertype:");						l.add(l5);		l5.setMinWidth(f.getWidth()/3);
		ComboBox<KamerType> cb1 = new ComboBox<KamerType>();	l.add(cb1);		cb1.setMaxWidth(f.getWidth()/3*2-20);
		
		HBox hb1 = new HBox();
		hb1.setMinWidth(f.getWidth()-20);
		hb1.setAlignment(Pos.BASELINE_RIGHT);
		Button b1 = new Button("reset");						hb1.getChildren().add(b1);
		Button b2 = new Button("boek");							hb1.getChildren().add(b2);
		l.add(hb1);
		
		hotel = new Hotel();
		for(KamerType kt: hotel.geefAlleKamerTypen()) {
			cb1.getItems().add(kt);
		}
		dp1.setValue(calendarToLocalDate(Calendar.getInstance()));
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DAY_OF_YEAR, 1);
		dp2.setValue(calendarToLocalDate(c1));
		
		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				label.setText("Voer uw gegevens in!");
				tf1.setText("");
				tf1.getStyleClass().removeAll("error");
				tf2.getStyleClass().removeAll("error");
				tf2.setText("");
				dp1.getStyleClass().removeAll("error");
				dp1.setValue(calendarToLocalDate(Calendar.getInstance()));
				dp2.getStyleClass().removeAll("error");
				Calendar c1 = Calendar.getInstance();
				c1.add(Calendar.DAY_OF_YEAR, 1);
				dp2.setValue(calendarToLocalDate(c1));
				cb1.getStyleClass().removeAll("error");
				cb1.setValue(null);
			}
			
		});

		
		b2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				boolean gelukt = true;
				if(tf1.getText() == null || tf1.getText().trim().isEmpty()) {
					tf1.getStyleClass().add("error");
					label.setText("Vul een naam in!");
					gelukt = false;
				}
				else {
					tf1.getStyleClass().removeAll("error");
				}
				if(tf2.getText() == null || tf2.getText().trim().isEmpty()) {
					tf2.getStyleClass().add("error");
					label.setText("Vul een adres in!");
					gelukt = false;
				}
				else {
					tf2.getStyleClass().removeAll("error");
				}
				if(dp1.getValue().isBefore(LocalDate.now())) {
					dp1.getStyleClass().add("error");
					label.setText("De aankomstdatum is voor vandaag!");
					gelukt = false;
				}
				else {
					dp1.getStyleClass().removeAll("error");
				}
				if(dp2.getValue().isBefore(dp1.getValue())) {
					dp2.getStyleClass().add("error");
					label.setText("De vertrekdatum is voor de aankomstdatum!");
					gelukt = false;
				}
				else {
					dp2.getStyleClass().removeAll("error");
				}
				if(cb1.getValue() == null) {
					cb1.getStyleClass().add("error");
					label.setText("Vul een kamer type in!");
					gelukt = false;
				}
				else {
					cb1.getStyleClass().removeAll("error");
				}
				if(gelukt) {
					Boeking b = new Boeking(localDateToCalendar(dp1.getValue()), localDateToCalendar(dp2.getValue()));
					b.setAantalPersonen(1);
					b.setDeBoeker(new Klant(tf1.getText(), tf2.getText()));
					hotel.voegBoekingToe(b, cb1.getValue());
					b1.getOnAction().handle(null); //click de reset knop
					label.setText("Boeking succesvol!");
					System.out.println(hotel);
				}
			}
			
		});
		
		s.setTitle("Tweepersoonsboekingen");
		s.setResizable(false);
		s.show();

	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private Calendar localDateToCalendar(LocalDate d) {
		Calendar c = Calendar.getInstance();
		c.set(d.getYear(), d.getMonthValue()-1, d.getDayOfMonth());
		return c;
	}
	private LocalDate calendarToLocalDate(Calendar cal) {
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return LocalDate.of(year, month, day);
	}

}
