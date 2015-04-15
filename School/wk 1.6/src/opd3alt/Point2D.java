package opd3alt;

public class Point2D {
	private int pX = 0;
	private int pY = 0;
	public Point2D(int x, int y) {
		this.pX = x;
		this.pY = y;
	}
	public Point2D getPoint() {
		return this;
	}
	public int getX() {
		return this.pX;
	}
	public int getY() {
		return this.pY;
	}
}