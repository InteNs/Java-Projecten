import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Player implements KeyListener {
	private int movingDir;
	private Color color;
	private int positionX, positionY;
	private int keyUp, keyRight, keyDown, keyLeft;
	private ArrayList<Point> trail;
	private final static int WIDTH = 20;
	private final static int HEIGHT = 20;

	public Player(int posX, int posY, int dir, Color col, int up, int right,
			int down, int left) {
		positionX = posX;
		positionY = posY;
		movingDir = dir;
		color = col;

		keyUp = up;
		keyRight = right;
		keyDown = down;
		keyLeft = left;

		trail = new ArrayList<Point>();
	}

	public void setMovingDir(int dir) {
		movingDir = dir;
	}

	public void move() {
		trail.add(new Point(positionX, positionY));
		// 0 = north
		int speed = 20;

		if (movingDir == 0) {
			positionY -= speed;
			// 1 = east
		} else if (movingDir == 1) {
			positionX += speed;
			// 2 = south
		} else if (movingDir == 2) {
			positionY += speed;
			// 3 = west
		} else if (movingDir == 3) {
			positionX -= speed;
		}

	}

	public boolean checkTrail(ArrayList<Point> t) {
		for (int i = 0; i < t.size(); i++) {
			Point p = t.get(i);
			if (positionX == p.x && positionY == p.y) {
				return true;
			}
		}
		return false;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public ArrayList<Point> getTrail() {
		return trail;
	}

	public void setTrail(ArrayList<Point> trail) {
		this.trail = trail;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(positionX - WIDTH / 2 + 3, positionY - HEIGHT / 2 + 3,
				WIDTH - 6, HEIGHT - 6);
		for (int i = 0; i < trail.size(); i++) {
			Point p = trail.get(i);
			g.fillRect(p.x - WIDTH / 2, p.y - HEIGHT / 2, WIDTH, HEIGHT);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == keyUp && movingDir != 2) {
			movingDir = 0;
		} else if (e.getKeyCode() == keyRight && movingDir != 3) {
			movingDir = 1;
		} else if (e.getKeyCode() == keyDown && movingDir != 0) {
			movingDir = 2;
		} else if (e.getKeyCode() == keyLeft && movingDir != 1) {
			movingDir = 3;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
