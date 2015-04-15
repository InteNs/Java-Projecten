import java.awt.Color;
import java.awt.Graphics;


public class Ball
{
	private double x, y, dx, dy;

	public Ball(double x, double y, double dx, double dy)
	{
		super();
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
	}
	
	public void update()
	{
		x += dx;
		y += dy;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval((int)x-5, (int)y-5, 10, 10);
	}
}
