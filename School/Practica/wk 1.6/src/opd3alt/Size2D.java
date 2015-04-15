package opd3alt;

public class Size2D {
	private int sWidth = 0;
	private int sHeight = 0;
	public Size2D(int width, int height) {
		this.sWidth = width;
		this.sHeight = height;
	}
	public Size2D getPoint() {
		return this;
	}
	public int getWidth() {
		return this.sWidth;
	}
	public int getHeight() {
		return this.sHeight;
	}
}
