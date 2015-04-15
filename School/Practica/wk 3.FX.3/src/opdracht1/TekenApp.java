package opdracht1;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

public class TekenApp extends Application {
	private TekenCanvas canvas;
	private BorderPane borderpane;
	private LintBox lint;
	private Stage stage;
	private File huidigeBestand = null;
	

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		MenuBar menubar = new MenuBar();
		Menu bestand = new Menu("_Bestand");
		Menu opties = new Menu("Opties");
		Menu bewerken = new Menu("Bewerken");
		MenuItem vorige = new MenuItem("Ongedaan maken");
		vorige.setOnAction(e->{
			canvas.undo();
		});
		vorige.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN));
		MenuItem nieuw = new MenuItem("_Nieuw");
		nieuw.setOnAction(e->{
			if(wijzigingenAfgehandeld()) newCanvas();
		});
		nieuw.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
		MenuItem opslaan = new MenuItem("Opslaan");
		opslaan.setOnAction(e->{
			afbeeldingOpslaan(false);
		});
		opslaan.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
		MenuItem opslaanals = new MenuItem("Opslaan als");
		opslaanals.setOnAction(e->{
			afbeeldingOpslaan(true);
		});
		MenuItem openen = new MenuItem("_Openen");
		openen.setOnAction(e->{
			if(wijzigingenAfgehandeld()){
				FileChooser fileChooser = new FileChooser();
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("pictures","*.png");
				fileChooser.getExtensionFilters().add(extFilter);
				fileChooser.setTitle("Open");
				File openFile = fileChooser.showOpenDialog(stage);
				huidigeBestand = openFile;
				URI uri = openFile.toURI();
			    Image afbeelding = new Image(uri.toString());
				borderpane.getChildren().remove(canvas);
				canvas = new TekenCanvas(lint,afbeelding.getWidth(), afbeelding.getHeight());
				borderpane.setCenter(canvas);
				stage.sizeToScene(); 
				canvas.getGraphicsContext2D().drawImage(afbeelding, 0, 0, afbeelding.getWidth(), afbeelding.getHeight());
			}
		});
		openen.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
		MenuItem instellingen = new MenuItem("Instellingen");
		instellingen.setOnAction(e->{
			InstellingenDialoog settings = new InstellingenDialoog(stage, ((int)canvas.getWidth()),((int)canvas.getHeight()));
			settings.showAndWait();
			canvas.setHeight(settings.getinputHeight());
			canvas.setWidth(settings.getinputWidth());
			stage.sizeToScene();
		});
		menubar.getMenus().addAll(bestand,opties,bewerken);
		opties.getItems().addAll(instellingen);
		bewerken.getItems().addAll(vorige);
		bestand.getItems().addAll(nieuw,opslaan,opslaanals,openen);
		borderpane = new BorderPane();
		Scene scene = new Scene(borderpane);
		lint = new LintBox();
		canvas = new TekenCanvas(lint,430, 300);
		borderpane.setTop(new VBox(menubar,lint));
		borderpane.setCenter(canvas);
		
		stage.setScene(scene);
		stage.sizeToScene();
		stage.setTitle("Paint");
		stage.setResizable(false);
		stage.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
	public void newCanvas(){
		borderpane.getChildren().remove(canvas);
		canvas = new TekenCanvas(lint,430, 300);
		borderpane.setCenter(canvas);
	}
	public boolean wijzigingenAfgehandeld(){
		BevestigingsDialoog confirm = new BevestigingsDialoog(stage, "Wilt u de wijzigingen opslaan?");
		confirm.showAndWait();
		switch(confirm.getKeuze()){
		case "cancel": 
			return false;
		case "no":
			return true;
		case "yes":
			afbeeldingOpslaan(false);
			return true;
		default: return false; 
		}
	}

	private boolean afbeeldingOpslaan(boolean dialoogAltijdTonen) {
		SnapshotParameters params = new SnapshotParameters();
		WritableImage img = canvas.snapshot(params, null);
		RenderedImage img2 = SwingFXUtils.fromFXImage(img, null);

		if (dialoogAltijdTonen || huidigeBestand == null) {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setSelectedExtensionFilter(new ExtensionFilter("afbeelding", "*.png"));
			fileChooser.setTitle("save");
			fileChooser.setInitialFileName("painting.png");
			File saveFile = fileChooser.showSaveDialog(stage);
			if (saveFile != null) {
				try {
					ImageIO.write(img2, "png", saveFile);
					huidigeBestand = saveFile;
					return true;
				} catch (IOException ex) {
					System.out.println(ex.getMessage());
					return false;
				}
			} else
				return false;
		} else {
			try {
				ImageIO.write(img2, "png", huidigeBestand);
				return true;
			} catch (IOException e) {
				System.out.println(e.getMessage());
				return false;
			}

		}
	}

}
