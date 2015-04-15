package opd3alt;

import java.util.*;
import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Shapes extends JPanel {
	private ArrayList<Rectangle> listOfRectangles = new ArrayList<Rectangle>();
	private Graphics g;
	public void addRectangle(Point2D p, Size2D s) {
		listOfRectangles.add(new Rectangle(p.getX(), p.getY(), s.getWidth(), s.getHeight()));
	}
	/*
	protected void paintComponent(Graphics g) {
		//super.paintComponent(g);
		g2 = (Graphics2D) g;
		for (Rectangle rect : listOfRectangles) {
			g2.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
	}
	*/
	public Graphics getGraphics(JPanel parent) {
		g = parent.getGraphics();
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 600, 600);
		for (int i = 0; i < listOfRectangles.size(); i++) {
			g.setColor(Color.RED);
			g.drawRect(listOfRectangles.get(i).x, listOfRectangles.get(i).y, listOfRectangles.get(i).width, listOfRectangles.get(i).height);
			//g.fillRect(listOfRectangles.get(i).x, listOfRectangles.get(i).y, listOfRectangles.get(i).width, listOfRectangles.get(i).height);
		}
		return g;
	}
}