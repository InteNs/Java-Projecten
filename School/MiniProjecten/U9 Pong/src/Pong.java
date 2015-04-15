import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Pong extends AnimationPanel
{
	private Paddle p1, p2;
	private Ball b;
	private int score1, score2;
	
	public Pong()
	{
		super(16);
		p1 = new Paddle(50, getHeight()/2, KeyEvent.VK_W, KeyEvent.VK_S);
		addKeyListener(p1);
		p2 = new Paddle(getWidth()-50, getHeight()/2, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
		addKeyListener(p2);
		b = new Ball(getWidth()/2, getHeight()/2, 3, Math.random()*6-3);
	}

	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.WHITE);
		for(int y=0;y<getHeight();y+=40)
		{
			g.fillRect(getWidth()/2-5, y+10, 10, 20);
		}
		p1.paint(g);
		p2.paint(g);
		b.paint(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("monospace", Font.BOLD, 40));
		g.drawString(""+score1, getWidth()/2-12-25*(""+score1).length(), 45);
		g.drawString(""+score2, getWidth()/2+12, 45);
	}
	
	public void update()
	{
		p1.update();
		if(p1.getY() < 0)
		{
			p1.setY(getHeight());
		}
		if(p1.getY() > getHeight())
		{
			p1.setY(0);
		}
		p2.update();
		if(p2.getY() < 0)
		{
			p2.setY(getHeight());
		}
		if(p2.getY() > getHeight())
		{
			p2.setY(0);
		}
		b.update();
		p1.checkCollision(b);
		p2.checkCollision(b);
		
		if(b.getY() < 5) {
			
			b.setDy(-b.getDy());
		}
		
		if(b.getY() > getHeight()-5) {
			
			b.setDy(-b.getDy());
		}
		
		if(b.getX() < -5) {
			b = new Ball(getWidth()/2, getHeight()/2, 3, Math.random()*6-3);
			score2++;
		}
		
		if(b.getX() > getWidth()+5) {
			b = new Ball(getWidth()/2, getHeight()/2, -3, Math.random()*6-3);
			score1++;
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		p1.keyPressed(e);
		p2.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e)
	{
		p1.keyReleased(e);
		p2.keyReleased(e);
	}
}
