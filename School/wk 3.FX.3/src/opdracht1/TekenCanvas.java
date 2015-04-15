package opdracht1;

import java.util.Stack;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import opdracht1.LintBox.drawMode;

public class TekenCanvas extends Canvas {
	private GraphicsContext gc = this.getGraphicsContext2D();
	private double X ,Y;
	private Stack<WritableImage> undoStack = new Stack<WritableImage>();

	public TekenCanvas(LintBox lint, double width, double height) {
		super(width, height);
		ContextMenu contextmenu = new ContextMenu();
		MenuItem clear = new MenuItem("leegmaken");
		clear.setOnAction(e->{
			clearCanvas();
		});
		contextmenu.getItems().addAll(clear);
		clearCanvas();
		this.setOnMousePressed(pressed -> {
			if(pressed.getButton() == MouseButton.PRIMARY){
				contextmenu.hide();
				SnapshotParameters params = new SnapshotParameters();
				undoStack.push(this.snapshot(params, null));

				gc.setStroke(lint.getColor());
				gc.setFill(lint.getColor());
				if (lint.getDrawMode() == drawMode.FREE) {
					gc.beginPath();
				}
				if (lint.getDrawMode() == drawMode.RECT) {
					X = pressed.getX();
					Y = pressed.getY();
				}
				if (lint.getDrawMode() == drawMode.CIRC) {
					X = pressed.getX();
					Y = pressed.getY();
				}
				if (lint.getDrawMode() == drawMode.LINE) {
					X = pressed.getX();
					Y = pressed.getY();
				}
			}
			else contextmenu.show(this,pressed.getScreenX(),pressed.getScreenY());
		});
		this.setOnMouseDragged(dragged -> {
			if(dragged.getButton() == MouseButton.PRIMARY){
				if (lint.getDrawMode() == drawMode.FREE) {
					gc.lineTo(dragged.getX(), dragged.getY());
					gc.stroke();
				}
				if (lint.getDrawMode() == drawMode.RECT) {
					drawSnapshot(undoStack.peek());
					gc.strokeRect(Math.min(X,dragged.getX()),Math.min(Y, dragged.getY()),Math.abs(dragged.getX() - X), Math.abs(dragged.getY() - Y));
				}
				if (lint.getDrawMode() == drawMode.CIRC) {
					drawSnapshot(undoStack.peek());
					gc.strokeOval(Math.min(X,dragged.getX()),Math.min(Y, dragged.getY()),Math.abs(dragged.getX() - X), Math.abs(dragged.getY() - Y));
				}
				if (lint.getDrawMode() == drawMode.LINE) {
					drawSnapshot(undoStack.peek());
					gc.strokeLine(X, Y, dragged.getX(), dragged.getY());
				}
			}
		});
		this.setOnMouseReleased(released -> {
			if(released.getButton() == MouseButton.PRIMARY){
				if (lint.getDrawMode() == drawMode.FREE) {
					gc.closePath();
				}
				if (lint.getDrawMode() == drawMode.RECT) {
					gc.strokeRect(Math.min(X,released.getX()),Math.min(Y, released.getY()),Math.abs(released.getX() - X), Math.abs(released.getY() - Y));
				}
				if (lint.getDrawMode() == drawMode.CIRC) {
					gc.strokeOval(Math.min(X,released.getX()),Math.min(Y, released.getY()),Math.abs(released.getX() - X), Math.abs(released.getY() - Y));
				}
				if (lint.getDrawMode() == drawMode.LINE) {
					gc.strokeLine(X, Y, released.getX(), released.getY());
				}
			}
		});
	}
	private void drawSnapshot(WritableImage image){
		gc.clearRect(0, 0, this.getWidth(), this.getHeight());
		gc.drawImage(image, 0, 0);
	}
	public void clearCanvas(){
		gc.clearRect(0, 0, this.getWidth(), this.getHeight());
	}
	public void undo(){
		if(!undoStack.isEmpty())drawSnapshot(undoStack.pop());
	}
}
