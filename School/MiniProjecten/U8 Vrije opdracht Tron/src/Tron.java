import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Tron extends AnimationPanel {

	private Player p1, p2;
	private final static int GRIDSIZE = 20;
	private int victory; // 0=running, 1=player1 win, 2=player2 win

	public Tron() {
		super(100);
		startGame();
	}

	private void startGame() {
		p1 = new Player(10, 250, 1, Color.ORANGE, KeyEvent.VK_W, KeyEvent.VK_D,
				KeyEvent.VK_S, KeyEvent.VK_A);
		p2 = new Player(790, 250, 3, Color.CYAN, KeyEvent.VK_UP,
				KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT);
		victory = 0;
	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);

		for (int x = 0; x < 800; x += GRIDSIZE) {
			for (int y = 0; y < 600; y += GRIDSIZE) {
				g.drawRect(x, y, GRIDSIZE, GRIDSIZE);
			}

		}

		p1.paint(g);
		p2.paint(g);
		if(victory != 0) {
			g.setColor(new Color(0, 0, 0, 100));
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.PINK);
			g.setFont(new Font("Comic Sans MS", Font.PLAIN, 50)); 
			g.drawString("Speler " + victory + " heeft gewonnen!", getWidth()/2 - g.getFontMetrics().stringWidth("Speler 1 heeft gewonnen!")/2, getHeight()/2);
		}
	}

	public void update() {
		if (victory == 0) {
			p1.move();
			p2.move();
			if (p1.getPositionX() < 0 || p1.getPositionY() < 0 || p1.getPositionX() > getWidth() ||  p1.getPositionY() > getHeight()  || p1.checkTrail(p1.getTrail()) || p1.checkTrail(p2.getTrail())) {
				victory = 2;
			}
			if (p2.getPositionX() < 0 || p2.getPositionY() < 0 || p2.getPositionX() > getWidth() ||  p2.getPositionY() > getHeight()  || p2.checkTrail(p1.getTrail()) || p2.checkTrail(p2.getTrail())) {
				victory = 1;
			}
		}

	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			startGame();
		}
		p1.keyPressed(e);
		p2.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		p1.keyReleased(e);
		p2.keyReleased(e);
	}
}
