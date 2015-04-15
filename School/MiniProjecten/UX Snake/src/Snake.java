import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Snake extends AnimationPanel {

	private Player player;
	private final static int GRIDSIZE = 20;
	private boolean gameover;
	private int fruitX, fruitY, score;
	
	public Snake() {
		super(100);
		startGame();
	}

	private void startGame() {
		player = new Player(10, 250, 1, Color.RED, KeyEvent.VK_UP, KeyEvent.VK_RIGHT,
				KeyEvent.VK_DOWN, KeyEvent.VK_LEFT);
		gameover = false;
		fruitX = (int)(Math.random()*(getWidth()-1)/GRIDSIZE)*GRIDSIZE;
		fruitY = (int)(Math.random()*(getHeight()-1)/GRIDSIZE)*GRIDSIZE;
		score = 0;
		setMs(100);
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.YELLOW);
		g.fillRect(fruitX, fruitY, GRIDSIZE, GRIDSIZE);

		player.paint(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 15)); 
		g.drawString("Score: "+score*100, 10, 20);
		if(gameover) {
			g.setColor(new Color(0, 0, 0, 100));
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.WHITE);
			g.setFont(new Font("Comic Sans MS", Font.PLAIN, 50)); 
			g.drawString("Game Over", getWidth()/2 - g.getFontMetrics().stringWidth("Game Over")/2, getHeight()/2);
			g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20)); 
			g.drawString("Score: "+score*100, getWidth()/2 - g.getFontMetrics().stringWidth("Score: "+score*100)/2, getHeight()/2+70);
		}
	}

	public void update() {
		if (!gameover) {
			player.move();
			if (player.getPositionX() < 0 || player.getPositionY() < 0 || player.getPositionX() > getWidth() ||  player.getPositionY() > getHeight()  || player.checkTrail(player.getTrail())) {
				gameover = true;
			}
			if(player.getPositionX() == fruitX+GRIDSIZE/2 && player.getPositionY() == fruitY+GRIDSIZE/2)
			{
				player.getTrail().add(new Point(player.getPositionX(), player.getPositionY()));
				fruitX = (int)(Math.random()*(getWidth()-1)/GRIDSIZE)*GRIDSIZE;
				fruitY = (int)(Math.random()*(getHeight()-1)/GRIDSIZE)*GRIDSIZE;
				score++;
				setMs(Math.max(1, getMs()-5));
			}
		}
		

	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			startGame();
		}
		player.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);
	}
}
