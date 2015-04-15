import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Paddle implements KeyListener
{
	private int x, y;
	private final static int WIDTH = 10;
	private final static int HEIGHT = 60;
	private int keyUp, keyDown;
	private boolean upDown, downDown;
	
	public Paddle(int x, int y, int keyUp, int keyDown)
	{
		super();
		this.x = x;
		this.y = y;
		this.keyUp = keyUp;
		this.keyDown = keyDown;
		upDown = false;
		downDown = false;
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(x-WIDTH/2, y-HEIGHT/2, WIDTH, HEIGHT);
	}

	public void update()
	{
		if(upDown)
		{
			y -= 5;
		}
		if(downDown)
		{
			y += 5;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == keyUp)
		{
			upDown = true;
		}
		else if(e.getKeyCode() == keyDown)
		{
			downDown = true;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == keyUp)
		{
			upDown = false;
		}
		else if(e.getKeyCode() == keyDown)
		{
			downDown = false;
		}
	}

	public void checkCollision(Ball b)
	{
		if(b.getX()+5 > x-WIDTH/2 && b.getX()-5 < x+WIDTH/2 && b.getY()+5 > y-HEIGHT/2 && b.getY()-5 < y+HEIGHT/2)
		{
			b.setDx(-b.getDx()*1.1);
			b.setDy((b.getY()-getY())/10);
		}
	}
}
