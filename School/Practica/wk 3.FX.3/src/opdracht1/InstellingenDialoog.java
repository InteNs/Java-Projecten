package opdracht1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InstellingenDialoog extends Stage{
	private double width,height;
	@SuppressWarnings("unused")
	private TextField heightTf, widthTf;
	public InstellingenDialoog(Stage owner, int w, int h){
		super(StageStyle.UTILITY);
		initOwner(owner);
		this.width = w;
		this.height = h;
		initModality(Modality.WINDOW_MODAL);
		this.setResizable(false);
		this.setTitle("instellingen");
		TextField heightTf = new TextField();
		TextField widthTf = new TextField();
		Label heightL = new Label("Hoogte");
		Label widthL = new Label("Breedte");
		heightTf.setText(Integer.toString(h));
		widthTf.setText(Integer.toString(w));
		Button confirm = new Button("Ok");
		confirm.setOnAction(e->{
			width = Double.parseDouble(widthTf.getText());
			height = Double.parseDouble(heightTf.getText());
			System.out.println(width + "-" + height);
			this.hide();
		});
		Button cancel = new Button("Annuleren");
		cancel.setOnAction(e->{
			this.hide();
		});
		Scene scene = new Scene(new VBox(10,new HBox(10,heightL,heightTf),new HBox(10,widthL,widthTf),new HBox(10,cancel,confirm)));
		this.setScene(scene);
		this.sizeToScene();
	}
	public double getinputWidth(){
		return this.width;
	}
	public double getinputHeight(){
		return this.height;
	}
}
