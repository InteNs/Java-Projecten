package opdracht1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class LintBox extends HBox {
	private ColorPicker colorPicker = new ColorPicker();
	private Rectangle preview = new Rectangle(100, 25, Color.WHITE);
	private Paint[] colors = new Paint[] {Color.BLACK,Color.WHITE,Color.YELLOW,Color.RED,Color.GREEN,Color.BROWN,Color.BLUE,Color.PINK,Color.GRAY,Color.ORANGE} ;
	private VBox vBox = new VBox();
	private TilePane tilePane = new TilePane(5,5);
	private TilePane togglePane = new TilePane(10,10);
	private RadioButton line,circ,rect,free;
	private ToggleGroup toggleGroup = new ToggleGroup();
	public enum drawMode{LINE,CIRC,RECT,FREE};
	
	public LintBox(){
		for (Paint color : colors) {
			Rectangle shortCut = new Rectangle(17,17,color);
			tilePane.getChildren().add(shortCut);
			shortCut.setOnMousePressed(click ->{
				colorPicker.setValue((Color) color);
				preview.setFill(getColor());
			});
		}
		line = new RadioButton("line");
		circ = new RadioButton("circel");
		rect = new RadioButton("rectangle");
		free = new RadioButton("freedrawing");
		toggleGroup.getToggles().addAll(line,circ,rect,free);
		togglePane.setPrefColumns(2);
		togglePane.getChildren().addAll(line,circ,rect,free);
		togglePane.setAlignment(Pos.BASELINE_LEFT);
		tilePane.setPadding(new Insets(5));
		colorPicker.setPrefWidth(100);
		this.setAlignment(Pos.CENTER_LEFT);
		this.setPadding(new Insets(5));
		this.setStyle("-fx-border-color: gray; -fx-border-style: dotted;");
		vBox.getChildren().addAll(colorPicker,preview);
		this.getChildren().addAll(vBox,tilePane,togglePane);
		colorPicker.setOnAction(e ->
		preview.setFill(getColor()));
	}
	public Paint getColor() {
		return colorPicker.getValue();
	}
	public drawMode getDrawMode(){
		if (toggleGroup.getSelectedToggle()==line){return drawMode.LINE;}
		if (toggleGroup.getSelectedToggle()==circ){return drawMode.CIRC;}
		if (toggleGroup.getSelectedToggle()==rect){return drawMode.RECT;}
		if (toggleGroup.getSelectedToggle()==free){return drawMode.FREE;}
		else return null;
	}
}

